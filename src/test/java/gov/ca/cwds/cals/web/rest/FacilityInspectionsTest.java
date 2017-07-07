package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.FACILITIES;
import static gov.ca.cwds.cals.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.service.dto.FacilityInspectionDTO;
import gov.ca.cwds.cals.service.dto.FacilityInspectionsDTO;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS CALS API Team
 */

public class FacilityInspectionsTest extends BaseCalsApiIntegrationTest {

    private static final String INSPECTIONS_RESPONSE_JSON = "fixtures/facility-inspections-response.json";
    private static final String INSPECTION_RESPONSE_JSON = "fixtures/facility-inspection-response.json";

    public static final Integer FACILITY_NUMBER = 11400218;
    public static final String INSPECTION_ID = "14-CR-MHRO-8WZSF8-20120809134525";

    @BeforeClass
    public static void beforeClass() throws Exception {
        setUpFas();
    }

    @Test
    public void getFacilityInspectionsResponseTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/"
                + FACILITY_NUMBER + "/" + Constants.API.INSPECTIONS);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityInspectionsDTO inspectionsDTO = invocation.get(FacilityInspectionsDTO.class);

        String fixture = fixture(INSPECTIONS_RESPONSE_JSON);
        assertEqualsResponse(fixture, transformDTOtoJSON(inspectionsDTO));
    }


    @Test
    public void getInspectionResponseTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/"
                + FACILITY_NUMBER + "/" + Constants.API.INSPECTIONS + "/" + INSPECTION_ID);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityInspectionDTO inspectionDTO = invocation.get(FacilityInspectionDTO.class);

        String fixture = fixture(INSPECTION_RESPONSE_JSON);
        assertEqualsResponse(fixture, transformDTOtoJSON(inspectionDTO));
    }


    @Test
    public void inspectionsNotFoundTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + 0 + "/" + Constants.API.INSPECTIONS);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void inspectionNotFoundTest() throws Exception {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + FACILITY_NUMBER + "/" + Constants.API.INSPECTIONS + "/" + 0);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void getAllFacilityInspectionsTest() throws JsonProcessingException {
        WebTarget target = clientTestRule.target(FACILITIES + "/" + FACILITY_NUMBER + "/" + Constants.API.INSPECTIONS);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        FacilityInspectionsDTO inspectionsDTO = invocation.get(FacilityInspectionsDTO.class);
        assertTrue(inspectionsDTO != null);
        assertTrue(inspectionsDTO.getInspections() != null);
        assertTrue(inspectionsDTO.getInspections().size() == 3);

        FacilityInspectionDTO inspectionDTO0 = inspectionsDTO.getInspections().get(0);
        String inspectionId = inspectionDTO0.getId();

        target = clientTestRule.target(FACILITIES + "/" + FACILITY_NUMBER + "/" + Constants.API.INSPECTIONS + "/" + INSPECTION_ID);
        invocation = target.request(MediaType.APPLICATION_JSON);
        final FacilityInspectionDTO inspectionDTO = invocation.get(FacilityInspectionDTO.class);

        // Expected only 1 deficiency object
        assertTrue(inspectionDTO.getDeficiencies().size() == 1);

        inspectionsDTO.getInspections().forEach(inspection -> {
            if (INSPECTION_ID.equals(inspection.getId())) {
                assertEquals(inspection, inspectionDTO);
            }
        });
    }

}
