package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.ADDRESS;
import static gov.ca.cwds.geo.Constants.DISTANCE;
import static gov.ca.cwds.geo.Constants.VALIDATE_SINGLE;
import static gov.ca.cwds.geo.web.rest.AssertFixtureUtils.assertResponseByFixturePath;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import gov.ca.cwds.geo.BaseApiIntegrationTest;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.AddressService;
import gov.ca.cwds.geo.service.dto.CalculateDistanceDTO;
import gov.ca.cwds.geo.service.dto.DistanceDTO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.junit.Test;

public class AddressResourceTest extends BaseApiIntegrationTest {


  @Test
  public void validateSingleAddress() throws Exception {
    AddressService addressService = mock(AddressService.class);
    AddressResource target = new AddressResource(addressService);

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("106 Big Valley Rd", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);

    when(
        addressService.fetchValidatedAddresses(new Address("106 Big Valley Rd", "Folsom", "CA",
            "95630", null))).thenReturn(expected);

    Response actual =
        target
            .validateSingleAddress(new Address("106 Big Valley Rd", "Folsom", "CA", "95630", null));

    assertThat(actual.getEntity(), is(expected));
  }

  @Test
  public void calculateDistance() throws Exception {
    AddressService addressService = mock(AddressService.class);
    AddressResource target = new AddressResource(addressService);

    DistanceDTO distanceDTO = new DistanceDTO();
    distanceDTO.setMiles((double) 2);

    Address firstAddress = new Address("106 Big Valley Rd", "Folsom", "CA", "95630", null);
    Address secondAddress = new Address("10 Big Valley Rd", "Folsom", "CA", "95630", null);

    CalculateDistanceDTO calculateDistanceDTO = new CalculateDistanceDTO();
    calculateDistanceDTO.setFirstAddress(firstAddress);
    calculateDistanceDTO.setSecondAddress(secondAddress);

    when(addressService.calculateDistance(firstAddress, secondAddress)).thenReturn(distanceDTO);

    Response actual = target.calculateDistance(calculateDistanceDTO);

    assertThat(actual.getEntity(), is(distanceDTO));
  }

  @Test
  public void testGetCityStateByZipCode() throws Exception {
    AddressService addressService = mock(AddressService.class);
    AddressResource target = new AddressResource(addressService);

    String zip = "95630";
    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO(null, "Folsom", "CA", null, "95630", "2145", -121.13233, 38.64028,
            true);

    when(addressService.lookupSingleUSZip(zip)).thenReturn(expected);

    Response actual = target.getCityStateByZipCode(zip);
    assertThat(actual.getEntity(), is(expected));
  }

  @Test
  public void testSuggestAddress() throws Exception {
    AddressService addressService = mock(AddressService.class);
    AddressResource target = new AddressResource(addressService);

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("106 Big Valley Rd", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);

    when(addressService.suggestAddress("106 Big Valley Rd, Folsom")).thenReturn(expected);

    Response actual = target.suggestAddress("106 Big Valley Rd, Folsom");

    assertThat(actual.getEntity(), is(expected));
  }

  @Test
  public void testPostAddressValidateJsonProcessingException() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(Entity.entity(
            fixture("fixtures/addressValidation/validation/jsonProcessingException/request.json"),
            MediaType.APPLICATION_JSON_TYPE), Response.class);
    assertResponseByFixturePath(postResponse,
        "fixtures/addressValidation/validation/jsonProcessingException/response.json");
  }

  @Test
  public void testPostAddressValidateStreetTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(Entity.entity(
            fixture("fixtures/addressValidation/validation/streetTooLong/request.json"),
            MediaType.APPLICATION_JSON_TYPE), Response.class);
    assertResponseByFixturePath(postResponse,
        "fixtures/addressValidation/validation/streetTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateCityTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(Entity.entity(
            fixture("fixtures/addressValidation/validation/cityTooLong/request.json"),
            MediaType.APPLICATION_JSON_TYPE), Response.class);
    assertResponseByFixturePath(postResponse,
        "fixtures/addressValidation/validation/cityTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateZipTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(Entity.entity(
            fixture("fixtures/addressValidation/validation/zipTooLong/request.json"),
            MediaType.APPLICATION_JSON_TYPE), Response.class);
    assertResponseByFixturePath(postResponse,
        "fixtures/addressValidation/validation/zipTooLong/response.json");
  }

  @Test
  public void testPostAddressValidateStateTooLong() throws Exception {
    WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    Response postResponse =
        invocation.post(Entity.entity(
            fixture("fixtures/addressValidation/validation/stateTooLong/request.json"),
            MediaType.APPLICATION_JSON_TYPE), Response.class);
    assertResponseByFixturePath(postResponse,
        "fixtures/addressValidation/validation/stateTooLong/response.json");
  }

  @Test
  public void calculateDistance_errorMessage_whenNoSecondAddress() throws Exception {
    calculateDistanceAndAssert(
        "fixtures/calculateDistance/calculateDistance_noSecondAddress_request.json",
        "fixtures/calculateDistance/calculateDistance_noSecondAddress_response.json");
  }

  private void calculateDistanceAndAssert(String inputFixture, String expectedResultFixture)
      throws IOException, JSONException {
    // given
    final Entity<String> input =
        Entity.entity(fixture(inputFixture), MediaType.APPLICATION_JSON_TYPE);

    // when
    final Response postResponse =
        clientTestRule.target(ADDRESS + "/" + DISTANCE).request(MediaType.APPLICATION_JSON)
            .post(input, Response.class);

    // then
    assertResponseByFixturePath(postResponse, expectedResultFixture);
  }

}
