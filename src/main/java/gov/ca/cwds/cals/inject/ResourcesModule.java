package gov.ca.cwds.cals.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import gov.ca.cwds.cals.CalsApiConfiguration;
import gov.ca.cwds.cals.service.ComplaintService;
import gov.ca.cwds.cals.service.ComplaintsCollectionService;
import gov.ca.cwds.cals.service.CountiesService;
import gov.ca.cwds.cals.service.DictionariesService;
import gov.ca.cwds.cals.service.FacilityChildCollectionService;
import gov.ca.cwds.cals.service.FacilityChildService;
import gov.ca.cwds.cals.service.FacilityInspectionCollectionService;
import gov.ca.cwds.cals.service.FacilityInspectionService;
import gov.ca.cwds.cals.service.FacilityService;
import gov.ca.cwds.cals.service.FacilityTypeCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1aAdoptionHistoryService;
import gov.ca.cwds.cals.service.rfa.RFA1aApplicantService;
import gov.ca.cwds.cals.service.rfa.RFA1aApplicantsCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1aApplicantsDeclarationService;
import gov.ca.cwds.cals.service.rfa.RFA1aApplicantsHistoryService;
import gov.ca.cwds.cals.service.rfa.RFA1aApplicantsRelationshipService;
import gov.ca.cwds.cals.service.rfa.RFA1aChildDesiredService;
import gov.ca.cwds.cals.service.rfa.RFA1aFormService;
import gov.ca.cwds.cals.service.rfa.RFA1aFormsCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1aMinorChildService;
import gov.ca.cwds.cals.service.rfa.RFA1aMinorChildrenCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1aOtherAdultService;
import gov.ca.cwds.cals.service.rfa.RFA1aOtherAdultsCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1aReferencesService;
import gov.ca.cwds.cals.service.rfa.RFA1aResidenceService;
import gov.ca.cwds.cals.service.rfa.RFA1bCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1bService;
import gov.ca.cwds.cals.service.rfa.RFA1cCollectionService;
import gov.ca.cwds.cals.service.rfa.RFA1cService;
import gov.ca.cwds.cals.web.rest.ApplicationResource;
import gov.ca.cwds.cals.web.rest.CountiesResource;
import gov.ca.cwds.cals.web.rest.DictionariesResource;
import gov.ca.cwds.cals.web.rest.FacilityChildResource;
import gov.ca.cwds.cals.web.rest.FacilityComplaintResource;
import gov.ca.cwds.cals.web.rest.FacilityInspectionsResource;
import gov.ca.cwds.cals.web.rest.FacilityResource;
import gov.ca.cwds.cals.web.rest.FacilityTypeResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aAdoptionHistoryResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aApplicantsDeclarationResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aApplicantsHistoryResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aApplicantsRelationshipResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aApplicantsResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aChildDesiredResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aFormsResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aMinorChildrenResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aOtherAdultsResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aReferencesResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1aResidenceResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1bFormsResource;
import gov.ca.cwds.cals.web.rest.rfa.RFA1cFormsResource;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import gov.ca.cwds.rest.resources.ServiceBackedResourceDelegate;

/**
 * Identifies all CALS API domain resource classes available for dependency injection by Guice.
 *
 * @author CALS API Team
 */
public class ResourcesModule extends AbstractModule {

  /** Default constructor */
  public ResourcesModule() {
    // Do nothing - Default Constructor
  }

  @Override
  protected void configure() {
    bind(ApplicationResource.class);
    bind(FacilityResource.class);
    bind(FacilityChildResource.class);
    bind(FacilityComplaintResource.class);
    bind(FacilityInspectionsResource.class);
    bind(CountiesResource.class);
    bind(FacilityTypeResource.class);
    bind(DictionariesResource.class);

    // RFA
    bind(RFA1aFormsResource.class);
    bind(RFA1aApplicantsResource.class);
    bind(RFA1aMinorChildrenResource.class);
    bind(RFA1aResidenceResource.class);
    bind(RFA1aApplicantsRelationshipResource.class);
    bind(RFA1aOtherAdultsResource.class);
    bind(RFA1aAdoptionHistoryResource.class);
    bind(RFA1aApplicantsHistoryResource.class);
    bind(RFA1aReferencesResource.class);
    bind(RFA1aChildDesiredResource.class);
    bind(RFA1aApplicantsDeclarationResource.class);
    bind(RFA1bFormsResource.class);
    bind(RFA1cFormsResource.class);
  }

  @Provides
  @Named("app.name")
  public String appName(CalsApiConfiguration calsApiConfiguration) {
    return calsApiConfiguration.getApplicationName();
  }

  @Provides
  @Named("app.version")
  public String appVersion(CalsApiConfiguration calsApiConfiguration) {
    return calsApiConfiguration.getVersion();
  }

