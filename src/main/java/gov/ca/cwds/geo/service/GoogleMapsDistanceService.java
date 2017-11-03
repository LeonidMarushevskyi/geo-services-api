package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.Unit;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.DistanceDTO;
import java.io.IOException;
import org.apache.commons.lang3.Validate;

/**
 * Calculate distance between two addresses using Google Maps Services integration
 *
 * @author CWDS TPT-3 Team
 */
public class GoogleMapsDistanceService {

  private static final String MSG_ERR_ADDRESS_CANNOT_BE_NULL = "Address cannot be null";

  private final GeoApiContext context;

  @Inject
  public GoogleMapsDistanceService(@Named("google.maps.api.key") String googleMapsApiKey) {
    this.context = new GeoApiContext.Builder()
        .apiKey(googleMapsApiKey)
        .build();
  }

  public DistanceDTO calculateDistance(final Address firstAddress, final Address secondAddress)
      throws InterruptedException, ApiException, IOException {
    Validate.notNull(firstAddress, MSG_ERR_ADDRESS_CANNOT_BE_NULL);
    Validate.notNull(secondAddress, MSG_ERR_ADDRESS_CANNOT_BE_NULL);
    final String[] firstAddresses = { firstAddress.toString() };
    final String[] secondAddresses = { secondAddress.toString() };
    final DistanceMatrix distanceMatrix = DistanceMatrixApi
        .getDistanceMatrix(context, firstAddresses, secondAddresses)
        .units(Unit.IMPERIAL)
        .await();
    final Distance distance = distanceMatrix.rows[0].elements[0].distance;
    return toDistanceDTO(distance);
  }

  private DistanceDTO toDistanceDTO(final Distance distance) {
    final DistanceDTO result = new DistanceDTO();
    result.setMeters(distance.inMeters);
    result.setHumanReadableInMiles(distance.humanReadable);
    return result;
  }

}
