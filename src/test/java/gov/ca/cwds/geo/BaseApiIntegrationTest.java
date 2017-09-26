package gov.ca.cwds.geo;

import gov.ca.cwds.geo.service.dto.BaseDTO;
import gov.ca.cwds.geo.web.rest.RestClientTestRule;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClient;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;

/** @author CWDS Geo Services Team */
public abstract class BaseApiIntegrationTest {

  private static final String configFile = "config/test-geo-services-api.yml";
 
  @ClassRule
  public static final DropwizardAppRule<GeoServicesApiConfiguration> appRule =
      new DropwizardAppRule<GeoServicesApiConfiguration>(
          GeoServicesApiApplication.class, ResourceHelpers.resourceFilePath(configFile)) {

        @Override
        public Client client() {
          Client client = super.client();
          if (((JerseyClient) client).isClosed()) {
            client = clientBuilder().build();
          }
          return client;
        }


      };

  @Rule public RestClientTestRule clientTestRule = new RestClientTestRule(appRule);

  public String transformDTOtoJSON(BaseDTO dto) throws Exception {
    return clientTestRule.getMapper().writeValueAsString(dto);
  }

  public String transformListDTOtoJSON(BaseDTO[] dtoList) throws Exception {
    return clientTestRule.getMapper().writeValueAsString(dtoList);
  }

  @After
  public void tearDown() throws Exception {}

  private static boolean isIntegrationTestsRunning() {
    return System.getProperty("geoservices.api.url") != null;
  }

}
