package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.ADDRESS;
import static gov.ca.cwds.geo.Constants.API.SYSTEM_INFORMATION;
import static gov.ca.cwds.geo.Constants.LOOKUP_ZIP_CODE;
import static gov.ca.cwds.geo.Constants.VALIDATE_SINGLE;
import static gov.ca.cwds.geo.Constants.ZIP_CODE;
import static gov.ca.cwds.geo.web.rest.AssertFixtureUtils.assertResponseByFixturePath;
import static gov.ca.cwds.geo.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import gov.ca.cwds.geo.BaseApiIntegrationTest;
import gov.ca.cwds.geo.Constants;
import gov.ca.cwds.geo.JerseyGuiceRule;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import io.dropwizard.testing.junit.ResourceTestRule;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.ClassRule;
import org.junit.Test;

public class AddressResourceTest extends BaseApiIntegrationTest {

    @Test
    public void testPostAddressValidate() throws Exception {
        WebTarget target = clientTestRule.target(ADDRESS + "/" + VALIDATE_SINGLE);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response postResponse = invocation.post(Entity.entity(fixture("fixtures/addressValidateRequest.json"), MediaType.APPLICATION_JSON_TYPE), Response.class);
        assertResponseByFixturePath(postResponse, "fixtures/addressValidateResponse.json");
    }

    @Test
    public void testAddressLookup() throws Exception {
        String zipCode = "95747";
        WebTarget target = clientTestRule.target(ADDRESS + "/" + LOOKUP_ZIP_CODE + "/" + zipCode);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get(Response.class);
        assertResponseByFixturePath(response, "fixtures/addressLookupResponse.json");
    }

}