package gov.ca.cwds.geo.web.rest;

import gov.ca.cwds.geo.JerseyGuiceRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ApplicationResourceTest {

    private static final String APP_NAME = "my app";
    private static final String VERSION = "1.0.0";
    private static final String BUILD_NUMBER = "1";

    @ClassRule
    public static JerseyGuiceRule rule = new JerseyGuiceRule();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ApplicationResource(APP_NAME))
            .build();

    @Test
    public void applicationGetReturns200() {
        assertThat(resources.client().target("/application").request().get().getStatus(), is(equalTo(200)));
    }

    @Test
    public void applicationGetReturnsCorrectName() {
        assertThat(resources.client().target("/application").request().get().readEntity(String.class),
                containsString(APP_NAME));
    }

    @Test
    public void applicationGetReturnsCorrectVersion() {
        assertThat(resources.client().target("/application").request().get().readEntity(String.class),
                containsString(VERSION));
    }

    @Test
    public void applicationGetReturnsCorrectBuildNumber() {
        assertThat(resources.client().target("/application").request().get().readEntity(String.class),
                containsString(BUILD_NUMBER));
    }

    @Test
    public void applicationGetReturnsV1JsonContentType() {
        assertThat(
                resources.client().target("/application").request().get().getMediaType()
                        .toString(), is(equalTo(MediaType.APPLICATION_JSON)));
    }

}