package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.fas.ComplaintReportLic802;
import gov.ca.cwds.cals.persistence.dao.fas.ComplaintReportLic802Dao;
import gov.ca.cwds.cals.service.dto.ComplaintsDTO;
import gov.ca.cwds.cals.service.mapper.ComplaintMapper;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.CrudsService;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

public class ComplaintsCollectionService implements CrudsService {

    private ComplaintReportLic802Dao complaintReportLic802Dao;
    private ComplaintMapper complaintMapper;

    @Inject
    public ComplaintsCollectionService(ComplaintReportLic802Dao complaintReportLic802Dao,
            ComplaintMapper complaintMapper) {
        this.complaintReportLic802Dao = complaintReportLic802Dao;
        this.complaintMapper = complaintMapper;
    }

    @Override
    public Response find(Serializable facilityNumber) {
        List<ComplaintReportLic802> facilityComplaints = complaintReportLic802Dao
                .findComplaintsByFacilityNumber((Integer) facilityNumber);
        if (CollectionUtils.isEmpty(facilityComplaints)) {
            return null;
        }
        ComplaintsDTO complaintsDTO = new ComplaintsDTO();
        complaintsDTO.setComplaints(complaintMapper.complaintsListToComplaintsDTOList(facilityComplaints));
        return complaintsDTO;
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
