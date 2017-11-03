package gov.ca.cwds.geo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Response;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author CWDS TPT-3 Team
 */
@JsonSnakeCase
public class DistanceDTO extends BaseDTO implements Response {

  @JsonProperty
  @ApiModelProperty(example = "14.0")
  private Double miles;

  public DistanceDTO() {
  }

  public DistanceDTO(Double miles) {
    this.miles = miles;
  }

  public Double getMiles() {
    return miles;
  }

  public void setMiles(Double miles) {
    this.miles = miles;
  }
}
