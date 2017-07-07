package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantDTO;
import gov.ca.cwds.cals.service.dto.rfa.ApplicantCollectionDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestExternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aApplicantResourceTest extends
    BaseExternalEntityApiTest<ApplicantDTO, ApplicantCollectionDTO> {

  @Override
  protected BaseExternalEntityApiHelper<ApplicantDTO, ApplicantCollectionDTO> getExternalEntityApiHelper() {
    TestExternalEntityConfiguration<ApplicantDTO, ApplicantCollectionDTO> configuration =

        new TestExternalEntityConfiguration<ApplicantDTO, ApplicantCollectionDTO>(
            clientTestRule,
            ApplicantDTO.class,
            ApplicantCollectionDTO.class,
            API.RFA_1A_APPLICANTS) {

          @Override
          protected String getCreateFixture() {
            //return "fixtures/rfa/rfa-1a-applicant.json";
            return "fixtures/rfa/stub.json";
          }

          @Override
          public void modifyEntity(ApplicantDTO entity) {
            entity.setFirstName("testFirstName");
          }

        };

    return new BaseExternalEntityApiHelper<>(clientTestRule, configuration);
  }
}
