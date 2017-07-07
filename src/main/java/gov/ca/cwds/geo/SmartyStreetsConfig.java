package gov.ca.cwds.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

/**
 * Represents the configuration settings for SmartyStreets
 * 
 * @author CWDS API Team
 */
public class SmartyStreetsConfig {

  @NotNull
  @JsonProperty("clientId")
  private String clientId;

  @NotNull
  @JsonProperty("token")
  private String token;

  @NotNull
  @JsonProperty("maxCandidates")
  private Integer maxCandidates;

  /**
   * @return the id
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @return the maxCandidates
   */
  public Integer getMaxCandidates() {
    return maxCandidates;
  }

}
