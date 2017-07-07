package gov.ca.cwds.cals.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cals.persistence.dao.fas.ComplaintReportLic802Dao;
import gov.ca.cwds.cals.persistence.dao.fas.InspectionDao;
import gov.ca.cwds.cals.persistence.dao.fas.LisFacFileFasDao;
import gov.ca.cwds.cals.persistence.dao.fas.LpaInformationDao;
import gov.ca.cwds.cals.persistence.model.fas.ComplaintReportLic802;
import gov.ca.cwds.cals.persistence.model.fas.LpaInformation;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.persistence.model.fas.Rrcpoc;
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
public class FasDataAccessModule extends AbstractModule {

  private SessionFactory fasSessionFactory;

  public FasDataAccessModule(String hibernateCfg) {
    this.fasSessionFactory = new Configuration().configure(hibernateCfg)
        .addAnnotatedClass(LisFacFile.class)
        .addAnnotatedClass(LisTableFile.class)
        .addAnnotatedClass(FacilityType.class)
        .addAnnotatedClass(LisDoFile.class)
        .addAnnotatedClass(FacilityStatusType.class)
        .addAnnotatedClass(VisitReasonType.class)
        .addAnnotatedClass(County.class)
        .addAnnotatedClass(ComplaintReportLic802.class)
        .addAnnotatedClass(LpaInformation.class)
        .addAnnotatedClass(Rrcpoc.class)
        .addAnnotatedClass(Rrcpoc.class)
        .addAnnotatedClass(Rr809Dn.class)
        .buildSessionFactory();

  }

  @Override
  protected void configure() {
    bind(SessionFactory.class).annotatedWith(FasSessionFactory.class).toInstance(fasSessionFactory);

    // schema: fas
    bind(ComplaintReportLic802Dao.class);
    bind(LpaInformationDao.class);
    bind(InspectionDao.class);
    bind(LisFacFileFasDao.class);
  }
}
