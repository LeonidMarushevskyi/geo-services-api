package gov.ca.cwds.cals.persistence.dao.lis;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.LisSessionFactory;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.data.BaseDaoImpl;
import org.hibernate.SessionFactory;

/** @author CWDS CALS API Team */
public class LisFacFileLisDao extends BaseDaoImpl<LisFacFile> {

  @Inject
  public LisFacFileLisDao(@LisSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
