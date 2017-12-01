package gov.ca.cwds.geo;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Module;
import gov.ca.cwds.geo.inject.ApplicationModule;
import gov.ca.cwds.rest.BaseApiApplication;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.Map;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author CWDS TPT2 Team */
public class GeoServicesApiApplication extends BaseApiApplication<GeoServicesApiConfiguration> {
  private static final Logger LOG = LoggerFactory.getLogger(GeoServicesApiApplication.class);

  public static void main(String[] args) throws Exception {
    new GeoServicesApiApplication().run(args);
  }

  @Override
  public Module applicationModule(Bootstrap<GeoServicesApiConfiguration> bootstrap) {
    return new ApplicationModule(bootstrap);
  }

  @Override
  public void runInternal(GeoServicesApiConfiguration configuration, Environment environment) {

    environment
        .jersey()
        .getResourceConfig()
        .packages(getClass().getPackage().getName())
        .register(DeclarativeLinkingFeature.class);

    runHealthChecks(environment);
  }

  private void runHealthChecks(Environment environment) {
    for (Map.Entry<String, HealthCheck.Result> entry :
        environment.healthChecks().runHealthChecks().entrySet()) {
      if (!entry.getValue().isHealthy()) {
        LOG.error("Fail - {}: {}", entry.getKey(), entry.getValue().getMessage());
      }
    }
  }
}
