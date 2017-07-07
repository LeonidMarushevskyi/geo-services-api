package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.inject.AuditingModule;
import io.dropwizard.setup.Bootstrap;

/**
 * Bootstraps and configures the CWDS RESTful Geo Services application.
 *
 * @author CWDS TPT2 Team
 */
public class ApplicationModule extends AbstractModule {

  private Bootstrap<GeoServicesApiConfiguration> bootstrap;

  public ApplicationModule(Bootstrap<GeoServicesApiConfiguration> bootstrap) {
    super();
    this.bootstrap = bootstrap;
  }

  /**
   * Configure and initialize API components, including services, rest, data access objects (DAO),
   * web service filters, and auditing.
   *
   * <p>{@inheritDoc}
   */
  @Override
  protected void configure() {
    install(new DataAccessModule(bootstrap));
    install(new ServicesModule());
    install(new ResourcesModule());
    install(new AuditingModule());
  }
}
