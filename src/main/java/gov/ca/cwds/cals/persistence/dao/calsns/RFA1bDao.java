package gov.ca.cwds.cals.persistence.dao.calsns;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.CalsnsSessionFactory;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1bFormCollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFA1bFactory;
import org.hibernate.SessionFactory;

/**
 * @author CWDS CALS API Team
 */

public class RFA1bDao extends
    RFAExternalEntityDao<RFA1bForm, RFA1bFormDTO, RFA1bFormCollectionDTO> {

  @Inject
  public RFA1bDao(@CalsnsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory, RFA1bFactory.INSTANCE);
  }

}
