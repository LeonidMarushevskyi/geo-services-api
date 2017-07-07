package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
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
public class RFA1bFormDTO extends RFAExternalEntityDTO {

  private static final long serialVersionUID = 2700499740023492461L;

  private CountyType applicationCounty;

  @ApiModelProperty(example = "true")
  private boolean livedInOtherState;

  private List<StateType> otherStatesOfLiving;

  @ApiModelProperty(example = "false")
  private boolean convictedInCalifornia;

  @ApiModelProperty(example = "false")
  private boolean convictedInAnotherState;

  @ApiModelProperty(example = "false")
  private boolean arrestedForCrime;

  @ApiModelProperty(example = "Peterson")
  private String resourceFamilyName;

  @ApiModelProperty(example = "123")
  private boolean rfa1aApplicantId;

  @ApiModelProperty(example = "Anna")
  private String applicantFirstName;

  @ApiModelProperty(example = "M.")
  private String applicantMiddleName;

  @ApiModelProperty(example = "Peterson")
  private String applicantLastName;

  private RFAAddressDTO residenceAddress;

  @ApiModelProperty(example = "464-94-2323")
  private String ssn;

  @ApiModelProperty(example = "1981-12-26")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfBirth;

  @ApiModelProperty(example = "MD123-1234-585-121")
  private String driverLicense;

  private StateType driverLicenseState;

  @ApiModelProperty(example = "Anna Peterson")
  private String signature;

  @ApiModelProperty(example = "2017-07-02")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate applicationDate;

  private List<DisclosureDTO> disclosures = new ArrayList<>();

  public CountyType getApplicationCounty() {
    return applicationCounty;
  }

  public void setApplicationCounty(
      CountyType applicationCounty) {
    this.applicationCounty = applicationCounty;
  }

  public boolean isLivedInOtherState() {
    return livedInOtherState;
  }

  public void setLivedInOtherState(boolean livedInOtherState) {
    this.livedInOtherState = livedInOtherState;
  }

  public List<StateType> getOtherStatesOfLiving() {
    return otherStatesOfLiving;
  }

  public void setOtherStatesOfLiving(
      List<StateType> otherStatesOfLiving) {
    this.otherStatesOfLiving = otherStatesOfLiving;
  }

  public boolean isConvictedInCalifornia() {
    return convictedInCalifornia;
  }

  public void setConvictedInCalifornia(boolean convictedInCalifornia) {
    this.convictedInCalifornia = convictedInCalifornia;
  }

  public boolean isConvictedInAnotherState() {
    return convictedInAnotherState;
  }

  public void setConvictedInAnotherState(boolean convictedInAnotherState) {
    this.convictedInAnotherState = convictedInAnotherState;
  }

  public boolean isArrestedForCrime() {
    return arrestedForCrime;
  }

  public void setArrestedForCrime(boolean arrestedForCrime) {
    this.arrestedForCrime = arrestedForCrime;
  }

  public String getResourceFamilyName() {
    return resourceFamilyName;
  }

  public void setResourceFamilyName(String resourceFamilyName) {
    this.resourceFamilyName = resourceFamilyName;
  }

  public boolean isRfa1aApplicantId() {
    return rfa1aApplicantId;
  }

  public void setRfa1aApplicantId(boolean rfa1aApplicantId) {
    this.rfa1aApplicantId = rfa1aApplicantId;
  }

  public String getApplicantFirstName() {
    return applicantFirstName;
  }

  public void setApplicantFirstName(String applicantFirstName) {
    this.applicantFirstName = applicantFirstName;
  }

  public String getApplicantMiddleName() {
    return applicantMiddleName;
  }

  public void setApplicantMiddleName(String applicantMiddleName) {
    this.applicantMiddleName = applicantMiddleName;
  }

  public String getApplicantLastName() {
    return applicantLastName;
  }

  public void setApplicantLastName(String applicantLastName) {
    this.applicantLastName = applicantLastName;
  }

  public RFAAddressDTO getResidenceAddress() {
    return residenceAddress;
  }

  public void setResidenceAddress(RFAAddressDTO residenceAddress) {
    this.residenceAddress = residenceAddress;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getDriverLicense() {
    return driverLicense;
  }

  public void setDriverLicense(String driverLicense) {
    this.driverLicense = driverLicense;
  }

  public StateType getDriverLicenseState() {
    return driverLicenseState;
  }

  public void setDriverLicenseState(
      StateType driverLicenseState) {
    this.driverLicenseState = driverLicenseState;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(LocalDate applicationDate) {
    this.applicationDate = applicationDate;
  }

  public List<DisclosureDTO> getDisclosures() {
    return disclosures;
  }

  public void setDisclosures(
      List<DisclosureDTO> disclosures) {
    this.disclosures = disclosures;
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
