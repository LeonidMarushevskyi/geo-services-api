package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.OtherAdultDTO;
import gov.ca.cwds.cals.service.dto.rfa.OtherAdultCollectionDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestExternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */

public class RFA1aOtherAdultsResourceTest extends
    BaseExternalEntityApiTest<OtherAdultDTO, OtherAdultCollectionDTO> {

  @Override
  protected BaseExternalEntityApiHelper<OtherAdultDTO, OtherAdultCollectionDTO> getExternalEntityApiHelper() {

    TestExternalEntityConfiguration<OtherAdultDTO, OtherAdultCollectionDTO> configuration =

        new TestExternalEntityConfiguration<OtherAdultDTO, OtherAdultCollectionDTO>(
            clientTestRule,
            OtherAdultDTO.class,
            OtherAdultCollectionDTO.class,
            API.RFA_1A_OTHER_ADULTS) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1a-other-adults.json";
          }

          @Override
          public void modifyEntity(OtherAdultDTO entity) {
            entity.setFirstName("FIRST_NAME");
          }

        };

    return new BaseExternalEntityApiHelper<>(clientTestRule, configuration);
  }

}
