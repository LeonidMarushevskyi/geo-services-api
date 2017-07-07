package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.FACILITIES;
import static gov.ca.cwds.cals.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.service.dto.ComplaintDTO;
import gov.ca.cwds.cals.service.dto.ComplaintsDTO;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class FacilityComplaintResourceTest extends BaseCalsApiIntegrationTest {

    public static final String FACILITY_ID = "107201149";
    public static final String WRONG_FACILITY_ID = "1";
    public static final String COMPLAINT_ID = "24-CR-BJAS-72KVMM-20070424163336";
    public static final String WRONG_COMPLAINT_ID = "1";

    @BeforeClass
    public static void beforeClass() throws Exception {
        setUpFas();
    }

    @Test
    public void getAllFacilityComplaintsTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + FACILITY_ID + "/" + Constants.API.COMPLAINTS);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        ComplaintsDTO complaintsDTO = invocation.get(ComplaintsDTO.class);

        String fixture = fixture("fixtures/complaints-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(complaintsDTO));
    }

    @Test
    public void getAllFacilityComplaintsWrongFacilityIdTest() throws JsonProcessingException {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + WRONG_FACILITY_ID + "/" + Constants.API.COMPLAINTS);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void getFacilityComplaintTest() throws Exception {
        WebTarget target = clientTestRule
                .target(FACILITIES + "/" + FACILITY_ID + "/" + Constants.API.COMPLAINTS + "/" + COMPLAINT_ID);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        ComplaintDTO complaintDTO = invocation.get(ComplaintDTO.class);

        String fixture = fixture("fixtures/complaint-response.json");
        assertEqualsResponse(fixture, transformDTOtoJSON(complaintDTO));
    }

    @Test
    public void getFacilityComplaintNoResultTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + FACILITY_ID + "/" + Constants.API.COMPLAINTS + "/" +
                WRONG_COMPLAINT_ID);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();
        assertEquals(404, response.getStatus());
        String fixture = fixture("fixtures/complaint-not-found-by-id-response.json");
        assertEqualsResponse(fixture, response.readEntity(String.class));
    }

}