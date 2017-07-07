package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1bDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1bFormCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFA1bFactory;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;

/**
 * @author CWDS CALS API Team
 */
public class RFA1bService
    extends AbstractRFAExternalEntityService<
    RFA1bForm, RFA1bFormDTO, RFAExternalEntityParameterObject<RFA1bFormDTO>, RFA1bFormCollectionDTO> {

  @Inject
  public RFA1bService(RFA1bDao dao) {
    super(dao, RFA1bFactory.INSTANCE);
  }
}
