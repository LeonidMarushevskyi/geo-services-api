package gov.ca.cwds.cals;

import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AddressType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AgeGroupType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.ApplicantRelationshipType;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.BaseDictionary;
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

/**
 * @author CWDS CALS API Team
 */
public final class Constants {

  public static final String SQL_TYPE = "sqlType";

  public static final String RETURNED_CLASS_NAME_PARAM = "returnedClassName";

  public static final String SYSTEM_USER_ID = "SYSTEM";

  public static final String RFA = "rfa";

  public static class API {

    public static final String FACILITIES = "facilities";

    public static final String RESOURCE_APPLICATION = "application";

    public static final String CHILDREN = "children";

    public static final String COMPLAINTS = "complaints";

    public static final String DICTIONARIES = "dictionaries";

    public static final String COUNTIES = "counties";

    public static final String INSPECTIONS = "inspections";

    public static final String FACILITY_TYPES = "facility-types";

    public static final String RFA_1A_FORMS = "rfa-1a-forms";

    public static final String RFA_1B_FORMS = "rfa-1b-forms";

    public static final String RFA_1C_FORMS = "rfa-1c-forms";

    public static final String RFA_1A_APPLICANTS = "applicants";

    public static final String APPLICANTS_RELATIONSHIP = "applicants-relationship";

    public static final String RFA_1A_MINOR_CHILDREN = "minor-children";

    public static final String RFA_1A_OTHER_ADULTS = "other-adults";

    public static final String RESIDENCE = "residence";

    public static final String RFA_1A_ADOPTION_HISTORY = "adoption-history";

    public static final String RFA_1A_REFERENCES = "references";

    public static final String APPLICANTS_HISTORY = "applicants-history";

    public static final String CHILD_DESIRED = "child-desired";

    public static final String RFA_1A_APPLICANTS_DECLARATION = "applicants-declaration";

    public static class PathParams {

      public static final String FACILITY_ID = "facilityId";

      public static final String CHILD_ID = "childId";

      public static final String COMPLAINT_ID = "complaintId";

      public static final String INSPECTION_ID = "inspectionId";

      public static final String RFA_1A_APPLICATION_ID = "applicationId";

      public static final String RFA_1A_APPLICANT_ID = "applicantId";

      public static final String RFA_1A_MINOR_CHILD_ID = "minorChildId";

      public static final String RFA_1A_OTHER_ADULT_ID = "otherAdultId";

      public static final String RFA_1A_MINOR_CHILD = "minorChild";

      public static final String RFA_1A_ADOPTION_HISTORY_API_PARAM = "adoptionHistory";

      public static final String RFA_1A_OTHER_ADULT = "otherAdult";

      public static final String RFA_1B_FORM = "rfa1bForm";

      public static final String RFA_1C_FORM = "rfa1cForm";

      public static final String RFA_1B_FORM_ID = "rfa1bFormId";

      public static final String RFA_1C_FORM_ID = "rfa1cFormId";

      public static final String RFA_1A_APPLICANT = "applicant";

      private PathParams() {
      }
    }

    private API() {
    }
  }

  public enum DictionaryType {
    AGE_GROUP_TYPE(AgeGroupType.class),
    LANGUAGE_TYPE(LanguageType.class),
    GENDER_TYPE(GenderType.class),
    NAME_TYPE(NameType.class),
    EDUCATION_LEVEL_TYPE(EducationLevelType.class),
    ETHNICITY_TYPE(EthnicityType.class),
    RACE_TYPE(RaceType.class),
    INCOME_TYPE(IncomeType.class),
    PHONE_NUMBER_TYPE(PhoneNumberType.class),
    ADDRESS_TYPE(AddressType.class),
    SIBLING_GROUP_TYPE(SiblingGroupType.class),
    STATE_TYPE(StateType.class),
    RESIDENCE_OWNERSHIP_TYPE(ResidenceOwnershipType.class),
    APPLICANT_RELATIONSHIP_TYPE(ApplicantRelationshipType.class),
    LICENSE_TYPE(LicenseType.class),
    MARRIAGE_TERMINATION_REASON(MarriageTerminationReason.class);

    public static final String AGE_GROUP_TYPE_PATH = "age-groups";
    public static final String LANGUAGE_TYPE_PATH = "languages";
    public static final String GENDER_TYPE_PATH = "genders";
    public static final String NAME_TYPE_PATH = "name-types";
    public static final String EDUCATION_LEVEL_TYPE_PATH = "education-level-types";
    public static final String ETHNICITY_TYPE_PATH = "ethnicity-types";
    public static final String RACE_TYPE_PATH = "race-types";
    public static final String INCOME_TYPE_PATH = "income-types";
    public static final String PHONE_NUMBER_TYPE_PATH = "phone-number-types";
    public static final String ADDRESS_TYPE_PATH = "address-types";
    public static final String SIBLING_GROUP_TYPE_PATH = "sibling-groups";
    public static final String STATE_TYPE_PATH = "states";
    public static final String APPLICATION_STATUS_TYPE_PATH = "application-statuses";
    public static final String RESIDENCE_OWNERSHIP_TYPE_PATH = "residence-ownership-types";
    public static final String APPLICANT_RELATIONSHIP_TYPE_PATH = "applicant-relationship-types";
    public static final String RELATIONSHIP_EVENT_TYPE_PATH = "relationship-event-types";
    public static final String LICENSE_TYPE_PATH = "license-types";
    public static final String MARRIAGE_TERMINATION_REASON_PATH = "marriage-termination-reasons";

    private Class<? extends BaseDictionary> dictionaryClass;

    DictionaryType(Class<? extends BaseDictionary> dictionaryClass) {
      this.dictionaryClass = dictionaryClass;
    }

    public Class<? extends BaseDictionary> getDictionaryClass() {
      return dictionaryClass;
    }

  }

  public static class AddressTypes {

    public static final String RESIDENTIAL = "residential";

    public static final String MAIL = "mail";

    private AddressTypes() {
    }
  }

  public static class PhoneTypes {

    public static final String PRIMARY = "primary";

    public static final String ALTERNATE = "alternate";

    private PhoneTypes() {
    }
  }

  public static class VisitTypes {

    public static final String ANNUAL_10_MONTH = "Annual 10 month";

    public static final String ANNUAL_22_MONTH = "Annual 22 month";

    public static final String POST_LICENSING = "Post Licensing";

    public static final String RENEWAL = "Renewal";

    public static final String MIDDLE_YEAR = "Middle Year";

    private VisitTypes() {
    }
  }

  public static class UnitOfWork {

    public static final String FAS = "fas";

    public static final String LIS = "lis";

    public static final String CMS = "cwscms";

    public static final String CALSNS = "calsns";

    private UnitOfWork() {
    }
  }

  private Constants() {
  }
}
