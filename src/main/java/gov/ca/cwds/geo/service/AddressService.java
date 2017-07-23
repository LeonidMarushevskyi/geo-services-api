package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.CrudsService;
import gov.ca.cwds.rest.services.ServiceException;
import java.io.Serializable;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Business layer object to work on {@link ValidatedAddressDTO}
 *
 * @author CWDS API Team
 */
public class AddressService implements CrudsService {

  private USStreetAddressService usStreetAddressService;
  private USZipCodeService usZipCodeService;
  private USAutocompleteService usAutocompleteService;
  private SmartyStreetsDAO smartyStreetsDAO;

  @Inject
  AddressService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
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
    ValidatedAddressDTO[] addresses;
    try {
      addresses =
          usStreetAddressService.validateSingleUSAddress(
              address.getStreetAddress(), address.getCity(), address.getState(), address.getZip());
    } catch (Exception e) {
      throw new ServiceException("ERROR calling validateSingleUSAddress in usStreetAddressService", e);
    }
    return addresses;
  }

  public ValidatedAddressDTO[] lookupSingleUSZip(String zip) {
    ValidatedAddressDTO[] addresses;
    try {
      addresses = usZipCodeService.lookupSingleUSZip(zip);
    } catch (Exception e) {
      throw new ServiceException("ERROR calling lookupSingleUSZip in usStreetAddressService", e);
    }
    return addresses;
  }

  public Address[] suggestAddress(String prefix) {
    Address[] addresses;
    try {
      addresses = usAutocompleteService.suggestAddress(prefix, "CA", smartyStreetsDAO.getMaxCandidates());
    } catch (Exception e) {
      throw new ServiceException("ERROR calling suggestAddress in usStreetAddressService", e);
    }
    return addresses;
  }


  @Override
  public Response create(Request request) {
    assert request instanceof Address;
    throw new NotImplementedException("Create is not implemented");
  }


  @Override
  public Response find(Serializable primaryKey) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Delete is not implemented");
  }

  @Override
  public Response delete(Serializable primaryKey) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Delete is not implemented");
  }

  @Override
  public Response update(Serializable primaryKey, Request request) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Update is not implemented");
  }
}
