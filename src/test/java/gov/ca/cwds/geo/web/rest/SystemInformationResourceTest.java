package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.API.SYSTEM_INFORMATION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.SortedMap;

import javax.ws.rs.core.MediaType;

import org.junit.ClassRule;
import org.junit.Test;

import gov.ca.cwds.dto.app.HealthCheckResultDto;
import gov.ca.cwds.dto.app.SystemInformationDto;
import gov.ca.cwds.geo.BaseApiIntegrationTest;
import gov.ca.cwds.geo.Constants;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.geo.JerseyGuiceRule;
import io.dropwizard.setup.Environment;
import io.dropwizard.testing.junit.ResourceTestRule;

/**
 * @author CWDS API Team
 *
 */
public class SystemInformationResourceTest extends BaseApiIntegrationTest {

  private static GeoServicesApiConfiguration geoServicesApiConfiguration =
      mock(GeoServicesApiConfiguration.class);
  private static Environment environment = mock(Environment.class);

  @ClassRule
  public static JerseyGuiceRule rule = new JerseyGuiceRule();

  @ClassRule
  public static final ResourceTestRule resources = ResourceTestRule.builder()
      .addResource(new SystemInformationResource(geoServicesApiConfiguration, environment)).build();

  /**
   * 
   */
  @Test
  public void testSystemInformationGet() {
    SystemInformationDto systemInformationDto =
        clientTestRule.target(Constants.API.SYSTEM_INFORMATION).request(MediaType.APPLICATION_JSON)
            .get(SystemInformationDto.class);
    assertEquals("CWDS GEO SERVICES API", systemInformationDto.getApplicationName());
    assertNotNull(systemInformationDto.getVersion());
    SortedMap<String, HealthCheckResultDto> healthCheckResults =
        systemInformationDto.getHealthCheckResults();
    assertNotNull(healthCheckResults.get("deadlocks"));

  }

  private void assertDataSource(HealthCheckResultDto healthCheckResultDto) {
    assertNotNull(healthCheckResultDto);
    assertTrue(healthCheckResultDto.isHealthy());
  }

  @Test
  public void applicationGetReturnsCorrectName() {
    SystemInformationDto systemInformationDto =
        clientTestRule.target(Constants.API.SYSTEM_INFORMATION).request(MediaType.APPLICATION_JSON)
            .get(SystemInformationDto.class);
    assertEquals("CWDS GEO SERVICES API", systemInformationDto.getApplicationName());
  }

  @Test
  public void applicationGetReturnsCorrectVersion() {
    SystemInformationDto systemInformationDto =
        clientTestRule.target(Constants.API.SYSTEM_INFORMATION).request(MediaType.APPLICATION_JSON)
            .get(SystemInformationDto.class);
    assertEquals("CWDS GEO SERVICES API", systemInformationDto.getApplicationName());
    assertNotNull(systemInformationDto.getVersion());
  }

  @Test
  public void applicationGetReturnsV1JsonContentType() {
    assertThat(resources.client().target("/" + SYSTEM_INFORMATION).request().get().getMediaType()
        .toString(), is(equalTo(MediaType.APPLICATION_JSON)));
  }

}
