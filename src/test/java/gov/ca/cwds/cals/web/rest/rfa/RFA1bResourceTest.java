package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1bFormCollectionDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestExternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */

public class RFA1bResourceTest extends
    BaseExternalEntityApiTest<RFA1bFormDTO, RFA1bFormCollectionDTO> {

  @Override
  protected BaseExternalEntityApiHelper<RFA1bFormDTO, RFA1bFormCollectionDTO> getExternalEntityApiHelper() {

    TestExternalEntityConfiguration<RFA1bFormDTO, RFA1bFormCollectionDTO> configuration =

        new TestExternalEntityConfiguration<RFA1bFormDTO, RFA1bFormCollectionDTO>(
            clientTestRule,
            RFA1bFormDTO.class,
            RFA1bFormCollectionDTO.class,
            API.RFA_1B_FORMS) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1b-form.json";
          }

          @Override
          public void modifyEntity(RFA1bFormDTO rfa1bFormDTO) {
            rfa1bFormDTO.setApplicantFirstName("Petya");
          }

        };

    return new BaseExternalEntityApiHelper<>(clientTestRule, configuration);
  }

}
