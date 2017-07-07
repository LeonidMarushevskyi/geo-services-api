package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.RelationshipToApplicantType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RelationshipToApplicantDTO extends BaseDTO {

  private static final long serialVersionUID = 8554818249973630219L;

  @JsonProperty("relationship_to_applicant")
  @ApiModelProperty(value = "Relationship to Applicant")
  private RelationshipToApplicantType relationshipToApplicantType;

  @ApiModelProperty(value = "Applicant Id", example = "1234567")
  private Long applicantId;

  public RelationshipToApplicantType getRelationshipToApplicantType() {
    return relationshipToApplicantType;
  }

  public void setRelationshipToApplicantType(
      RelationshipToApplicantType relationshipToApplicantType) {
    this.relationshipToApplicantType = relationshipToApplicantType;
  }

  public Long getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Long applicantId) {
    this.applicantId = applicantId;
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}

