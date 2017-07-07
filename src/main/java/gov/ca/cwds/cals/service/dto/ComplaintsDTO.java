package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Response;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CWDS CALS API Team
 */

public class ComplaintsDTO extends BaseDTO implements Response {

    private static final long serialVersionUID = -5045346074331689606L;

    @JsonProperty("complaints")
    private Set<ComplaintDTO> complaints = new HashSet<>();

    public Set<ComplaintDTO> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<ComplaintDTO> complaints) {
        this.complaints = complaints;
    }

}
