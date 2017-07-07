package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aMinorChildDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.MinorChildDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild;
import gov.ca.cwds.cals.service.dto.rfa.MinorChildrenDTO;
import gov.ca.cwds.cals.service.rfa.factory.MinorChildFactory;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;

/**
 * @author CWDS CALS API Team
 */

public class RFA1aMinorChildService
    extends AbstractRFAExternalEntityService<
    RFA1aMinorChild, MinorChildDTO, RFAExternalEntityParameterObject<MinorChildDTO>, MinorChildrenDTO> {

  @Inject
  public RFA1aMinorChildService(RFA1aMinorChildDao dao) {
    super(dao, MinorChildFactory.INSTANCE);
  }

}

