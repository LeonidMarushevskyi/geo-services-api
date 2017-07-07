package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AddressType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
/**
 * Do not rename class to AddressDTO.
 * In this case swagger will not work properly for some APIs
 */
public class RFAAddressDTO extends BaseDTO {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "Street Address", example = "1702 Redoak Ct.")
  private String streetAddress;

  @ApiModelProperty(value = "zip", example = "98123")
  private String zip;

  @ApiModelProperty(value = "City", example = "Rocklin")
  private String city;

  @ApiModelProperty(value = "State Type")
  private StateType state;

  @ApiModelProperty(value = "Address Type")
  private AddressType type;

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public StateType getState() {
    return state;
  }

  public void setState(StateType state) {
    this.state = state;
  }

  public AddressType getType() {
    return type;
  }

  public void setType(AddressType type) {
    this.type = type;
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