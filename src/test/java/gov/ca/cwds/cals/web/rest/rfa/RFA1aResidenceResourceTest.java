package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ResidenceDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */

public class RFA1aResidenceResourceTest extends BaseInternalEntityApiTest<ResidenceDTO> {

  @Override
  protected BaseInternalEntityApiHelper<ResidenceDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<ResidenceDTO> configuration =

        new TestInternalEntityConfiguration<ResidenceDTO>(
            clientTestRule, ResidenceDTO.class, API.RESIDENCE) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-residence-request.json";
          }

        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
    }

}