  @Provides
  @FacilityServiceBackedResource
  public ResourceDelegate facilityServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(FacilityService.class));
  }

  @Provides
  @FacilityChildServiceBackedResource
  public ResourceDelegate facilityChildServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(FacilityChildService.class));
  }

  @Provides
  @FacilityChildCollectionServiceBackedResource
  public ResourceDelegate facilityChildServiceCollectionBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(FacilityChildCollectionService.class));
  }

  @Provides
  @FacilityTypeCollectionServiceBackedResource
  public ResourceDelegate facilityTypeServiceCollectionBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(FacilityTypeCollectionService.class));
  }

  @Provides
  @ComplaintsCollectionServiceBackedResource
  public ResourceDelegate complaintsCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(ComplaintsCollectionService.class));
  }

  @Provides
  @ComplaintServiceBackedResource
  public ResourceDelegate complaintServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(ComplaintService.class));
  }

  @Provides
  @FacilityInspectionCollectionServiceBackedResource
  public ResourceDelegate facilityInspectionCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(FacilityInspectionCollectionService.class));
  }

  @Provides
  @FacilityInspectionServiceBackedResource
  public ResourceDelegate facilityInspectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(FacilityInspectionService.class));
  }

  @Provides
  @CountiesServiceBackedResource
  public ResourceDelegate countiesServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(CountiesService.class));
  }

  @Provides
  @DictionariesServiceBackedResource
  public ResourceDelegate dictionariesServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(DictionariesService.class));
  }

  @Provides
  @ResidenceServiceBackedResource
  public ResourceDelegate residenceServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aResidenceService.class));
  }

  @Provides
  @ChildDesiredServiceBackedResource
  public ResourceDelegate childDesiredServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aChildDesiredService.class));
  }

  @Provides
  @ApplicantsHistoryServiceBackedResource
  public ResourceDelegate applicantsHistoryServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aApplicantsHistoryService.class));
  }

  @Provides
  @ApplicantsRelationshipServiceBackedResource
  public ResourceDelegate applicantsRelationshipServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aApplicantsRelationshipService.class));
  }

  @Provides
  @RFA1aFormServiceBackedResource
  public ResourceDelegate rfa1aFormsServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aFormService.class));
  }

  @Provides
  @RFA1aFormCollectionServiceBackedResource
  public ResourceDelegate rfa1aFormsCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aFormsCollectionService.class));
  }

  @Provides
  @RFA1aApplicantServiceBackedResource
  public ResourceDelegate rfa1aApplicantServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aApplicantService.class));
  }

  @Provides
  @RFA1aApplicantsCollectionServiceBackedResource
  public ResourceDelegate rfa1aApplicantsCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aApplicantsCollectionService.class));
  }

  @Provides
  @RFA1aMinorChildrenServiceBackedResource
  public ResourceDelegate rfa1aMinorChildServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aMinorChildService.class));
  }

  @Provides
  @RFA1aMinorChildrenCollectionServiceBackedResource
  public ResourceDelegate rfa1aMinorChildrenCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aMinorChildrenCollectionService.class));
  }

  @Provides
  @RFA1aOtherAdultsServiceBackedResource
  public ResourceDelegate rfa1aOtherAdultServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1aOtherAdultService.class));
  }

  @Provides
  @RFA1aOtherAdultsCollectionServiceBackedResource
  public ResourceDelegate rfa1aOtherAdultsCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aOtherAdultsCollectionService.class));
  }

  @Provides
  @RFA1bServiceBackedResource
  public ResourceDelegate rfa1bServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1bService.class));
  }

  @Provides
  @RFA1bCollectionServiceBackedResource
  public ResourceDelegate rfa1bCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1bCollectionService.class));
  }

  @Provides
  @RFA1cServiceBackedResource
  public ResourceDelegate rfa1cServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(injector.getInstance(RFA1cService.class));
  }

  @Provides
  @RFA1cCollectionServiceBackedResource
  public ResourceDelegate rfa1cCollectionServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1cCollectionService.class));
  }

  @Provides
  @RFA1aAdoptionHistoryServiceBackedResource
  public ResourceDelegate rfa1aAdoptionHistoryServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aAdoptionHistoryService.class));
  }

  @Provides
  @RFA1aReferencesServiceBackedResource
  public ResourceDelegate rfa1aReferencesServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aReferencesService.class));
  }

  @Provides
  @RFA1aApplicantsDeclarationServiceBackedResource
  public ResourceDelegate rfa1aApplicantsDeclarationServiceBackedResource(Injector injector) {
    return new ServiceBackedResourceDelegate(
        injector.getInstance(RFA1aApplicantsDeclarationService.class));
  }


}
