package gov.ca.cwds.geo.service;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import org.apache.commons.lang3.Validate;

/**
 * Calculate distance between two addresses using SimpleLatLng library
 *
 * @author CWDS TPT-3 Team
 */
public class DistanceService {

  private static final String MSG_ERR_LONGITUDE_CANNOT_BE_NULL = "Longitude cannot be null";
  private static final String MSG_ERR_LATITUDE_CANNOT_BE_NULL = "Latitude cannot be null";

  public double calculateDistance(final ValidatedAddressDTO firstAddress,
                                  final ValidatedAddressDTO secondAddress) {
    Validate.notNull(firstAddress.getLongitude(), MSG_ERR_LONGITUDE_CANNOT_BE_NULL);
    Validate.notNull(firstAddress.getLattitude(), MSG_ERR_LATITUDE_CANNOT_BE_NULL);
    Validate.notNull(secondAddress.getLongitude(), MSG_ERR_LONGITUDE_CANNOT_BE_NULL);
    Validate.notNull(secondAddress.getLattitude(), MSG_ERR_LATITUDE_CANNOT_BE_NULL);
    final LatLng locationFrom = new LatLng(firstAddress.getLattitude(), firstAddress.getLongitude());
    final LatLng locationTo = new LatLng(secondAddress.getLattitude(), secondAddress.getLongitude());
    return LatLngTool.distance(locationFrom, locationTo, LengthUnit.MILE);
  }

}
