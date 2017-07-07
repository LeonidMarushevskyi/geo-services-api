package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ReferencesDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFAInternalEntityConfiguration;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aReferencesService extends AbstractRFAInternalEntityService<ReferencesDTO> {

  @Inject
  public RFA1aReferencesService(RFA1aFormsDao applicationDao) {
    super(
        applicationDao,
        new RFAInternalEntityConfiguration<ReferencesDTO>(ReferencesDTO.class) {

          @Override
          protected ReferencesDTO retrieveEntityFromTheForm(RFA1aForm form) {
            return form.getReferences();
          }

          @Override
          protected void saveEntityToTheForm(RFA1aForm form, ReferencesDTO entity) {
            form.setReferences(entity);
          }
        });
  }
}
