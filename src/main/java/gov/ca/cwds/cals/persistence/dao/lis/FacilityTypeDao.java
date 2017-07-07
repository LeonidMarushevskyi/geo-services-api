package gov.ca.cwds.cals.persistence.dao.lis;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.LisSessionFactory;
import gov.ca.cwds.cals.persistence.model.lisfas.FacilityType;
import gov.ca.cwds.data.BaseDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/** @author CWDS CALS API Team */
public class FacilityTypeDao extends BaseDaoImpl<FacilityType> {

  @Inject
  public FacilityTypeDao(@LisSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public List<FacilityType> findAll() {
    Session session = this.getSessionFactory().getCurrentSession();
    Query<FacilityType> query =
        session.createNamedQuery(
            this.getEntityClass().getSimpleName() + ".findAll", FacilityType.class);
    ImmutableList.Builder<FacilityType> entities = new ImmutableList.Builder<>();
    entities.addAll(query.list());
    return entities.build();
  }
}
