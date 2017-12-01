package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.DistanceDTO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.services.ServiceException;

/**
 * Business layer object to work on {@link ValidatedAddressDTO}
 *
 * @author CWDS API Team
 */
public class AddressService {

  private USStreetAddressService usStreetAddressService;
  private USZipCodeService usZipCodeService;
  private USAutocompleteService usAutocompleteService;
  private SmartyStreetsDAO smartyStreetsDAO;
  private final DistanceService distanceService;

  @Inject
  AddressService(SmartyStreetsDAO smartyStreetsDAO, DistanceService distanceService) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    this.distanceService = distanceService;
    this.usStreetAddressService = new USStreetAddressService(smartyStreetsDAO);
    this.usZipCodeService = new USZipCodeService(smartyStreetsDAO);
    this.usAutocompleteService = new USAutocompleteService(smartyStreetsDAO);
  }

  /**
   * Returns all valid addresses, up to the default number set in {@link SmartyStreetsDAO}
   *
   * @param address The address to validate
   * @return array of {@link ValidatedAddressDTO}
   * @throws ServiceException due to SmartyStreets error, I/O error, etc.
   */
  public ValidatedAddressDTO[] fetchValidatedAddresses(Address address) {
    try {
      return usStreetAddressService.validateSingleUSAddress(
          address.getStreetAddress(), address.getCity(), address.getState(), address.getZip());
    } catch (Exception e) {
      throw new ServiceException("ERROR calling validateSingleUSAddress in usStreetAddressService", e);
    }
  }

  public ValidatedAddressDTO[] lookupSingleUSZip(String zip) {
    try {
      return usZipCodeService.lookupSingleUSZip(zip);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling lookupSingleUSZip in usStreetAddressService", e);
    }
  }

  public Address[] suggestAddress(String prefix) {
    try {
      return usAutocompleteService.suggestAddress(prefix, "CA", smartyStreetsDAO.getMaxCandidates());
    } catch (Exception e) {
      throw new ServiceException("ERROR calling suggestAddress in usStreetAddressService", e);
    }
  }

  public DistanceDTO calculateDistance(final Address firstAddress, final Address secondAddress) {
    try {
      final ValidatedAddressDTO[] validatedFirstAddress = fetchValidatedAddresses(firstAddress);
      final ValidatedAddressDTO[] validatedSecondAddress = fetchValidatedAddresses(secondAddress);
      final Double distance = distanceService.calculateDistance(
          validatedFirstAddress[0],
          validatedSecondAddress[0]
      );
      return new DistanceDTO(distance);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling calculateDistance service", e);
    }
  }

}
