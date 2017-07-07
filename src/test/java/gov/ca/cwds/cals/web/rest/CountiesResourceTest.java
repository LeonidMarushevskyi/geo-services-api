package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.COUNTIES;
import static gov.ca.cwds.cals.web.rest.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.service.dto.CountiesDTO;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS CALS API Team
 */
public class CountiesResourceTest extends BaseCalsApiIntegrationTest {

    public static final String FIXTURES_COUNTIES_RESPONSE_JSON = "fixtures/counties-response.json";

    @BeforeClass
    public static void beforeClass() throws Exception {
        setUpCms();
    }

    @Test
    public void testGetCounties() throws Exception {
        WebTarget target = clientTestRule.target(Constants.API.DICTIONARIES + "/" + COUNTIES);
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        CountiesDTO countiesDTO = invocation.get(CountiesDTO.class);
        assertNotNull(countiesDTO);
        assertTrue(countiesDTO.getCounties().size() > 0);

        String fixture = fixture(FIXTURES_COUNTIES_RESPONSE_JSON);
        CountiesDTO countiesDTO1 = clientTestRule.getMapper().readValue(fixture, CountiesDTO.class);
        assertEqualsResponse(fixture, transformDTOtoJSON(countiesDTO));

        assertEquals(countiesDTO, countiesDTO1);
    }

    @Test
    public void equalsTest() throws Exception {
        String fixture = fixture(FIXTURES_COUNTIES_RESPONSE_JSON);
        assertEquals(new CountiesDTO(), new CountiesDTO());
        CountiesDTO countiesDTO1 = clientTestRule.getMapper().readValue(fixture, CountiesDTO.class);
        CountiesDTO countiesDTO2 = clientTestRule.getMapper().readValue(fixture, CountiesDTO.class);
        assertEquals(countiesDTO1, countiesDTO2);
    }

}
