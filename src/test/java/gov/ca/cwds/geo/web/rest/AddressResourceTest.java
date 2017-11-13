package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.ADDRESS;
import static gov.ca.cwds.geo.Constants.DISTANCE;
import static gov.ca.cwds.geo.Constants.LOOKUP_ZIP_CODE;
import static gov.ca.cwds.geo.Constants.SUGGEST;
import static gov.ca.cwds.geo.Constants.VALIDATE_SINGLE;
import static gov.ca.cwds.geo.web.rest.AssertFixtureUtils.assertResponseByFixturePath;
import static io.dropwizard.testing.FixtureHelpers.fixture;

import gov.ca.cwds.geo.BaseApiIntegrationTest;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;

public class AddressResourceTest extends BaseApiIntegrationTest {

  @Test
  public void testPostAddressValidate() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidateRequest.json"), MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(postResponse, "fixtures/addressValidateResponse.json");
  }

  @Test
  public void testPostAddressValidateJsonProcessingException() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidation/validation/jsonProcessingException/request.json"),
                MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(
        postResponse, "fixtures/addressValidation/validation/jsonProcessingException/response.json");
  }

  @Test
  public void testPostAddressValidateStreetTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidation/validation/streetTooLong/request.json"),
                MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(
        postResponse, "fixtures/addressValidation/validation/streetTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateCityTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidation/validation/cityTooLong/request.json"),
                MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(
        postResponse, "fixtures/addressValidation/validation/cityTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateZipTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidation/validation/zipTooLong/request.json"),
                MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(
        postResponse, "fixtures/addressValidation/validation/zipTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateStateTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(
            Entity.entity(
                fixture("fixtures/addressValidation/validation/stateTooLong/request.json"),
                MediaType.APPLICATION_JSON_TYPE),
            Response.class);
    assertResponseByFixturePath(
        postResponse, "fixtures/addressValidation/validation/stateTooLong/response.json");
  }

  @Test
  public void calculateDistance_success_whenValidInput() throws Exception {
    // given
    final Entity<String> input = Entity.entity(
        fixture("fixtures/calculateDistance/calculateDistanceSuccessRequest.json"),
        MediaType.APPLICATION_JSON_TYPE
    );

    // when
    final Response postResponse = clientTestRule.target(ADDRESS + "/" + DISTANCE)
        .request(MediaType.APPLICATION_JSON)
        .post(input, Response.class);

    // then
    assertResponseByFixturePath(
        postResponse,
        "fixtures/calculateDistance/calculateDistanceSuccessResponse.json"
    );
  }

  @Test
  public void calculateDistance_exception_whenInvalidInput() throws Exception {
    // given
    final Entity<String> input = Entity.entity(
        fixture("fixtures/calculateDistance/calculateDistanceInvalidRequest.json"),
        MediaType.APPLICATION_JSON_TYPE
    );

    // when
    final Response postResponse = clientTestRule.target(ADDRESS + "/" + DISTANCE)
        .request(MediaType.APPLICATION_JSON)
        .post(input, Response.class);

    // then
    assertResponseByFixturePath(
        postResponse,
        "fixtures/calculateDistance/calculateDistanceInvalidResponse.json"
    );
  }

  @Test
  public void testAddressLookup() throws Exception {
    String zipCode = "95747";
    WebTarget target = clientTestRule.target(ADDRESS + "/" + LOOKUP_ZIP_CODE + "/" + zipCode);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response response = invocation.get(Response.class);
    assertResponseByFixturePath(response, "fixtures/addressLookupResponse.json");
  }

  @Test
  public void testAddressSuggestion() throws Exception {
    String suggestion = "1489 Black Bear St";
    WebTarget target = clientTestRule.target(ADDRESS + "/" + SUGGEST + "/" + suggestion);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response response = invocation.get(Response.class);
    assertResponseByFixturePath(response, "fixtures/addressSuggestResponse.json");
  }
}
