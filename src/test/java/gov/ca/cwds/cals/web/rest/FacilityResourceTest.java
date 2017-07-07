package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.service.dto.FacilityDTO;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class FacilityResourceTest extends BaseCalsApiIntegrationTest {

    private static final String LICENSE_NUMBER = "193600110";
    private static final String WRONG_LICENSE_NUMBER = "-1";

    private static final String FACILITY_ID = "E6tloOO0Ql";

    @BeforeClass
    public static void beforeClass() throws Exception {
        setUpLis();

        setUpCms();

        setUpFas();
    }

    @Test
    public void testGetFacilityByLicenseNumber() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.FACILITIES + "/" + LICENSE_NUMBER);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityDTO facilityDTO = invocation.get(FacilityDTO.class);

        String fixture = fixture("fixtures/facility-by-license-number-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(facilityDTO));
    }

    @Test
    public void testGetFacilityWithWrongLicenseNumber() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.FACILITIES + "/" + WRONG_LICENSE_NUMBER);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testGetFacilityByFacilityId() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.FACILITIES + "/" + FACILITY_ID);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityDTO facilityDTO = invocation.get(FacilityDTO.class);

        String fixture = fixture("fixtures/facility-by-id-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(facilityDTO));
    }

    @Test
    public void testGetFacilityByFacilityIdWithZeroInCountyAndFacilityType() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.FACILITIES + "/BITrEV40OU");
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityDTO facilityDTO = invocation.get(FacilityDTO.class);

        String fixture = fixture("fixtures/facility-by-id-with-zero-in-county-and-facility-type-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(facilityDTO));
    }

}