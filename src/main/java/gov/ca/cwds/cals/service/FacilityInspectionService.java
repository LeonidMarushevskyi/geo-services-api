package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.persistence.dao.fas.InspectionDao;
import gov.ca.cwds.cals.service.mapper.FacilityInspectionMapper;
import gov.ca.cwds.cals.web.rest.parameter.FacilityInspectionParameterObject;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */
public class FacilityInspectionService extends CrudServiceAdapter {

    private FacilityInspectionMapper facilityInspectionMapper;
    private InspectionDao inspectionDao;


    @Inject
    public FacilityInspectionService(FacilityInspectionMapper facilityInspectionMapper, InspectionDao inspectionDao) {
        this.facilityInspectionMapper = facilityInspectionMapper;
        this.inspectionDao = inspectionDao;
    }

    @Override
    public Response find(Serializable params) {
        FacilityInspectionParameterObject paramsObj = (FacilityInspectionParameterObject) params;
        Rr809Dn rr809Dn = inspectionDao.getDeficiencyByFacilityNumberAndId(paramsObj.getFacilityId(),
                paramsObj.getInspectionId());
        return facilityInspectionMapper.toFacilityInspectionDto(rr809Dn);
    }

}
