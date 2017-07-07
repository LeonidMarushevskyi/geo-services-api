package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.lisfas.FacilityType;
import gov.ca.cwds.cals.persistence.dao.lis.FacilityTypeDao;
import gov.ca.cwds.cals.service.dto.FacilityTypeDTO;
import gov.ca.cwds.cals.service.dto.FacilityTypesDTO;
import gov.ca.cwds.cals.service.mapper.FacilityTypeMapper;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/** @author CWDS CALS API Team */
public class FacilityTypeCollectionService extends CrudServiceAdapter {
  private FacilityTypeDao facilityTypeDao;
  private FacilityTypeMapper facilityTypeMapper;

  @Inject
  public FacilityTypeCollectionService(
      FacilityTypeDao facilityTypeDao, FacilityTypeMapper facilityTypeMapper) {
    this.facilityTypeDao = facilityTypeDao;
    this.facilityTypeMapper = facilityTypeMapper;
  }

  @Override
  public Response find(Serializable params) {
    List<FacilityType> facilityTypes = facilityTypeDao.findAll();
    List<FacilityTypeDTO> facilityTypeDTOs = facilityTypeMapper.toFacilityTypeDTO(facilityTypes);
    Collections.sort(
        facilityTypeDTOs, (o1, o2) -> o1.getDescription().compareToIgnoreCase(o2.getDescription()));
    FacilityTypesDTO facilityTypesDTO = new FacilityTypesDTO();
    facilityTypesDTO.setFacilityTypes(facilityTypeDTOs);
    return facilityTypesDTO;
  }
}
