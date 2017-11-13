package gov.ca.cwds.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.MinimalApiConfiguration;
import javax.annotation.Nullable;

public class GeoServicesApiConfiguration extends MinimalApiConfiguration {

  @Nullable
  private SmartyStreetsConfig smartyStreetsConfig;

  @JsonProperty(value = "smartystreets")
  public SmartyStreetsConfig getSmartyStreetsConfig() {
    return smartyStreetsConfig;
  }

  @JsonProperty
  public void setSmartystreetsConfig(SmartyStreetsConfig smartyStreetsConfig) {
    this.smartyStreetsConfig = smartyStreetsConfig;
  }
}
