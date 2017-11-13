package gov.ca.cwds.geo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.geo.persistence.model.Address;
import io.dropwizard.jackson.JsonSnakeCase;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CWDS TPT-3 Team
 */
@JsonSnakeCase
public class CalculateDistanceDTO {

  @JsonProperty("first_address")
  @Valid
  @NotNull
  private Address firstAddress;

  @JsonProperty("second_address")
  @Valid
  @NotNull
  private Address secondAddress;

  public Address getFirstAddress() {
    return firstAddress;
  }

  public void setFirstAddress(Address firstAddress) {
    this.firstAddress = firstAddress;
  }

  public Address getSecondAddress() {
    return secondAddress;
  }

  public void setSecondAddress(Address secondAddress) {
    this.secondAddress = secondAddress;
  }
}
