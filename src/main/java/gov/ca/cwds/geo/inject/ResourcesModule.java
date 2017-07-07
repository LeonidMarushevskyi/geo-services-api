package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.geo.service.AddressValidationService;
import gov.ca.cwds.geo.web.rest.AddressValidationResource;
import gov.ca.cwds.geo.web.rest.ApplicationResource;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import gov.ca.cwds.rest.resources.ServiceBackedResourceDelegate;
import gov.ca.cwds.rest.resources.SwaggerResource;

/**
 * Identifies all GEO Services API domain resource classes available for dependency injection by Guice.
 *
 * @author TPT2 Team
 */
public class ResourcesModule extends AbstractModule {

  /** Default constructor */
  public ResourcesModule() {
    // Do nothing - Default Constructor
  }

  @Override
  protected void configure() {
    bind(ApplicationResource.class);
    bind(AddressValidationResource.class);
  }

  @Provides
  @Named("app.name")
  public String appName(GeoServicesApiConfiguration geoServicesApiConfiguration) {
    return geoServicesApiConfiguration.getApplicationName();
  }

  @Provides
  @Named("app.version")
  public String appVersion(GeoServicesApiConfiguration geoServicesApiConfiguration) {
    return geoServicesApiConfiguration.getVersion();
  }

  @Provides
  @AddressValidationServiceBackedResource
  public ResourceDelegate addressValidationServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(AddressValidationService.class));
  }

}
