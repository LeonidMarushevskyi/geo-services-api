package gov.ca.cwds.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.BaseApiConfiguration;
import javax.annotation.Nullable;

public class GeoServicesApiConfiguration extends BaseApiConfiguration {

  @Nullable
  private SmartyStreetsConfig smartyStreetsConfig;

  @JsonProperty(value = "smartystreets1")
  public SmartyStreetsConfig getSmartyStreetsConfig() {
    return smartyStreetsConfig;
  }

  @JsonProperty
  public void setSmartystreetsConfig(
      SmartyStreetsConfig smartyStreetsConfig) {
    this.smartyStreetsConfig = smartyStreetsConfig;
  }

}
