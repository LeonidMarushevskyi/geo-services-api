package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.persistence.dao.fas.InspectionDao;
import gov.ca.cwds.cals.service.dto.FacilityInspectionsDTO;
import gov.ca.cwds.cals.service.mapper.FacilityInspectionMapper;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */
public class FacilityInspectionCollectionService extends CrudServiceAdapter {

    private FacilityInspectionMapper facilityInspectionMapper;
    private InspectionDao inspectionDao;

    @Inject
    public FacilityInspectionCollectionService(FacilityInspectionMapper facilityInspectionMapper,
                                               InspectionDao inspectionDao) {
        this.facilityInspectionMapper = facilityInspectionMapper;
        this.inspectionDao = inspectionDao;
    }

    @Override
    public Response find(Serializable facilityId) {
        Response res = null;
        final FacilityInspectionsDTO dto = new FacilityInspectionsDTO();
        List<Rr809Dn> deficiencies = inspectionDao.findDeficienciesByFacilityNumber((Integer) facilityId);
        deficiencies.forEach(def -> 
            dto.getInspections().add(facilityInspectionMapper.toFacilityInspectionDto(def)));
        if (dto.getInspections() != null && !dto.getInspections().isEmpty()) {
            res = dto;
        }
        return res;
    }
}
