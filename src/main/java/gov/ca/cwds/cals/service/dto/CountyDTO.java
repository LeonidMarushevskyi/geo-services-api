package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */
public class CountyDTO extends DictionaryDTO {

    private static final long serialVersionUID = -7976061092080021333L;
    
    @RemoveTrailingSpaces
    private String lisCode;

    @ApiModelProperty(readOnly = true, value = "LIS (legacy) Dictionary Code", example = "01")
    @JsonProperty("lis_code")
    public String getLisCode() {
        return lisCode;
    }

    public void setLisCode(String lisCode) {
        this.lisCode = lisCode;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCode()).append(getDescription()).append(lisCode).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        CountyDTO countyDTO = (CountyDTO) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.appendSuper(super.equals(obj));
        equalsBuilder.append(lisCode, countyDTO.lisCode);
        return equalsBuilder.isEquals();
    }

}
