package gov.ca.cwds.geo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.api.Response;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

/**
 * @author CWDS TPT-3 Team
 */
@JsonSnakeCase
public class DistanceDTO extends BaseDTO implements Response {

  @JsonProperty("human_readable_in_miles")
  @ApiModelProperty(example = "9.0 mi")
  @Size(max = 50)
  private String humanReadableInMiles;

  @JsonProperty
  @ApiModelProperty(example = "14454")
  private Long meters;

  public String getHumanReadableInMiles() {
    return humanReadableInMiles;
  }

  public void setHumanReadableInMiles(String humanReadableInMiles) {
    this.humanReadableInMiles = humanReadableInMiles;
  }

  public Long getMeters() {
    return meters;
  }

  public void setMeters(Long meters) {
    this.meters = meters;
  }
}
