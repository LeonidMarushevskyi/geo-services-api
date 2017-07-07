package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.GenderType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.SchoolGradeType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@SuppressWarnings("squid:S3437") // Dates should be serialized
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdentifiedChildDTO extends BaseDTO {

  private static final long serialVersionUID = -3350081068637258668L;

  @ApiModelProperty(example = "Collin")
  private String firstName;

  @ApiModelProperty(example = "P.")
  private String middleName;

  @ApiModelProperty(example = "Martin")
  private String lastName;

  @ApiModelProperty(example = "2007-07-14")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfBirth;

  private GenderType gender;

  private CountyType countyOfJurisdiction;

  @ApiModelProperty(example = "2017-05-14")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfPlacement;

  private List<RelationshipToApplicantDTO> relationshipToApplicants = new ArrayList<>();

  private SchoolGradeType schoolGrade;

  @ApiModelProperty(example = "White Oaks High")
  private String schoolName;

  private RFAAddressDTO schoolAddress;

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

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public GenderType getGender() {
    return gender;
  }

  public void setGender(GenderType gender) {
    this.gender = gender;
  }

  public CountyType getCountyOfJurisdiction() {
    return countyOfJurisdiction;
  }

  public void setCountyOfJurisdiction(
      CountyType countyOfJurisdiction) {
    this.countyOfJurisdiction = countyOfJurisdiction;
  }

  public LocalDate getDateOfPlacement() {
    return dateOfPlacement;
  }

  public void setDateOfPlacement(LocalDate dateOfPlacement) {
    this.dateOfPlacement = dateOfPlacement;
  }

  public List<RelationshipToApplicantDTO> getRelationshipToApplicants() {
    return relationshipToApplicants;
  }

  public void setRelationshipToApplicants(
      List<RelationshipToApplicantDTO> relationshipToApplicants) {
    this.relationshipToApplicants = relationshipToApplicants;
  }

  public SchoolGradeType getSchoolGrade() {
    return schoolGrade;
  }

  public void setSchoolGrade(
      SchoolGradeType schoolGrade) {
    this.schoolGrade = schoolGrade;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public RFAAddressDTO getSchoolAddress() {
    return schoolAddress;
  }

  public void setSchoolAddress(RFAAddressDTO schoolAddress) {
    this.schoolAddress = schoolAddress;
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
