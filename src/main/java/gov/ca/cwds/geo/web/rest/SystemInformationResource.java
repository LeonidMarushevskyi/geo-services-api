package gov.ca.cwds.geo.web.rest;

import gov.ca.cwds.geo.Constants.API;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.rest.resources.system.AbstractSystemInformationResource;
import io.dropwizard.setup.Environment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.InputStream;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

/**
 * @author CWDS TPT2 Team
 */
@Api(value = API.SYSTEM_INFORMATION)
@Path(API.SYSTEM_INFORMATION)
@Produces(MediaType.APPLICATION_JSON)
public class SystemInformationResource extends AbstractSystemInformationResource {


  private static final String BUILD_VERSION = "Geo-Services-Api-Version";
  private static final String BUILD_NUMBER = "Geo-Services-Api-Build";
  private static final String N_A = "N/A";

  private static final Logger LOGGER = LoggerFactory.getLogger(SystemInformationResource.class);

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
    final Attributes manifestProperties = getManifestProperties();
    String value = manifestProperties.getValue(BUILD_VERSION);
    super.version = StringUtils.isBlank(value) ? N_A : value;
    value = manifestProperties.getValue(BUILD_NUMBER);
    super.buildNumber = StringUtils.isBlank(value) ? N_A : value;
    super.gitCommitHash = N_A;
  }

  /**
   * Get the name of the application.
   *
   * @return the application data
   */
  @GET
  @ApiResponses(value = {
      @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = "Not Authorized"),
      @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = "Not found"),
      @ApiResponse(code = 465, message = "CWS-CARES Geo Services API is UnHealthy")})
  public Response get() {
    return super.buildResponse();
  }

  private Attributes getManifestProperties() {
    Attributes attributes = new Attributes();
    String resource = "/" + this.getClass().getName().replace('.', '/') + ".class";
    String fullPath = this.getClass().getResource(resource).toExternalForm();
    String archivePath = fullPath.substring(0, fullPath.length() - resource.length());
    if (archivePath.endsWith("\\WEB-INF\\classes") || archivePath.endsWith("/WEB-INF/classes")) {
      // Required for WAR files.
      archivePath = archivePath.substring(0, archivePath.length() - "/WEB-INF/classes".length());
    }
    try (InputStream input = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
      attributes = new Manifest(input).getMainAttributes();
    } catch (Exception e) {
      LOGGER.error("Loading properties from MANIFEST failed! {}", e);
    }
    return attributes;
  }
}
