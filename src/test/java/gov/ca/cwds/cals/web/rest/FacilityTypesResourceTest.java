package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;

import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.service.dto.FacilityTypesDTO;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS CALS API Team
 */
public class FacilityTypesResourceTest extends BaseCalsApiIntegrationTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        setUpLis();
    }

    @Test
    public void testGetFacilityTypes() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.DICTIONARIES + "/" + Constants.API.FACILITY_TYPES);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityTypesDTO facilityDTOs = invocation.get(FacilityTypesDTO.class);

        String fixture = fixture("fixtures/facility-types-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(facilityDTOs));
    }
}