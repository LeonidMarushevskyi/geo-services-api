package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.AdoptionHistoryDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aAdoptionHistoryResourceTest extends
    BaseInternalEntityApiTest<AdoptionHistoryDTO> {

  @Override
  protected BaseInternalEntityApiHelper<AdoptionHistoryDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<AdoptionHistoryDTO> configuration =
        new TestInternalEntityConfiguration<AdoptionHistoryDTO>(
            clientTestRule, AdoptionHistoryDTO.class, API.RFA_1A_ADOPTION_HISTORY) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-adoption-history.json";
          }
        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
  }
}
