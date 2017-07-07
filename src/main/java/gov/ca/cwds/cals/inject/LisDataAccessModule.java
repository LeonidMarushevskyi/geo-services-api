package gov.ca.cwds.cals.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cals.persistence.dao.lis.LisFacFileLisDao;
import gov.ca.cwds.cals.persistence.dao.lis.RecordChangeLisDao;
import gov.ca.cwds.cals.persistence.model.RecordChange;
import gov.ca.cwds.cals.persistence.model.lisfas.County;
import gov.ca.cwds.cals.persistence.model.lisfas.FacilityStatusType;
import gov.ca.cwds.cals.persistence.model.lisfas.FacilityType;
import gov.ca.cwds.cals.persistence.model.lisfas.LisDoFile;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.persistence.model.lisfas.LisTableFile;
import gov.ca.cwds.cals.persistence.model.lisfas.VisitReasonType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author CWDS TPT-2
 */
public class LisDataAccessModule extends AbstractModule {

  private SessionFactory lisSessionFactory;

  public LisDataAccessModule(String hibernateCfg) {
    this.lisSessionFactory = new Configuration().configure(hibernateCfg)
        .addAnnotatedClass(RecordChange.class)
        .addAnnotatedClass(LisFacFile.class)
        .addAnnotatedClass(LisTableFile.class)
        .addAnnotatedClass(FacilityType.class)
        .addAnnotatedClass(LisDoFile.class)
        .addAnnotatedClass(FacilityStatusType.class)
        .addAnnotatedClass(VisitReasonType.class)
        .addAnnotatedClass(County.class)
        .buildSessionFactory();
  }

  @Override
  protected void configure() {
    bind(SessionFactory.class).annotatedWith(LisSessionFactory.class).toInstance(lisSessionFactory);

    // schema: lis
    bind(RecordChangeLisDao.class);
    bind(LisFacFileLisDao.class);
  }
}
