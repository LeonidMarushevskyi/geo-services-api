package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ApplicantRelationshipType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.MarriageTerminationReason;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@SuppressWarnings("squid:S3437") // Dates should be serialized
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FormerSpouseDTO extends BaseDTO {

  private static final long serialVersionUID = 4825726415538736618L;

  @ApiModelProperty("Relationship Type")
  private ApplicantRelationshipType relationshipType;

  @ApiModelProperty(value = "Applicant Id", example = "1234567")
  private Long applicantId;

  @ApiModelProperty(value = "First Name", example = "Anna")
  private String firstName;

  @ApiModelProperty(value = "Middle Name", example = "L.")
  private String middleName;

  @ApiModelProperty(value = "Last Name", example = "Pollen")
  private String lastName;

  @ApiModelProperty(value = "Marriage/Domestic partnership date", example = "2016-12-26")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfMarriage;

  @ApiModelProperty(value = "Marriage/Domestic partnership place: city", example = "Sacramento")
  private String placeOfMarriageCity;

  @ApiModelProperty("Marriage/Domestic partnership place: state")
  private StateType placeOfMarriageState;

  @ApiModelProperty("Divorce/Domestic Partnership Termination reason")
  private MarriageTerminationReason marriageTerminationReason;

  @ApiModelProperty(value = "Divorce/Domestic Partnership Termination Date", example = "2016-12-26")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfMarriageEnd;

  @ApiModelProperty(value = "Divorce/Domestic Partnership Termination City", example = "Sacramento")
  private String placeOfMarriageEndCity;

  @ApiModelProperty("Divorce/Domestic Partnership Termination State")
  private StateType placeOfMarriageEndState;

  public ApplicantRelationshipType getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(
      ApplicantRelationshipType relationshipType) {
    this.relationshipType = relationshipType;
  }

  public Long getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Long applicantId) {
    this.applicantId = applicantId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfMarriage() {
    return dateOfMarriage;
  }

  public void setDateOfMarriage(LocalDate dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
  }

  public String getPlaceOfMarriageCity() {
    return placeOfMarriageCity;
  }

  public void setPlaceOfMarriageCity(String placeOfMarriageCity) {
    this.placeOfMarriageCity = placeOfMarriageCity;
  }

  public StateType getPlaceOfMarriageState() {
    return placeOfMarriageState;
  }

  public void setPlaceOfMarriageState(
      StateType placeOfMarriageState) {
    this.placeOfMarriageState = placeOfMarriageState;
  }

  public MarriageTerminationReason getMarriageTerminationReason() {
    return marriageTerminationReason;
  }

  public void setMarriageTerminationReason(
      MarriageTerminationReason marriageTerminationReason) {
    this.marriageTerminationReason = marriageTerminationReason;
  }

  public LocalDate getDateOfMarriageEnd() {
    return dateOfMarriageEnd;
  }

  public void setDateOfMarriageEnd(LocalDate dateOfMarriageEnd) {
    this.dateOfMarriageEnd = dateOfMarriageEnd;
  }

  public String getPlaceOfMarriageEndCity() {
    return placeOfMarriageEndCity;
  }

  public void setPlaceOfMarriageEndCity(String placeOfMarriageEndCity) {
    this.placeOfMarriageEndCity = placeOfMarriageEndCity;
  }

  public StateType getPlaceOfMarriageEndState() {
    return placeOfMarriageEndState;
  }

  public void setPlaceOfMarriageEndState(
      StateType placeOfMarriageEndState) {
    this.placeOfMarriageEndState = placeOfMarriageEndState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FormerSpouseDTO)) {
      return false;
    }
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }


}
