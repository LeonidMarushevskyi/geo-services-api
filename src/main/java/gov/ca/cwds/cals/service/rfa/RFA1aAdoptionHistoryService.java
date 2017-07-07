package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.AdoptionHistoryDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.rfa.factory.RFAInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aAdoptionHistoryService extends
    AbstractRFAInternalEntityService<AdoptionHistoryDTO> {

  @Inject
  public RFA1aAdoptionHistoryService(RFA1aFormsDao applicationDao) {

    super(
        applicationDao,
        new RFAInternalEntityConfiguration<AdoptionHistoryDTO>(AdoptionHistoryDTO.class) {

          @Override
          protected AdoptionHistoryDTO retrieveEntityFromTheForm(RFA1aForm form) {
            return form.getAdoptionHistory();
          }

          @Override
          protected void saveEntityToTheForm(RFA1aForm form, AdoptionHistoryDTO entity) {
            form.setAdoptionHistory(entity);
          }
        });
  }
}
