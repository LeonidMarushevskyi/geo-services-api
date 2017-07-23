package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.geo.service.AddressService;

/**
 * Identifies all GEO Services API business layer (services) classes available for dependency
 * injection by Guice.
 *
 * @author TPT2 Team
 */
public class ServicesModule extends AbstractModule {

  /** Default constructor */
  ServicesModule() {
    // Do nothing - Default constructor
  }

  @Override
  protected void configure() {
    bind(AddressService.class);
  }
}
