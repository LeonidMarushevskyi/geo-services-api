package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ChildDesiredDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */

public class RFA1aChildDesiredResourceTest extends
    BaseInternalEntityApiTest<ChildDesiredDTO> {

  @Override
  protected BaseInternalEntityApiHelper<ChildDesiredDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<ChildDesiredDTO> configuration =

        new TestInternalEntityConfiguration<ChildDesiredDTO>(
            clientTestRule, ChildDesiredDTO.class, Constants.API.CHILD_DESIRED) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-child-desired.json";
          }

        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
  }

}
