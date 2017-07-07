package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.Constants.API;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1cFormCollectionDTO;
import gov.ca.cwds.cals.web.rest.rfa.configuration.TestExternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */

public class RFA1cResourceTest extends
    BaseExternalEntityApiTest<RFA1cFormDTO, RFA1cFormCollectionDTO> {

  @Override
  protected BaseExternalEntityApiHelper<RFA1cFormDTO, RFA1cFormCollectionDTO> getExternalEntityApiHelper() {

    TestExternalEntityConfiguration<RFA1cFormDTO, RFA1cFormCollectionDTO> configuration =

        new TestExternalEntityConfiguration<RFA1cFormDTO, RFA1cFormCollectionDTO>(
            clientTestRule,
            RFA1cFormDTO.class,
            RFA1cFormCollectionDTO.class,
            API.RFA_1C_FORMS) {

          @Override
          protected String getCreateFixture() {
            return "fixtures/rfa/rfa-1c-form.json";
          }

          @Override
          public void modifyEntity(RFA1cFormDTO rfa1cFormDTO) {
            CountyType applicationCounty = new CountyType();
            applicationCounty.setId(1000l);
            applicationCounty.setValue("Some county");
            rfa1cFormDTO.setApplicationCounty(applicationCounty);
          }

        };

    return new BaseExternalEntityApiHelper<>(clientTestRule, configuration);
  }

}
