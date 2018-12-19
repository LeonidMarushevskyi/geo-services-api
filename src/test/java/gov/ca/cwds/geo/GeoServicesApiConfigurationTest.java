package gov.ca.cwds.geo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GeoServicesApiConfigurationTest {

  private SmartyStreetsConfig smartyStreetsConfig = new SmartyStreetsConfig();

  @Test
  public void getSmartyStreetsConfig() {
    GeoServicesApiConfiguration target = new GeoServicesApiConfiguration();
    target.setSmartystreetsConfig(smartyStreetsConfig);
    SmartyStreetsConfig actual = target.getSmartyStreetsConfig();
    assertThat(actual, is(smartyStreetsConfig));
  }

}
