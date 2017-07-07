package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aOtherAdultDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.OtherAdultDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aOtherAdult;
import gov.ca.cwds.cals.service.dto.rfa.OtherAdultCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.OtherAdultFactory;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aOtherAdultsCollectionService
    extends AbstractRFAExternalEntitiesCollectionService<
    RFA1aOtherAdult, OtherAdultDTO, OtherAdultCollectionDTO> {

  @Inject
  public RFA1aOtherAdultsCollectionService(RFA1aOtherAdultDao dao) {
    super(dao, OtherAdultFactory.INSTANCE);
  }
}
