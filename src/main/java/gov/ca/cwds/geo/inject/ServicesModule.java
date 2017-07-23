package gov.ca.cwds.geo.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.data.cms.SystemCodeDao;
import gov.ca.cwds.data.cms.SystemMetaDao;
import gov.ca.cwds.geo.service.AddressValidationService;
import gov.ca.cwds.rest.services.cms.CachingSystemCodeService;
import gov.ca.cwds.rest.services.cms.SystemCodeService;
import gov.ca.cwds.rest.api.domain.cms.SystemCodeCache;

/**
 * Identifies all GEO Services API business layer (services) classes available for dependency
 * injection by Guice.
 *
 * @author TPT2 Team
 */
public class ServicesModule extends AbstractModule {

  /** Default constructor */
  public ServicesModule() {
    // Do nothing - Default constructor
  }

  @Override
  protected void configure() {
    bind(AddressValidationService.class);
  }

  @Provides
  public SystemCodeService provideSystemCodeService(SystemCodeDao systemCodeDao,
      SystemMetaDao systemMetaDao) {
    final long secondsToRefreshCache = 15L * 24 * 60 * 60; // 15 days
    return new CachingSystemCodeService(systemCodeDao, systemMetaDao, secondsToRefreshCache, false);
  }

  @Provides
  public SystemCodeCache provideSystemCodeCache(SystemCodeService systemCodeService) {
    SystemCodeCache systemCodeCache = (SystemCodeCache) systemCodeService;
    systemCodeCache.register();
    return systemCodeCache;
  }
}
