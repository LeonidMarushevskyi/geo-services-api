package gov.ca.cwds.cals.web.rest.rfa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormDTO;
import gov.ca.cwds.cals.web.rest.RestClientTestRule;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author CWDS CALS API Team
 */
public final class RFAHelper {

  private RFAHelper() {
  }

  public static RFA1aFormDTO createForm(RestClientTestRule clientTestRule) {
    WebTarget target = clientTestRule.target(API.RFA_1A_FORMS);

    RFA1aFormDTO rfaFormDTOBefore = new RFA1aFormDTO();
    CountyType county = new CountyType();
    county.setId(1l);
    county.setValue("Alameda");
    rfaFormDTOBefore.setApplicationCounty(county);
    rfaFormDTOBefore.setInitialApplication(true);
    rfaFormDTOBefore.setOtherType(true);
    rfaFormDTOBefore.setOtherTypeDescription("otherDescription");
    RFA1aFormDTO rfaFormDTOAfter =
        target
            .request(MediaType.APPLICATION_JSON)
            .post(
                Entity.entity(rfaFormDTOBefore, MediaType.APPLICATION_JSON_TYPE),
                RFA1aFormDTO.class);
    assertNotNull(rfaFormDTOAfter);
    assertNotNull(rfaFormDTOAfter.getId());
    assertTrue(rfaFormDTOAfter.isInitialApplication());
    assertTrue(rfaFormDTOAfter.isOtherType());
    assertEquals("otherDescription", rfaFormDTOAfter.getOtherTypeDescription());
    assertEquals(rfaFormDTOBefore.getApplicationCounty(), rfaFormDTOAfter.getApplicationCounty());
    return rfaFormDTOAfter;
  }
}
