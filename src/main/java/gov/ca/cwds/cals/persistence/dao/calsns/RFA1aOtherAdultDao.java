package gov.ca.cwds.cals.persistence.dao.calsns;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.CalsnsSessionFactory;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.OtherAdultDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aOtherAdult;
import gov.ca.cwds.cals.service.dto.rfa.OtherAdultCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.OtherAdultFactory;
import org.hibernate.SessionFactory;

/**
 * @author CWDS CALS API Team
 */

public class RFA1aOtherAdultDao extends
    RFAExternalEntityDao<RFA1aOtherAdult, OtherAdultDTO, OtherAdultCollectionDTO> {

  @Inject
  public RFA1aOtherAdultDao(@CalsnsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory, OtherAdultFactory.INSTANCE);
  }

}
