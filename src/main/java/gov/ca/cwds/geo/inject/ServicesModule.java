package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.geo.service.AddressValidationService;

/**
 * Identifies all GEO Services API business layer (services) classes available for dependency injection by
 * Guice.
 *
 * @author TPT2 Team
 */
public class ServicesModule extends AbstractModule {

  /**
   * Default constructor
   */
  public ServicesModule() {
    // Do nothing - Default constructor
  }

  @Override
  protected void configure() {
    bind(AddressValidationService.class);
  }

}
