package gov.ca.cwds.geo.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.api.domain.DomainObject;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * {@link DomainObject} representing an address that is validated or standardized via SmartyStreets
 * 
 * @author CWDS API Team
 */
@JsonSnakeCase
public class ValidatedAddressDTO extends BaseDTO implements Request, Response {
  /**
   * Serialization version
   */
  private static final long serialVersionUID = 1L;

  @JsonProperty("zip")
  @ApiModelProperty(example = "95661")
  private String zip;

  @JsonProperty("zip_extension")
  @ApiModelProperty(value = "Zip Extension", example = "123")
  @Max(99999)
  private String zipExtension;

  @JsonProperty("city")
  @ApiModelProperty(example = "Roseville")
  @Size(max = 50)
  private String city;

  @JsonProperty("street_address")
  @ApiModelProperty(example = "202 Spurlock Ct")
  @Size(max = 50)
  private String streetAddress;


  @JsonProperty("state")
  @ApiModelProperty(example = "California")
  @Size(max = 50)
  private String state;

  @JsonProperty("state_abbreviation")
  @ApiModelProperty(example = "CA")
  @Size(max = 2)
  private String stateAbbreviation;

  @JsonProperty("longitude")
  @ApiModelProperty(example = "-121.25118")
  private Double longitude;

  @JsonProperty("lattitude")
  @ApiModelProperty(example = "38.74037")
  private Double lattitude;

  @JsonProperty("deliverable")
  @ApiModelProperty(example = "true")
  private Boolean deliverable;


  /**
   * Constructor
   * 
   * @param streetAddress The validated street address
   * @param city The validated city
   * @param state The validated state
   * @param zip The validated zip
   * @param zipExtension The validated zip
   * @param longitude The longitude
   * @param lattitude The lattitude
   * @param deliverable The smarty street deliverable status
   */
  @JsonCreator
  public ValidatedAddressDTO(@JsonProperty("street_address") String streetAddress,
      @JsonProperty("city") String city, @JsonProperty("state") String state, @JsonProperty("state_abbreviation") String stateAbbreviation,
      @JsonProperty("zip") String zip, @JsonProperty("zip_extension") String zipExtension, @JsonProperty("longitude") Double longitude,
      @JsonProperty("lattitude") Double lattitude, @JsonProperty("delivery") Boolean deliverable) {
    super();
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.zipExtension = zipExtension;
    this.longitude = longitude;
    this.lattitude = lattitude;
    this.deliverable = deliverable;
    this.stateAbbreviation = stateAbbreviation;
  }

  /**
   * @return the streetAddress
   */
  public String getStreetAddress() {
    return streetAddress;
  }


  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }


  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @return the state
   */
  public String getStateAbbreviation() {
    return stateAbbreviation;
  }

  /**
   * @return the zip
   */
  public String getZip() {
    return zip;
  }

  /** @return zip extension code */
  public String getZipExtension() {
    return zipExtension;
  }

  /**
   * @return the longitude
   */
  public Double getLongitude() {
    return longitude;
  }


  /**
   * @return the lattitude
   */
  public Double getLattitude() {
    return lattitude;
  }


  /**
   * @return the deliverable
   */
  public Boolean getDeliverable() {
    return deliverable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ValidatedAddressDTO)) {
      return false;
    }

    ValidatedAddressDTO that = (ValidatedAddressDTO) o;

    if (getZip() != null ? !getZip().equals(that.getZip()) : that.getZip() != null) {
      return false;
    }
    if (getZipExtension() != null ? !getZipExtension().equals(that.getZipExtension())
        : that.getZipExtension() != null) {
      return false;
    }
    if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) {
      return false;
    }
    if (getStreetAddress() != null ? !getStreetAddress().equals(that.getStreetAddress())
        : that.getStreetAddress() != null) {
      return false;
    }
    if (getState() != null ? !getState().equals(that.getState()) : that.getState() != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = getZip() != null ? getZip().hashCode() : 0;
    result = 31 * result + (getZipExtension() != null ? getZipExtension().hashCode() : 0);
    result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
    result = 31 * result + (getStreetAddress() != null ? getStreetAddress().hashCode() : 0);
    result = 31 * result + (getState() != null ? getState().hashCode() : 0);
    result = 31 * result + (getStateAbbreviation() != null ? getStateAbbreviation().hashCode() : 0);
    result = 31 * result + (getLongitude() != null ? getLongitude().hashCode() : 0);
    result = 31 * result + (getLattitude() != null ? getLattitude().hashCode() : 0);
    result = 31 * result + (getDeliverable() != null ? getDeliverable().hashCode() : 0);
    return result;
  }
}
