package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * A DTO for the Phone entity.
 */

public class PhoneDTO extends BaseDTO {

    private static final long serialVersionUID = 845164274506455774L;

    private Long id;

    @RemoveTrailingSpaces
    @JsonProperty("relation")
    @ApiModelProperty(required = false, value = "Phone Relation", example = "Alternative")
    private String relation;

    @RemoveTrailingSpaces
    @JsonProperty("type")
    @ApiModelProperty(required = false, value = "Phone type", example = "Cell")
    private String type;

    @RemoveTrailingSpaces
    @NotNull
    @Size(max = 16)
    @JsonProperty("number")
    @ApiModelProperty(required = true, value = "Phone number", example = "(494) 823-8588")
    private String number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneDTO phoneDTO = (PhoneDTO) o;

        return Objects.equals(id, phoneDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
