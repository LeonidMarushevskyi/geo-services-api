package gov.ca.cwds.cals.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cals.persistence.dao.cms.RecordChangeCwsCmsDao;
import gov.ca.cwds.cals.persistence.model.RecordChange;
import gov.ca.cwds.cals.persistence.dao.cms.ClientDao;
import gov.ca.cwds.cals.persistence.dao.cms.PlacementHomeDao;
import gov.ca.cwds.cals.persistence.model.cms.LicenseStatus;
import gov.ca.cwds.cals.persistence.model.cms.legacy.Client;
import gov.ca.cwds.cals.persistence.model.cms.legacy.CountyLicenseCase;
import gov.ca.cwds.cals.persistence.model.cms.legacy.LicensingVisit;
import gov.ca.cwds.cals.persistence.model.cms.legacy.OutOfHomePlacement;
import gov.ca.cwds.cals.persistence.model.cms.legacy.PlacementEpisode;
import gov.ca.cwds.cals.persistence.model.cms.legacy.PlacementHome;
import gov.ca.cwds.cals.persistence.model.cms.legacy.StaffPerson;
import gov.ca.cwds.cals.persistence.model.cms.State;
import gov.ca.cwds.cals.persistence.model.cms.VisitType;
import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.cals.persistence.model.cms.FacilityType;
import gov.ca.cwds.cals.persistence.dao.cms.CountiesDao;
import gov.ca.cwds.inject.CmsSessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author CWDS TPT-2
 */
public class ReplicatedCwsCmsDataAccessModule extends AbstractModule {
  private SessionFactory cmsSessionFactory;

  public ReplicatedCwsCmsDataAccessModule(String hibernateCfg) {
    this.cmsSessionFactory = new Configuration().configure(hibernateCfg)
        .addAnnotatedClass(RecordChange.class)
        .addAnnotatedClass(Client.class)
        .addAnnotatedClass(OutOfHomePlacement.class)
        .addAnnotatedClass(PlacementEpisode.class)
        .addAnnotatedClass(PlacementHome.class)
        .addAnnotatedClass(CountyLicenseCase.class)
        .addAnnotatedClass(LicensingVisit.class)
        .addAnnotatedClass(StaffPerson.class)
        .addAnnotatedClass(FacilityType.class)
        .addAnnotatedClass(County.class)
        .addAnnotatedClass(VisitType.class)
        .addAnnotatedClass(State.class)
        .addAnnotatedClass(LicenseStatus.class)
        .buildSessionFactory();
  }

  @Override
  protected void configure() {
    bind(SessionFactory.class).annotatedWith(CmsSessionFactory.class).toInstance(cmsSessionFactory);

    // schema: cwscms
    bind(RecordChangeCwsCmsDao.class);
    bind(CountiesDao.class);
    bind(ClientDao.class);
    bind(PlacementHomeDao.class);
  }
}
