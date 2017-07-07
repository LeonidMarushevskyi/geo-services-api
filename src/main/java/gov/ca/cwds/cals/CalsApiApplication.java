package gov.ca.cwds.cals;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.google.inject.Module;
import gov.ca.cwds.cals.health.DataSourceHealthCheck;
import gov.ca.cwds.cals.inject.ApplicationModule;
import gov.ca.cwds.cals.web.rest.exception.CalsExceptionHandler;
import gov.ca.cwds.rest.BaseApiApplication;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author CWDS CALS API Team
 */

public class CalsApiApplication extends BaseApiApplication<CalsApiConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(CalsApiApplication.class);

    public static void main(String[] args) throws Exception{
        new CalsApiApplication().run(args);
    }

    @Override
    public Module applicationModule(Bootstrap<CalsApiConfiguration> bootstrap) {
        return new ApplicationModule(bootstrap);
    }

    @Override
    public void runInternal(CalsApiConfiguration configuration, Environment environment) {
        environment.jersey().register(CalsExceptionHandler.class);

        HealthCheckRegistry healthCheckRegistry = environment.healthChecks();
        healthCheckRegistry.register("nsDataSource", new DataSourceHealthCheck(configuration.getNsDataSourceFactory()));
        healthCheckRegistry.register("cmsDataSource", new DataSourceHealthCheck(configuration.getCmsDataSourceFactory()));
        healthCheckRegistry.register("lisDataSource", new DataSourceHealthCheck(configuration.getLisDataSourceFactory()));
        healthCheckRegistry.register("calsnsDataSource", new DataSourceHealthCheck(configuration.getCalsnsDataSourceFactory()));
        environment.jersey().getResourceConfig().packages(getClass().getPackage().getName()).register(DeclarativeLinkingFeature.class);

        runHealthChecks(environment);
    }

    private void runHealthChecks(Environment environment) {
        for (Map.Entry<String, HealthCheck.Result> entry : environment.healthChecks().runHealthChecks().entrySet()) {
            if (! entry.getValue().isHealthy()) {
                LOG.error("Fail - {}: {}", entry.getKey(), entry.getValue().getMessage());
            }
        }
    }
}
