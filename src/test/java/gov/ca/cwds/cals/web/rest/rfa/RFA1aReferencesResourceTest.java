package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ReferencesDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aReferencesResourceTest extends BaseInternalEntityApiTest<ReferencesDTO> {

  @Override
  protected BaseInternalEntityApiHelper<ReferencesDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<ReferencesDTO> configuration =
        new TestInternalEntityConfiguration<ReferencesDTO>(
            clientTestRule, ReferencesDTO.class, API.RFA_1A_REFERENCES) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-references.json";
          }
        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
  }
}
