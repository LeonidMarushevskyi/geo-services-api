package gov.ca.cwds.geo.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.api.domain.DomainObject;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

/**
 * {@link DomainObject} representing an address that is validated or standardized via SmartyStreets
 * 
 * @author CWDS API Team
 */
@JsonSnakeCase
public class ValidatedAddress implements Request, Response {
  /**
   * Serialization version
   */
  private static final long serialVersionUID = 1L;

  @JsonProperty("zip")
  @ApiModelProperty(example = "95827")
  private Integer zip;

  @JsonProperty("city")
  @ApiModelProperty(example = "Sacramento")
  @Size(max = 50)
  private String city;

  @JsonProperty("street_address")
  @ApiModelProperty(example = "9500 Kiefer Blvd")
  @Size(max = 50)
  private String streetAddress;


  @JsonProperty("state")
  @ApiModelProperty(example = "CA")
  @Size(max = 50)
  private String state;

  @JsonProperty("longitude")
  @ApiModelProperty(example = "-121.34332")
  private Double longitude;

  @JsonProperty("lattitude")
  @ApiModelProperty(example = "38.5445")
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
   * @param longitude The longitude
   * @param lattitude The lattitude
   * @param deliverable The smarty street deliverable status
   */
  @JsonCreator
  public ValidatedAddress(@JsonProperty("street_address") String streetAddress,
      @JsonProperty("city") String city, @JsonProperty("state") String state,
      @JsonProperty("zip") Integer zip, @JsonProperty("longitude") Double longitude,
      @JsonProperty("lattitude") Double lattitude, @JsonProperty("delivery") Boolean deliverable) {
    super();
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.longitude = longitude;
    this.lattitude = lattitude;
    this.deliverable = deliverable;
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
   * @return the zip
   */
  public Integer getZip() {
    return zip;
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


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((deliverable == null) ? 0 : deliverable.hashCode());
    result = prime * result + ((lattitude == null) ? 0 : lattitude.hashCode());
    result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
    result = prime * result + ((zip == null) ? 0 : zip.hashCode());
    return result;
  }


  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public final boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(getClass().isInstance(obj))) {
      return false;
    }
    ValidatedAddress other = (ValidatedAddress) obj;
    if (city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!city.equals(other.city)) {
      return false;
    }
    if (deliverable == null) {
      if (other.deliverable != null) {
        return false;
      }
    } else if (!deliverable.equals(other.deliverable)) {
      return false;
    }
    if (lattitude == null) {
      if (other.lattitude != null) {
        return false;
      }
    } else if (!lattitude.equals(other.lattitude)) {
      return false;
    }
    if (longitude == null) {
      if (other.longitude != null) {
        return false;
      }
    } else if (!longitude.equals(other.longitude)) {
      return false;
    }
    if (state == null) {
      if (other.state != null) {
        return false;
      }
    } else if (!state.equals(other.state)) {
      return false;
    }
    if (streetAddress == null) {
      if (other.streetAddress != null) {
        return false;
      }
    } else if (!streetAddress.equals(other.streetAddress)) {
      return false;
    }
    if (zip == null) {
      if (other.zip != null) {
        return false;
      }
    } else if (!zip.equals(other.zip)) {
      return false;
    }
    return true;
  }

}
