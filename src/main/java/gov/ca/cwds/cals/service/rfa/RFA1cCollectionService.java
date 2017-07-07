package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1cDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1cFormCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFA1cFactory;

/**
 * @author CWDS CALS API Team
 */
public class RFA1cCollectionService
    extends AbstractRFAExternalEntitiesCollectionService<
    RFA1cForm, RFA1cFormDTO, RFA1cFormCollectionDTO> {

  @Inject
  public RFA1cCollectionService(RFA1cDao dao) {
    super(dao, RFA1cFactory.INSTANCE);
  }
}
