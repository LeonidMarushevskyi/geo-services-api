package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aApplicantDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant;
import gov.ca.cwds.cals.service.dto.rfa.ApplicantCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.ApplicantFactory;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aApplicantService
    extends AbstractRFAExternalEntityService<
    RFA1aApplicant, ApplicantDTO, RFAExternalEntityParameterObject<ApplicantDTO>, ApplicantCollectionDTO> {

  @Inject
  public RFA1aApplicantService(RFA1aApplicantDao dao) {
    super(dao, ApplicantFactory.INSTANCE);
  }

}
