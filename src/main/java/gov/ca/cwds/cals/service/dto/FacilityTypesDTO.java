package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */
public class FacilityTypesDTO extends BaseDTO implements Response {

    @JsonProperty("facility_types")
    private ArrayList<FacilityTypeDTO> facilityTypes = new ArrayList<>();

    public List<FacilityTypeDTO> getFacilityTypes() {
        return facilityTypes;
    }

    public void setFacilityTypes(List<FacilityTypeDTO> facilityTypeDTOs) {
        this.facilityTypes = new ArrayList<>(facilityTypeDTOs);
    }

}
