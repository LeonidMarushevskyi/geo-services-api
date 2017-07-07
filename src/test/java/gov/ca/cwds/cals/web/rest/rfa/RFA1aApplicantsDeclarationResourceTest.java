package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantsDeclarationDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aApplicantsDeclarationResourceTest
    extends BaseInternalEntityApiTest<ApplicantsDeclarationDTO> {

  @Override
  protected BaseInternalEntityApiHelper<ApplicantsDeclarationDTO> getInternalEntityApiHelper() {

    TestInternalEntityConfiguration<ApplicantsDeclarationDTO> configuration =
        new TestInternalEntityConfiguration<ApplicantsDeclarationDTO>(
            clientTestRule, ApplicantsDeclarationDTO.class, API.RFA_1A_APPLICANTS_DECLARATION) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-applicants-declaration.json";
          }
        };

    return new BaseInternalEntityApiHelper<>(clientTestRule, configuration);
  }
}
