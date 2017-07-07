package gov.ca.cwds.cals.persistence.dao.calsns;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.CalsnsSessionFactory;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.data.BaseDaoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aFormsDao extends BaseDaoImpl<RFA1aForm> {

  @Inject
  public RFA1aFormsDao(@CalsnsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public List<RFA1aForm> findAll() {
    Session session = this.getSessionFactory().getCurrentSession();
    Query<RFA1aForm> query =
        session.createNamedQuery(RFA1aForm.NAMED_QUERY_FIND_ALL, RFA1aForm.class);
    ImmutableList.Builder<RFA1aForm> entities = new ImmutableList.Builder<>();
    entities.addAll(query.list());
    return entities.build();
  }
}
