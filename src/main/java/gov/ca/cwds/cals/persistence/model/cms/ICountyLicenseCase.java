package gov.ca.cwds.cals.persistence.model.cms;

import java.util.List;

/**
 * @author CWDS CALS API Team
 */
public interface ICountyLicenseCase<LV extends BaseLicensingVisit, SP extends BaseStaffPerson> {
  List<LV> getLicensingVisits();
  SP getStaffPerson();
}
