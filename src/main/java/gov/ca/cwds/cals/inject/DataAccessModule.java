package gov.ca.cwds.cals.inject;

import static gov.ca.cwds.cals.Constants.UnitOfWork.CALSNS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.CMS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.FAS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.LIS;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.cals.CalsApiConfiguration;
import gov.ca.cwds.cals.persistence.dao.calsns.DictionariesDao;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aApplicantDao;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.dao.cms.ClientDao;
import gov.ca.cwds.cals.persistence.dao.cms.CountiesDao;
import gov.ca.cwds.cals.persistence.dao.cms.PlacementHomeDao;
import gov.ca.cwds.cals.persistence.dao.fas.ComplaintReportLic802Dao;
import gov.ca.cwds.cals.persistence.dao.fas.InspectionDao;
import gov.ca.cwds.cals.persistence.dao.fas.LpaInformationDao;
import gov.ca.cwds.cals.persistence.dao.lis.FacilityTypeDao;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AddressType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AgeGroupType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ApplicantRelationshipType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.EducationLevelType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.EthnicityType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.GenderType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.IncomeType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.LanguageType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.LicenseType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.MarriageTerminationReason;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.NameType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.PhoneNumberType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.RaceType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ResidenceOwnershipType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.SiblingGroupType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aOtherAdult;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cForm;
import gov.ca.cwds.cals.persistence.model.cms.FacilityType;
import gov.ca.cwds.cals.persistence.model.cms.LicenseStatus;
import gov.ca.cwds.cals.persistence.model.cms.State;
import gov.ca.cwds.cals.persistence.model.cms.VisitType;
import gov.ca.cwds.cals.persistence.model.cms.legacy.Client;
import gov.ca.cwds.cals.persistence.model.cms.legacy.CountyLicenseCase;
import gov.ca.cwds.cals.persistence.model.cms.legacy.LicensingVisit;
import gov.ca.cwds.cals.persistence.model.cms.legacy.OutOfHomePlacement;
import gov.ca.cwds.cals.persistence.model.cms.legacy.PlacementEpisode;
import gov.ca.cwds.cals.persistence.model.cms.legacy.PlacementHome;
import gov.ca.cwds.cals.persistence.model.cms.legacy.StaffPerson;
import gov.ca.cwds.cals.persistence.model.fas.ComplaintReportLic802;
import gov.ca.cwds.cals.persistence.model.fas.LpaInformation;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.persistence.model.fas.Rrcpoc;
import gov.ca.cwds.cals.persistence.model.lisfas.County;
import gov.ca.cwds.cals.persistence.model.lisfas.FacilityStatusType;
import gov.ca.cwds.cals.persistence.model.lisfas.LisDoFile;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.persistence.model.lisfas.LisTableFile;
import gov.ca.cwds.cals.persistence.model.lisfas.VisitReasonType;
import gov.ca.cwds.inject.CmsHibernateBundle;
import gov.ca.cwds.inject.CmsSessionFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

/** @author CWDS CALS API Team */
public class DataAccessModule extends AbstractModule {

  private final HibernateBundle<CalsApiConfiguration> lisHibernateBundle =
      new HibernateBundle<CalsApiConfiguration>(
          LisFacFile.class,
          LisTableFile.class,
          gov.ca.cwds.cals.persistence.model.lisfas.FacilityType.class,
          LisDoFile.class,
          FacilityStatusType.class,
          VisitReasonType.class,
          County.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CalsApiConfiguration configuration) {
          return configuration.getLisDataSourceFactory();
        }

