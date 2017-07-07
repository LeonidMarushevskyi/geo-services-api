package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.geo.SmartyStreetsConfig;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import io.dropwizard.setup.Bootstrap;

/**
 * DI (dependency injection) setup for data access objects (DAO).
 *
 * @author CWDS TPT2 Team
 */
public class DataAccessModule extends AbstractModule {

  /**
   * Constructor takes the API config.
   *
   * @param bootstrap the ApiConfiguration
   */
  public DataAccessModule(Bootstrap<GeoServicesApiConfiguration> bootstrap) {}

  /**
   * {@inheritDoc}
   *
   * @see AbstractModule#configure()
   */
  @Override
  protected void configure() {
    bind(SmartyStreetsDAO.class);
  }

  @Provides
  public SmartyStreetsConfig smartystreetsConfig(
      GeoServicesApiConfiguration geoServiceApiConfiguration) {
    return geoServiceApiConfiguration.getSmartyStreetsConfig();
  }
}
