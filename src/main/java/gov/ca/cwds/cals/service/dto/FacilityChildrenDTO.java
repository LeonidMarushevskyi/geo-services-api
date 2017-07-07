package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CWDS CALS API Team
 *
 */
public class FacilityChildrenDTO extends BaseDTO implements Response {

    private static final long serialVersionUID = -5195502655333485625L;

    @JsonProperty("children")
    private List<FacilityChildDTO> children = new ArrayList<>();

    public List<FacilityChildDTO> getChildren() {
        return children;
    }

    public void setChildren(List<FacilityChildDTO> children) {
        this.children = children;
    }

}
