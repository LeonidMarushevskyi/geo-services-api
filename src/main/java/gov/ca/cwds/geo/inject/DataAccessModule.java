package gov.ca.cwds.geo.inject;

import com.codahale.metrics.Reporter;
import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.data.persistence.cms.SystemCode;
import gov.ca.cwds.data.persistence.cms.SystemMeta;
import gov.ca.cwds.geo.GeoServicesApiConfiguration;
import gov.ca.cwds.geo.SmartyStreetsConfig;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.inject.CmsSessionFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

/**
 * DI (dependency injection) setup for data access objects (DAO).
 *
 * @author CWDS TPT2 Team
 */
public class DataAccessModule extends AbstractModule {

  private final HibernateBundle<GeoServicesApiConfiguration> cmsHibernateBundle =
      new HibernateBundle<GeoServicesApiConfiguration>(Reporter.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(GeoServicesApiConfiguration configuration) {
          return configuration.getCmsDataSourceFactory();
        }

        @Override
        public String name() {
          return "cms";
        }
      };


  /**
   * Constructor takes the API config.
   *
   * @param bootstrap the ApiConfiguration
   */
  public DataAccessModule(Bootstrap<GeoServicesApiConfiguration> bootstrap) {
    bootstrap.addBundle(cmsHibernateBundle);
  }

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

  @Provides
  @CmsSessionFactory
  SessionFactory cmsSessionFactory() {
    return cmsHibernateBundle.getSessionFactory();
  }

}
