package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ApplicantRelationshipType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@SuppressWarnings("squid:S3437") // Dates should be serialized
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicantsRelationshipDTO extends BaseDTO implements Serializable, Request, Response {

  @ApiModelProperty("Relationship between applicants")
  private ApplicantRelationshipType relationshipType;

  @ApiModelProperty(value = "Other type of relationship if it's not in the list", example = "")
  private String otherRelationship;

  @ApiModelProperty(value = "Date of current marriage/Domestic partnership", example = "2015-03-25")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfRelationship;

  @ApiModelProperty(value = "Place of current marriage/Domestic partnership: city", example = "Sacramento")
  private String placeOfRelationshipCity;

  @ApiModelProperty("Place of current marriage/Domestic partnership: state")
  private StateType placeOfRelationshipState;

  public ApplicantRelationshipType getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(
      ApplicantRelationshipType relationshipType) {
    this.relationshipType = relationshipType;
  }

  public String getOtherRelationship() {
    return otherRelationship;
  }

  public void setOtherRelationship(String otherRelationship) {
    this.otherRelationship = otherRelationship;
  }

  public LocalDate getDateOfRelationship() {
    return dateOfRelationship;
  }

  public void setDateOfRelationship(LocalDate dateOfRelationship) {
    this.dateOfRelationship = dateOfRelationship;
  }

  public String getPlaceOfRelationshipCity() {
    return placeOfRelationshipCity;
  }

  public void setPlaceOfRelationshipCity(String placeOfRelationshipCity) {
    this.placeOfRelationshipCity = placeOfRelationshipCity;
  }

  public StateType getPlaceOfRelationshipState() {
    return placeOfRelationshipState;
  }

  public void setPlaceOfRelationshipState(
      StateType placeOfRelationshipState) {
    this.placeOfRelationshipState = placeOfRelationshipState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicantsRelationshipDTO)) {
      return false;
    }
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
