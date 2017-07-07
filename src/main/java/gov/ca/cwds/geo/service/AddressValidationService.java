package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import gov.ca.cwds.geo.SmartyStreet;
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
public class AddressValidationService implements CrudsService {

  private SmartyStreetsDAO smartyStreetsDAO;

  @Inject
  AddressValidationService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  /**
   * Returns all valid addresses, up to the default number set in {@link SmartyStreetsDAO}
   *
   * @param address The address to validate
   * @return array of {@link ValidatedAddressDTO}
   * @throws ServiceException due to SmartyStreets error, I/O error, etc.
   */
  public ValidatedAddressDTO[] fetchValidatedAddresses(Address address) {
    ValidatedAddressDTO[] addresses = null;
    try {
      SmartyStreet smartyStreet = new SmartyStreet(smartyStreetsDAO);
      addresses =
          smartyStreet.usStreetSingleAddress(
              address.getStreetAddress(), address.getCity(), address.getState(), address.getZip());
    } catch (Exception e) {
      throw new ServiceException("ERROR calling usStreetSingleAddress in SmartyStreet", e);
    }
    return addresses;
  }

  // Not Implemented

  /**
   * {@inheritDoc}
   *
   * @see gov.ca.cwds.rest.services.CrudsService#create(gov.ca.cwds.rest.api.Request)
   */
  @Override
  public Response create(Request request) {
    assert request instanceof Address;
    throw new NotImplementedException("Create is not implemented");
  }

  /**
   * {@inheritDoc}
   *
   * @see gov.ca.cwds.rest.services.CrudsService#find(Serializable)
   */
  @Override
  public Response find(Serializable primaryKey) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Delete is not implemented");
  }

  /**
   * {@inheritDoc}
   *
   * @see gov.ca.cwds.rest.services.CrudsService#delete(Serializable)
   */
  @Override
  public Response delete(Serializable primaryKey) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Delete is not implemented");
  }

  /**
   * {@inheritDoc}
   *
   * @see gov.ca.cwds.rest.services.CrudsService#update(Serializable, gov.ca.cwds.rest.api.Request)
   */
  @Override
  public Response update(Serializable primaryKey, Request request) {
    assert primaryKey instanceof Long;
    throw new NotImplementedException("Update is not implemented");
  }
}
