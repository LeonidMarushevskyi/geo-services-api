package gov.ca.cwds.cals;

import static gov.ca.cwds.cals.Constants.UnitOfWork.CMS;
import static gov.ca.cwds.cals.Constants.UnitOfWork.LIS;

import gov.ca.cwds.cals.web.rest.parameter.FacilityParameterObject;

/**
 * @author CALS API Team
 */
public final class Utils {

  private Utils() {
  }

  public static FacilityParameterObject createFacilityParameterObject(String facilityNumber) {
    FacilityParameterObject parameterObject;
    try {
      Integer licenseNumber = Integer.valueOf(facilityNumber);
      parameterObject = new FacilityParameterObject(licenseNumber, LIS);
    } catch (NumberFormatException e) {
      parameterObject = new FacilityParameterObject(facilityNumber, CMS);
    }
    return parameterObject;
  }

  public static FacilityParameterObject createExpandedFacilityParameterObject(String facilityNumber) {
    FacilityParameterObject parameterObject = createFacilityParameterObject(facilityNumber);
    parameterObject.setExpanded(Boolean.TRUE);
    return parameterObject;
  }
}
