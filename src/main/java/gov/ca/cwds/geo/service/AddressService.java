package gov.ca.cwds.geo.service;

import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.DistanceDTO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.services.ServiceException;

import com.google.inject.Inject;
import com.jcabi.aspects.Loggable;

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
  public AddressService(SmartyStreetsDAO smartyStreetsDAO, DistanceService distanceService) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    this.distanceService = distanceService;
    this.usStreetAddressService = new USStreetAddressService(smartyStreetsDAO);
    this.usZipCodeService = new USZipCodeService(smartyStreetsDAO);
    this.usAutocompleteService = new USAutocompleteService(smartyStreetsDAO);
  }

  public AddressService(SmartyStreetsDAO smartyStreetsDAO, DistanceService distanceService,
      USStreetAddressService usStreetAddressService, USZipCodeService usZipCodeService,
      USAutocompleteService usAutocompleteService) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    this.distanceService = distanceService;
    this.usStreetAddressService = usStreetAddressService;
    this.usZipCodeService = usZipCodeService;
    this.usAutocompleteService = usAutocompleteService;
  }

  /**
   * Returns all valid addresses, up to the default number set in {@link SmartyStreetsDAO}
   *
   * @param address The address to validate
   * @return array of {@link ValidatedAddressDTO}
   * @throws ServiceException due to SmartyStreets error, I/O error, etc.
   */
  @Loggable(Loggable.DEBUG)
  public ValidatedAddressDTO[] fetchValidatedAddresses(Address address) {
    return usStreetAddressService.validateSingleUSAddress(address.getStreetAddress(),
        address.getCity(), address.getState(), address.getZip());
  }

  @Loggable(Loggable.DEBUG)
  public ValidatedAddressDTO[] lookupSingleUSZip(String zip) {
    try {
      return usZipCodeService.lookupSingleUSZip(zip);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling lookupSingleUSZip in usStreetAddressService", e);
    }
  }

  @Loggable(Loggable.DEBUG)
  public ValidatedAddressDTO[] suggestAddress(String prefix) {
    try {
      Address[] suggestions =
          usAutocompleteService.suggestAddress(prefix, "CA", smartyStreetsDAO.getMaxCandidates());
      return usStreetAddressService.validateBatchAddress(suggestions);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling suggestAddress in usStreetAddressService", e);
    }
  }

  @Loggable(Loggable.DEBUG)
  public DistanceDTO calculateDistance(final Address firstAddress, final Address secondAddress) {
    try {
      final ValidatedAddressDTO[] validatedFirstAddress = fetchValidatedAddresses(firstAddress);
      final ValidatedAddressDTO[] validatedSecondAddress = fetchValidatedAddresses(secondAddress);
      final Double distance =
          distanceService.calculateDistance(validatedFirstAddress[0], validatedSecondAddress[0]);
      return new DistanceDTO(distance);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling calculateDistance service", e);
    }
  }

}
