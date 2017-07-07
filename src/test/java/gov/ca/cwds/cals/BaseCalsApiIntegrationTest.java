package gov.ca.cwds.cals;

import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.cals.web.rest.RestClientTestRule;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClient;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;

/** @author CWDS CALS API Team */
public abstract class BaseCalsApiIntegrationTest {

  private static final String configFile = "config/test-cals-api.yml";
 
  @ClassRule
  public static final DropwizardAppRule<CalsApiConfiguration> appRule =
      new DropwizardAppRule<CalsApiConfiguration>(
          CalsApiApplication.class, ResourceHelpers.resourceFilePath(configFile)) {

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

  protected static DatabaseHelper getFasDatabaseHelper() {
    DataSourceFactory dataSourceFactory = appRule.getConfiguration().getFasDataSourceFactory();
    return new DatabaseHelper(
        dataSourceFactory.getUrl(), dataSourceFactory.getUser(), dataSourceFactory.getPassword());
  }

  protected static DatabaseHelper getCmsDatabaseHelper() {
    DataSourceFactory dataSourceFactory = appRule.getConfiguration().getCmsDataSourceFactory();
    return new DatabaseHelper(
        dataSourceFactory.getUrl(), dataSourceFactory.getUser(), dataSourceFactory.getPassword());
  }

  protected static DatabaseHelper getCalsnsDatabaseHelper() {
    DataSourceFactory dataSourceFactory = appRule.getConfiguration().getCalsnsDataSourceFactory();
    return new DatabaseHelper(
        dataSourceFactory.getUrl(), dataSourceFactory.getUser(), dataSourceFactory.getPassword());
  }

  protected static DatabaseHelper getLisDatabaseHelper() {
    DataSourceFactory dataSourceFactory = appRule.getConfiguration().getLisDataSourceFactory();
    return new DatabaseHelper(
        dataSourceFactory.getUrl(), dataSourceFactory.getUser(), dataSourceFactory.getPassword());
  }

  public static void setUpFas() throws Exception {
    if (!isIntegrationTestsRunning()) {
      getFasDatabaseHelper().runScript("liquibase/fas_database_master.xml");
    }
  }

  public static void setUpLis() throws Exception {
    if (!isIntegrationTestsRunning()) {
      getLisDatabaseHelper().runScript("liquibase/lis_database_master.xml");
    }
  }

  public static void setUpCms() throws Exception {
    if (!isIntegrationTestsRunning()) {
      getCmsDatabaseHelper().runScript("liquibase/cwscms_database_master.xml");
    }
  }

  public static void setUpCalsns() throws Exception {
    if (!isIntegrationTestsRunning()) {
      getCalsnsDatabaseHelper().runScript("liquibase/calsns_database_master.xml");
    }
  }

  public String transformDTOtoJSON(BaseDTO dto) throws Exception {
    return clientTestRule.getMapper().writeValueAsString(dto);
  }

  @After
  public void tearDown() throws Exception {}

  private static boolean isIntegrationTestsRunning() {
    return System.getProperty("cals.api.url") != null;
  }

}
