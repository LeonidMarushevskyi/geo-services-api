package gov.ca.cwds.geo.web.rest;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 * @author CWDS CALS API Team
 */

public final class AssertFixtureUtils {

  private AssertFixtureUtils() {
  }

  public static void assertResponseByFixture(Response response, String fixture)
      throws IOException, JSONException {
    String entity = IOUtils.toString((InputStream) response.getEntity(), "UTF-8");
    assertResponseByFixture(entity, fixture);
  }

  public static void assertResponseByFixture(String entity, String fixture)
      throws IOException, JSONException {
    assertEquals(fixture, entity, JSONCompareMode.STRICT);
  }

  public static void assertResponseByFixturePath(Response response, String fixturePath)
      throws IOException, JSONException {
    assertResponseByFixture(response, fixture(fixturePath));
  }

}
