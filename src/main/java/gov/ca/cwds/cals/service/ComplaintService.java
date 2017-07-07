package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.fas.ComplaintReportLic802;
import gov.ca.cwds.cals.persistence.dao.fas.ComplaintReportLic802Dao;
import gov.ca.cwds.cals.service.mapper.ComplaintMapper;
import gov.ca.cwds.cals.web.rest.exception.UserFriendlyException;
import gov.ca.cwds.cals.web.rest.parameter.FacilityComplaintParameterObject;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.CrudsService;

import java.io.Serializable;

import static gov.ca.cwds.cals.web.rest.exception.CalsExceptionInfo.COMPLAINT_NOT_FOUND_BY_ID;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * @author CWDS CALS API Team
 */

public class ComplaintService implements CrudsService {

    private ComplaintReportLic802Dao complaintReportLic802Dao;
    private ComplaintMapper complaintMapper;

    @Inject
    public ComplaintService(ComplaintReportLic802Dao complaintReportLic802Dao,
            ComplaintMapper complaintMapper) {
        this.complaintReportLic802Dao = complaintReportLic802Dao;
        this.complaintMapper = complaintMapper;
    }

    @Override
    public Response find(Serializable parametersObject) {
        FacilityComplaintParameterObject parameterObject = null;
        if (parametersObject instanceof FacilityComplaintParameterObject) {
            parameterObject = (FacilityComplaintParameterObject) parametersObject;
            ComplaintReportLic802 complaintReportLic802 =complaintReportLic802Dao.findComplaintByFacilityIdAndComplaintId(
                    parameterObject.getFacilityId(), parameterObject.getComplaintId());
            if (complaintReportLic802 == null) {
                throw new UserFriendlyException(COMPLAINT_NOT_FOUND_BY_ID, NOT_FOUND);
            } else {
                return complaintMapper.entityToDTO(complaintReportLic802);
            }
        }
        throw new IllegalStateException("FacilityComplaintParameterObject is expected here");
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
