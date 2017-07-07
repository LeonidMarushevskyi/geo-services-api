package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author CWDS CALS API Team
 */
public class DistrictOfficeDTO extends BaseDTO {

    private static final long serialVersionUID = -6573472953019773477L;
    
    @RemoveTrailingSpaces
    @JsonProperty("number")
    @NotNull
    @ApiModelProperty(required = true, readOnly = false, value = "District Office Number", example = "21")
    private String number;

    @RemoveTrailingSpaces
    @JsonProperty("name")
    @NotNull
    @ApiModelProperty(required = true, readOnly = false, value = "District Office Name", example = "NO. CAL AC/SC")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
