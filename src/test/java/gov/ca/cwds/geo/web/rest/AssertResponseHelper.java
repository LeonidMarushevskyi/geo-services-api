package gov.ca.cwds.geo.web.rest;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

/**
 * @author CWDS TPT2 Team
 */

public final class AssertResponseHelper {

  private AssertResponseHelper() {
  }

  @SuppressWarnings("unchecked")
  public static void assertEqualsResponse(String fixture, String actualString) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, String> expectedMap = (Map<String, String>) objectMapper
        .readValue(fixture, Map.class);
    Map<String, String> actualMap = (Map<String, String>) objectMapper
        .readValue(actualString, Map.class);
    assertThat(actualMap).isEqualTo(expectedMap);
  }

}
