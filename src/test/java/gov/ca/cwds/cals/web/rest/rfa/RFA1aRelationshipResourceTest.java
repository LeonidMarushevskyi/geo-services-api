package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantsRelationshipDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aRelationshipResourceTest extends
    BaseInternalEntityApiTest<ApplicantsRelationshipDTO> {

  @Override
  protected BaseInternalEntityApiHelper<ApplicantsRelationshipDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<ApplicantsRelationshipDTO> configuration =

        new TestInternalEntityConfiguration<ApplicantsRelationshipDTO>(
            clientTestRule, ApplicantsRelationshipDTO.class, API.APPLICANTS_RELATIONSHIP) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-applicants-relationship.json";
          }

        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
  }

}
