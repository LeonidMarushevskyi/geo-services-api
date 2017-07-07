package gov.ca.cwds.cals.persistence.dao.fas;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FasSessionFactory;
import gov.ca.cwds.cals.persistence.model.fas.LpaInformation;
import gov.ca.cwds.data.BaseDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

/** @author CWDS CALS API Team */
public class LpaInformationDao extends BaseDaoImpl<LpaInformation> {

  private static final Logger LOG = LoggerFactory.getLogger(LpaInformationDao.class);

  @Inject
  public LpaInformationDao(@FasSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public LpaInformation findByLpaCode(String lpaCode) {
    Session session = getSessionFactory().getCurrentSession();
    Class<LpaInformation> entityClass = getEntityClass();
    Query<LpaInformation> query =
        session.createNamedQuery(LpaInformation.FIND_ASSIGNED_WORKER_BY_LPA_CODE, entityClass);
    query.setParameter(LpaInformation.PARAM_LPA_CODE, lpaCode);
    LpaInformation res = null;
    try {
      res = query.getSingleResult();
    } catch (NoResultException e) {
      LOG.warn("There is no result for lpaCode: {}", lpaCode);
      LOG.debug(e.getMessage(), e);
    }
    return res;
  }
}
