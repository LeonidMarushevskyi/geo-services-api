package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.LanguageType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ResidenceOwnershipType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResidenceDTO extends BaseDTO implements Request, Response {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "List of Addresses")
  private List<RFAAddressDTO> addresses;

  @ApiModelProperty(value = "Is Physical Mailing Similar", example = "false")
  private boolean physicalMailingSimilar;

  @ApiModelProperty(value = "Residence Ownership Type")
  private ResidenceOwnershipType residenceOwnership;

  @ApiModelProperty(value = "Is Weapon In Home", example = "false")
  private boolean weaponInHome;

  @ApiModelProperty(value = "Is Body Of Water Exist", example = "true")
  private boolean bodyOfWaterExist;

  @ApiModelProperty(value = "Body Of Water Description", example = "Description here")
  private String bodyOfWaterDescription;

  @ApiModelProperty(value = "Is Others Using Residence As Mailing", example = "true")
  private boolean othersUsingResidenceAsMailing;

  @ApiModelProperty(value = "Other People Using Residence As Mailing")
  private Set<PersonNameDTO> otherPeopleUsingResidenceAsMailing;

  @ApiModelProperty(value = "Directions To Home", example = "Directions here")
  private String directionsToHome;

  @ApiModelProperty(value = "Home Languages")
  private Set<LanguageType> homeLanguages;

  public List<RFAAddressDTO> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<RFAAddressDTO> addresses) {
    this.addresses = addresses;
  }

  public boolean isPhysicalMailingSimilar() {
    return physicalMailingSimilar;
  }

  public void setPhysicalMailingSimilar(boolean physicalMailingSimilar) {
    this.physicalMailingSimilar = physicalMailingSimilar;
  }

  public ResidenceOwnershipType getResidenceOwnership() {
    return residenceOwnership;
  }

  public void setResidenceOwnership(
      ResidenceOwnershipType residenceOwnership) {
    this.residenceOwnership = residenceOwnership;
  }

  public boolean isWeaponInHome() {
    return weaponInHome;
  }

  public void setWeaponInHome(boolean weaponInHome) {
    this.weaponInHome = weaponInHome;
  }

  public boolean isBodyOfWaterExist() {
    return bodyOfWaterExist;
  }

  public void setBodyOfWaterExist(boolean bodyOfWaterExist) {
    this.bodyOfWaterExist = bodyOfWaterExist;
  }

  public String getBodyOfWaterDescription() {
    return bodyOfWaterDescription;
  }

  public void setBodyOfWaterDescription(String bodyOfWaterDescription) {
    this.bodyOfWaterDescription = bodyOfWaterDescription;
  }

  public boolean isOthersUsingResidenceAsMailing() {
    return othersUsingResidenceAsMailing;
  }

  public void setOthersUsingResidenceAsMailing(boolean othersUsingResidenceAsMailing) {
    this.othersUsingResidenceAsMailing = othersUsingResidenceAsMailing;
  }

  public Set<PersonNameDTO> getOtherPeopleUsingResidenceAsMailing() {
    return otherPeopleUsingResidenceAsMailing;
  }

  public void setOtherPeopleUsingResidenceAsMailing(
      Set<PersonNameDTO> otherPeopleUsingResidenceAsMailing) {
    this.otherPeopleUsingResidenceAsMailing = otherPeopleUsingResidenceAsMailing;
  }

  public String getDirectionsToHome() {
    return directionsToHome;
  }

  public void setDirectionsToHome(String directionsToHome) {
    this.directionsToHome = directionsToHome;
  }

  public Set<LanguageType> getHomeLanguages() {
    return homeLanguages;
  }

  public void setHomeLanguages(
      Set<LanguageType> homeLanguages) {
    this.homeLanguages = homeLanguages;
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
