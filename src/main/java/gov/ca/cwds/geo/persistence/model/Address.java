package gov.ca.cwds.geo.persistence.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.domain.DomainObject;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

/**
 * {@link DomainObject} representing an address
 *
 * @author CWDS API Team
 */
@JsonSnakeCase
@ApiModel("nsAddress")
public class Address implements Request {

  /** Base serialization value. Increment by version */
  private static final long serialVersionUID = 1L;

  @JsonProperty("street_address")
  @ApiModelProperty(example = "202 Spurlock Ct")
  @NotNull
  @Size(max = 100)
  private String streetAddress;

  @JsonProperty("city")
  @ApiModelProperty(value = "City", example = "Roseville")
  @Size(max = 50)
  private String city;

  @JsonProperty("state")
  @ApiModelProperty(value = "State Code", example = "CA")
  @Size(min = 2, max = 2)
  private String state;

  @JsonProperty("zip")
  @ApiModelProperty(value = "Zip", example = "95661")
  @Size(min = 5, max = 5)
  private String zip;

  /**
   * Constructor
   *
   * @param streetAddress - street address
   * @param city - city
   * @param state - state
   * @param zip - zip code
   * @param type the address type
   */
  @JsonCreator
  public Address(
      @JsonProperty("street_address") String streetAddress,
      @JsonProperty("city") String city,
      @JsonProperty("state") String state,
      @JsonProperty("zip") String zip,
      @JsonProperty("type") String type) {
    super();
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  /** @return street address */
  public String getStreetAddress() {
    return streetAddress;
  }

  /** @return city */
  public String getCity() {
    return city;
  }

  /** @return the state */
  public String getState() {
    return state;
  }

  /** @return zip code */
  public String getZip() {
    return zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }

    Address address = (Address) o;

    if (getStreetAddress() != null ? !getStreetAddress().equals(address.getStreetAddress())
        : address.getStreetAddress() != null) {
      return false;
    }
    if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) {
      return false;
    }
    if (getState() != null ? !getState().equals(address.getState()) : address.getState() != null) {
      return false;
    }
    return getZip() != null ? getZip().equals(address.getZip()) : address.getZip() == null;
  }

  @Override
  public int hashCode() {
    int result = getStreetAddress() != null ? getStreetAddress().hashCode() : 0;
    result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
    result = 31 * result + (getState() != null ? getState().hashCode() : 0);
    result = 31 * result + (getZip() != null ? getZip().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return Stream.of(streetAddress, city, state, zip)
        .filter(StringUtils::isNotEmpty)
        .collect(Collectors.joining(", "));
  }
}