        @Override
        public String name() {
          return LIS;
        }
      };

  private final HibernateBundle<CalsApiConfiguration> fasHibernateBundle =
      new HibernateBundle<CalsApiConfiguration>(
          LisFacFile.class,
          LisTableFile.class,
          gov.ca.cwds.cals.persistence.model.lisfas.FacilityType.class,
          LisDoFile.class,
          FacilityStatusType.class,
          VisitReasonType.class,
          County.class,
          ComplaintReportLic802.class,
          LpaInformation.class,
          Rrcpoc.class,
          Rr809Dn.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CalsApiConfiguration configuration) {
          return configuration.getFasDataSourceFactory();
        }

        @Override
        public String name() {
          return FAS;
        }
      };

  private final HibernateBundle<CalsApiConfiguration> cmsHibernateBundle =
      new HibernateBundle<CalsApiConfiguration>(
          Client.class,
          OutOfHomePlacement.class,
          PlacementEpisode.class,
          PlacementHome.class,
          StaffPerson.class,
          FacilityType.class,
          gov.ca.cwds.cals.persistence.model.cms.County.class,
          CountyLicenseCase.class,
          LicensingVisit.class,
          VisitType.class,
          State.class,
          LicenseStatus.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CalsApiConfiguration configuration) {
          return configuration.getCmsDataSourceFactory();
        }

        @Override
        public String name() {
          return CMS;
        }
      };

  private final HibernateBundle<CalsApiConfiguration> calsnsHibernateBundle =
      new HibernateBundle<CalsApiConfiguration>(
          // Dictionaries
          AgeGroupType.class,
          LanguageType.class,
          GenderType.class,
          NameType.class,
          EducationLevelType.class,
          EthnicityType.class,
          RaceType.class,
          IncomeType.class,
          PhoneNumberType.class,
          AddressType.class,
          SiblingGroupType.class,
          StateType.class,
          ResidenceOwnershipType.class,
          ApplicantRelationshipType.class,
          LicenseType.class,
          MarriageTerminationReason.class,
          //RFA
          RFA1aForm.class,
          RFA1aApplicant.class,
          RFA1aMinorChild.class,
          RFA1aOtherAdult.class,
          RFA1bForm.class,
          RFA1cForm.class
      ) {

        @Override
        public DataSourceFactory getDataSourceFactory(CalsApiConfiguration configuration) {
          return configuration.getCalsnsDataSourceFactory();
        }

        @Override
        public String name() {
          return CALSNS;
        }

        @Override
        public void configure(org.hibernate.cfg.Configuration configuration) {
          configuration.addPackage("gov.ca.cwds.cals.persistence.model.calsns.rfa");
        }

      };

  public DataAccessModule(Bootstrap<CalsApiConfiguration> bootstrap) {
    bootstrap.addBundle(fasHibernateBundle);
    bootstrap.addBundle(cmsHibernateBundle);
    bootstrap.addBundle(lisHibernateBundle);
    bootstrap.addBundle(calsnsHibernateBundle);
  }

  @Override
  protected void configure() {
    bind(ComplaintReportLic802Dao.class);
    bind(FacilityTypeDao.class);
    bind(CountiesDao.class);
    bind(ClientDao.class);
    bind(PlacementHomeDao.class);
    bind(LpaInformationDao.class);
    bind(InspectionDao.class);
    bind(DictionariesDao.class);

    // RFA
    bind(RFA1aFormsDao.class);
    bind(RFA1aApplicantDao.class);

  }

  @Provides
  @FasSessionFactory
  SessionFactory fasSessionFactory() {
    return fasHibernateBundle.getSessionFactory();
  }

  @Provides
  @CmsSessionFactory
  SessionFactory cmsSessionFactory() {
    return cmsHibernateBundle.getSessionFactory();
  }

  @Provides
  @LisSessionFactory
  SessionFactory lisSessionFactory() {
    return lisHibernateBundle.getSessionFactory();
  }

  @Provides
  @CalsnsSessionFactory
  SessionFactory calsnsSessionFactory() {
    return calsnsHibernateBundle.getSessionFactory();
  }

  @Provides
  @FasHibernateBundle
  HibernateBundle<CalsApiConfiguration> fasHibernateBundle() {
    return fasHibernateBundle;
  }

  @Provides
  @CmsHibernateBundle
  public HibernateBundle<CalsApiConfiguration> getCmsHibernateBundle() {
    return cmsHibernateBundle;
  }

  @Provides
  @LisHibernateBundle
  public HibernateBundle<CalsApiConfiguration> getLisHibernateBundle() {
    return lisHibernateBundle;
  }

  @Provides
  @CalsnsHibernateBundle
  public HibernateBundle<CalsApiConfiguration> getCalsnsHibernateBundle() {
    return calsnsHibernateBundle;
  }

  @Provides
  UnitOfWorkAwareProxyFactory lisUnitOfWorkAwareProxyFactory() {
    return new UnitOfWorkAwareProxyFactory(
        lisHibernateBundle, fasHibernateBundle, cmsHibernateBundle, calsnsHibernateBundle);
  }
}
