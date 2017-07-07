package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.Utils;
import gov.ca.cwds.cals.persistence.dao.cms.ClientDao;
import gov.ca.cwds.cals.persistence.dao.cms.PlacementHomeDao;
import gov.ca.cwds.cals.persistence.dao.fas.LisFacFileFasDao;
import gov.ca.cwds.cals.persistence.dao.lis.LisFacFileLisDao;
import gov.ca.cwds.cals.persistence.model.cms.BaseCountyLicenseCase;
import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.persistence.model.cms.BaseStaffPerson;
import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.cals.persistence.model.fas.LpaInformation;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.persistence.dao.cms.CountiesDao;
import gov.ca.cwds.cals.persistence.dao.fas.LpaInformationDao;
import gov.ca.cwds.cals.service.dto.FacilityChildDTO;
import gov.ca.cwds.cals.service.dto.FacilityDTO;
import gov.ca.cwds.cals.service.mapper.FacilityChildMapper;
import gov.ca.cwds.cals.service.mapper.FacilityMapper;
import gov.ca.cwds.cals.service.mapper.FasFacilityMapper;
import gov.ca.cwds.cals.web.rest.exception.UserFriendlyException;
import gov.ca.cwds.cals.web.rest.parameter.FacilityParameterObject;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.CrudsService;
import io.dropwizard.hibernate.UnitOfWork;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static gov.ca.cwds.cals.Constants.UnitOfWork.CMS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.FAS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.LIS;
import static gov.ca.cwds.cals.web.rest.exception.CalsExceptionInfo.DISTRICT_OFFICE_IS_UNEXPECTEDLY_UNKNOWN;
import static javax.ws.rs.core.Response.Status.EXPECTATION_FAILED;

/**
 * CRUD service for {@link gov.ca.cwds.cals.service.dto.FacilityDTO}
 *
 * @author CALS API Team
 */
public class FacilityService implements CrudsService {

  private LisFacFileLisDao lisFacFileLisDao;
  private LisFacFileFasDao lisFacFileFasDao;
  private PlacementHomeDao placementHomeDao;
  private CountiesDao countiesDao;
  private FacilityMapper facilityMapper;
  private FasFacilityMapper fasFacilityMapper;
  private LpaInformationDao lpaInformationDao;
  private ClientDao clientDao;
  private FacilityChildMapper facilityChildMapper;


  @Inject
  public FacilityService(LisFacFileLisDao lisFacFileLisDao, LisFacFileFasDao lisFacFileFasDao,
      PlacementHomeDao placementHomeDao, LpaInformationDao lpaInformationDao,
      CountiesDao countiesDao, FacilityMapper facilityMapper, FasFacilityMapper fasFacilityMapper,
      ClientDao clientDao, FacilityChildMapper facilityChildMapper) {
    this.lisFacFileLisDao = lisFacFileLisDao;
    this.lisFacFileFasDao = lisFacFileFasDao;
    this.placementHomeDao = placementHomeDao;
    this.lpaInformationDao = lpaInformationDao;
    this.countiesDao = countiesDao;
    this.facilityMapper = facilityMapper;
    this.fasFacilityMapper = fasFacilityMapper;
    this.clientDao = clientDao;
    this.facilityChildMapper = facilityChildMapper;
  }

  @Override
  public Response find(Serializable params) {
    return findByParameterObject((FacilityParameterObject) params);
  }

  protected FacilityDTO findExpandedById(String id) {
    return findByParameterObject(Utils.createExpandedFacilityParameterObject(id));
  }

  private FacilityDTO findByParameterObject(FacilityParameterObject parameterObject) {
    FacilityDTO facilityDTO = null;
    if (LIS.equals(parameterObject.getUnitOfWork())) {
      facilityDTO = loadFacilityFromLis(parameterObject);
    } else if (CMS.equals(parameterObject.getUnitOfWork())) {
      facilityDTO = loadFacilityFromCwsCms(parameterObject);
    }
    return facilityDTO;
  }

  private FacilityDTO loadFacilityFromLis(FacilityParameterObject parameterObject) {
    LisFacFile lisDsLisFacFile = findLisFacilityByLicenseNumber(parameterObject);
    LpaInformation lpaInformation =
        lisDsLisFacFile != null ? findAssignedWorkerInformation(lisDsLisFacFile) : null;
    FacilityDTO facilityDTO = facilityMapper.toFacilityDTO(lisDsLisFacFile, lpaInformation);

    LisFacFile fasDsLisFacFile = findFasFacilityByLicenseNumber(parameterObject);
    fasFacilityMapper.toFacilityDTO(facilityDTO, fasDsLisFacFile);

    if (parameterObject.isExpanded()) {
      List<FacilityChildDTO> facilityChildren = clientDao.streamByLicenseNumber(parameterObject.getLicenseNumber())
          .map(facilityChildMapper::toFacilityChildDTO).collect(Collectors.toList());
      facilityDTO = facilityMapper.toExpandedFacilityDTO(facilityDTO, facilityChildren);
    }

    return facilityDTO;
  }

  private FacilityDTO loadFacilityFromCwsCms(FacilityParameterObject parameterObject) {
    BasePlacementHome placementHome = findFacilityById(parameterObject);
    FacilityDTO facilityDTO =facilityMapper.toFacilityDTO(placementHome);

    if (parameterObject.isExpanded()) {
      List<FacilityChildDTO> facilityChildren = clientDao.streamByFacilityId(parameterObject.getFacilityId())
          .map(facilityChildMapper::toFacilityChildDTO).collect(Collectors.toList());
      facilityDTO = facilityMapper.toExpandedFacilityDTO(facilityDTO, facilityChildren);
    }

    return facilityDTO;
  }

  @UnitOfWork(LIS)
  protected LisFacFile findLisFacilityByLicenseNumber(FacilityParameterObject parameterObject) {
    return lisFacFileLisDao.find(parameterObject.getLicenseNumber());
  }

  @UnitOfWork(FAS)
  protected LisFacFile findFasFacilityByLicenseNumber(FacilityParameterObject parameterObject) {
    return lisFacFileFasDao.find(parameterObject.getLicenseNumber());
  }

  @UnitOfWork(FAS)
  protected LpaInformation findAssignedWorkerInformation(LisFacFile lisFacFile) {
    if (lisFacFile.getFacDoNbr() == null) {
      throw new UserFriendlyException(DISTRICT_OFFICE_IS_UNEXPECTEDLY_UNKNOWN, EXPECTATION_FAILED);
    }
    String lpaCode =
        String.format("%02d", lisFacFile.getFacDoNbr().getDoNbr()) + lisFacFile.getFacDoEvalCode();
    return lpaInformationDao.findByLpaCode(lpaCode);
  }

  @UnitOfWork(CMS)
  protected BasePlacementHome findFacilityById(FacilityParameterObject parameterObject) {
    // todo refactor to java8
    BasePlacementHome placementHome = placementHomeDao.findByParameterObject(parameterObject);
    if (placementHome != null) {
      BaseCountyLicenseCase countyLicenseCase = placementHome.getCountyLicenseCase();
      if (countyLicenseCase != null) {
        BaseStaffPerson staffPerson = countyLicenseCase.getStaffPerson();
        if (staffPerson != null) {
          County county = countiesDao.findByLogicalId(staffPerson.getCntySpfcd());
          staffPerson.setCounty(county);
        }
      }
    }
    return placementHome;
  }

  @Override
  public Response delete(Serializable serializable) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Response create(Request request) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Response update(Serializable serializable, Request request) {
    throw new UnsupportedOperationException();
  }
}
