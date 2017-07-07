package gov.ca.cwds.cals.web.rest.rfa;

import static gov.ca.cwds.cals.web.rest.rfa.RFAHelper.createForm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormCollectionDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormDTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aFormsResourceTest extends BaseCalsApiIntegrationTest {

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCalsns();
  }

  @Test
  public void createApplicationForm() throws Exception {
    createForm(clientTestRule);
  }

  @Test
  public void getApplicationFormNotFound() throws Exception {
    WebTarget target = clientTestRule.target(API.RFA_1A_FORMS);
    target = clientTestRule.target(API.RFA_1A_FORMS + "/9999999");
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    assertEquals(404, response.getStatus());
  }

  @Test
  public void getApplicationFormTest() throws Exception {
    RFA1aFormDTO rfaFormCreate = createForm(clientTestRule);

    WebTarget target = clientTestRule.target(API.RFA_1A_FORMS);
    target = clientTestRule.target(API.RFA_1A_FORMS + "/" + rfaFormCreate.getId());
    RFA1aFormDTO rfaFormGet = target.request(MediaType.APPLICATION_JSON).get(RFA1aFormDTO.class);

    assertNotNull(rfaFormGet);
    assertEquals(rfaFormCreate, rfaFormGet);
  }

  @Test
  public void updateApplicationFormTest() throws Exception {
    RFA1aFormDTO rfaFormCreate = createForm(clientTestRule);

    WebTarget target = clientTestRule.target(API.RFA_1A_FORMS);
    target = clientTestRule.target(API.RFA_1A_FORMS + "/" + rfaFormCreate.getId());
    rfaFormCreate.setOtherTypeDescription("newOtherTypeDescription");
    RFA1aFormDTO rfaFormGet = target.request(MediaType.APPLICATION_JSON)
        .put(Entity.entity(rfaFormCreate, MediaType.APPLICATION_JSON_TYPE), RFA1aFormDTO.class);

    assertNotNull(rfaFormGet);
    assertEquals(rfaFormCreate, rfaFormGet);
  }

  @Test
  public void getAllApplicationFormsTest() throws Exception {
    WebTarget target = clientTestRule.target(API.RFA_1A_FORMS);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    RFA1aFormDTO rfaFormCreate1 = createForm(clientTestRule);
    RFA1aFormDTO rfaFormCreate2 = createForm(clientTestRule);
    RFA1aFormDTO rfaFormCreate3 = createForm(clientTestRule);

    assertNotEquals(rfaFormCreate1, rfaFormCreate2);
    assertNotEquals(rfaFormCreate2, rfaFormCreate3);
    assertNotEquals(rfaFormCreate3, rfaFormCreate1);

    target = clientTestRule.target(API.RFA_1A_FORMS);
    invocation = target.request(MediaType.APPLICATION_JSON);
    RFA1aFormCollectionDTO rfaForms = invocation.get(RFA1aFormCollectionDTO.class);

    assertTrue(rfaForms.getCollection().size() >= 3);
  }
}
