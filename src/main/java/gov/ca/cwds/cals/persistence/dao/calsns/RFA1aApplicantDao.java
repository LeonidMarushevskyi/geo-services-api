package gov.ca.cwds.cals.persistence.dao.calsns;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.CalsnsSessionFactory;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant;
import gov.ca.cwds.cals.service.dto.rfa.ApplicantCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.ApplicantFactory;
import org.hibernate.SessionFactory;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aApplicantDao extends
    RFAExternalEntityDao<RFA1aApplicant, ApplicantDTO, ApplicantCollectionDTO> {

  @Inject
  public RFA1aApplicantDao(@CalsnsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory, ApplicantFactory.INSTANCE);
  }

}
