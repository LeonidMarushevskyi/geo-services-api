package gov.ca.cwds.geo.web.rest;

import gov.ca.cwds.geo.Constants.API;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.rest.api.ApiException;
import gov.ca.cwds.rest.resources.system.AbstractSystemInformationResource;
import io.dropwizard.setup.Environment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

/**
 * @author CWDS TPT2 Team
 */
@Api(value = API.SYSTEM_INFORMATION)
@Path(API.SYSTEM_INFORMATION)
@Produces(MediaType.APPLICATION_JSON)
public class SystemInformationResource extends AbstractSystemInformationResource {

  private static final String VERSION_PROPERTIES_FILE = "version.properties";
  private static final String BUILD_VERSION = "build.version";
  private static final String BUILD_NUMBER = "build.number";

  private static final ObjectMapper MAPPER = new ObjectMapper();

  /**
   * Constructor
   * 
   * @param geoServicesApiConfiguration - geoServicesApiConfiguration
   * @param environment - environment
   */
  @Inject
  public SystemInformationResource(final GeoServicesApiConfiguration geoServicesApiConfiguration,
      final Environment environment) {
    super(environment.healthChecks());
    super.applicationName = geoServicesApiConfiguration.getApplicationName();
    Properties versionProperties = getVersionProperties();
    super.version = versionProperties.getProperty(BUILD_VERSION);
    super.buildNumber = versionProperties.getProperty(BUILD_NUMBER);
  }

  private Properties getVersionProperties() {
    Properties versionProperties = new Properties();
    try {
      InputStream is = ClassLoader.getSystemResourceAsStream(VERSION_PROPERTIES_FILE);
      versionProperties.load(is);
    } catch (IOException e) {
      throw new ApiException("Can't read version.properties", e);
    }
    return versionProperties;
  }

  /**
   * Get the name of the application.
   *
   * @return the application data
   */
  @GET
  @ApiResponses(
      value = {@ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = "Not Authorized"),
          @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = "Not found"),
          @ApiResponse(code = 465, message = "CWS-CARES Geo Services API is UnHealthy")})
  public Response get() {
    return super.buildResponse();
  }
}
