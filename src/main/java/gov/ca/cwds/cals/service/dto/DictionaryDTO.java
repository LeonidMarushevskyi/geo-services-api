package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;

/**
 * @author CWDS CALS API Team
 */

public class DictionaryDTO extends BaseDTO {

    private static final long serialVersionUID = -1184272035663245384L;
    
    @RemoveTrailingSpaces
    @JsonProperty("id")
    @NotNull
    @ApiModelProperty(required = true, readOnly = false, value = "Dictionary Status Code", example = "1")
    private String code;

    @RemoveTrailingSpaces
    @JsonProperty("value")
    @NotNull
    @ApiModelProperty(required = true, readOnly = false, value = "Dictionary Status Description", example = "Some dictionary item description")
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(code).append(description).toHashCode();
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
        DictionaryDTO dictionaryDTO = (DictionaryDTO) obj;
        return new EqualsBuilder()
                .append(code, dictionaryDTO.code)
                .append(description, dictionaryDTO.description)
                .isEquals();
    }
}
