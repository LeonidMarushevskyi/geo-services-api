package gov.ca.cwds.cals;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.extension.ServiceLocatorGenerator;
import org.junit.rules.ExternalResource;

/**
 * Code copied from {@link com.hubspot.dropwizard.guice.GuiceBundle} to create a guice injector for
 * jersey2 for unit testing.
 */
public class JerseyGuiceRule extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        final Injector baseInjector = Guice.createInjector(Stage.PRODUCTION, new ServletModule());
        JerseyGuiceUtils.install(new ServiceLocatorGenerator() {
            @Override
            public ServiceLocator create(String name, ServiceLocator parent) {
                if (!name.startsWith("__HK2_Generated_")) {
                    return null;
                }

                return baseInjector.createChildInjector(new JerseyGuiceModule(name)).getInstance(ServiceLocator.class);
            }
        });
    }

    @Override
    protected void after() {
        JerseyGuiceUtils.reset();
    }

}
