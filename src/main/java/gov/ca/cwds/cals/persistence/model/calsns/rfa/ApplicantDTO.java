package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.EducationLevelType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.EthnicityType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.GenderType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.RaceType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import java.io.Serializable;
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
public class ApplicantDTO extends RFAExternalEntityDTO implements Serializable {

  private static final long serialVersionUID = -4333411852074578122L;

  private String firstName;

  private String middleName;

  private String lastName;

  private List<TypedPersonNameDTO> otherNames = new ArrayList<>();

  private EducationLevelType highestEducationLevel;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate dateOfBirth;

  private GenderType gender;

  private RaceType race;

  private EthnicityType ethnicity;

  private String driverLicenseNumber;

  private StateType driverLicenseState;

  private String email;

  private EmploymentDTO employment;

  private List<PhoneDTO> phones = new ArrayList<>();

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

  public List<TypedPersonNameDTO> getOtherNames() {
    return otherNames;
  }

  public void setOtherNames(List<TypedPersonNameDTO> otherNames) {
    this.otherNames = otherNames;
  }

  public EducationLevelType getHighestEducationLevel() {
    return highestEducationLevel;
  }

  public void setHighestEducationLevel(EducationLevelType highestEducationLevel) {
    this.highestEducationLevel = highestEducationLevel;
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

  public RaceType getRace() {
    return race;
  }

  public void setRace(RaceType race) {
    this.race = race;
  }

  public EthnicityType getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(EthnicityType ethnicity) {
    this.ethnicity = ethnicity;
  }

  public String getDriverLicenseNumber() {
    return driverLicenseNumber;
  }

  public void setDriverLicenseNumber(String driverLicenseNumber) {
    this.driverLicenseNumber = driverLicenseNumber;
  }

  public StateType getDriverLicenseState() {
    return driverLicenseState;
  }

  public void setDriverLicenseState(StateType driverLicenseState) {
    this.driverLicenseState = driverLicenseState;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmploymentDTO getEmployment() {
    return employment;
  }

  public void setEmployment(EmploymentDTO employment) {
    this.employment = employment;
  }

  public List<PhoneDTO> getPhones() {
    return phones;
  }

  public void setPhones(List<PhoneDTO> phones) {
    this.phones = phones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicantDTO)) {
      return false;
    }
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
