package gov.ca.cwds.cals.persistence.dao.cms;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.inject.CmsSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;

/** @author CWDS CALS API Team */
public class CountiesDao extends BaseDaoImpl<County> {
  private static final Logger LOG = LoggerFactory.getLogger(CountiesDao.class);

  @Inject
  public CountiesDao(@CmsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public List<County> findAll() {
    Session session = this.getSessionFactory().getCurrentSession();
    Query<County> query = session.createNamedQuery(County.NQ_ALL, County.class);
    ImmutableList.Builder<County> entities = new ImmutableList.Builder<>();
    entities.addAll(query.list());
    return entities.build();
  }

  public County findByLogicalId(String logicalId) {
    Session session = this.getSessionFactory().getCurrentSession();
    Class<County> entityClass = getEntityClass();
    Query<County> query =
        session.createNamedQuery(entityClass.getSimpleName() + ".findByLogicalId", County.class);
    query.setParameter("logicalId", logicalId);
    County county = null;
    try {
      county = query.getSingleResult();
    } catch (NoResultException e) {
      LOG.warn("There is no result for logicalId = {}", logicalId);
      LOG.debug(e.getMessage(), e);
    }

    return county;
  }
}
