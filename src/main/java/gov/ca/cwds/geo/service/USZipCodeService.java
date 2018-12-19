package gov.ca.cwds.geo.service;

import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.api.ApiException;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.jcabi.aspects.Loggable;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_zipcode.City;
import com.smartystreets.api.us_zipcode.Client;
import com.smartystreets.api.us_zipcode.Lookup;

/**
 * US ZIP Code features by calling the SmartyStreets API
 *
 * @author CWDS TPT2
 */
public class USZipCodeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(USZipCodeService.class);
  private static final String ERROR_CALLING_SMARTY_STREET =
      "ERROR calling USStreetAddressService - ";
  private SmartyStreetsDAO smartyStreetsDAO;
  private Client client;

  @Inject
  public USZipCodeService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    client = new ClientBuilder(credentials).buildUsZipCodeApiClient();

  }

  @Loggable(Loggable.DEBUG)
  ValidatedAddressDTO[] lookupSingleUSZip(String zipCode) {
    com.smartystreets.api.us_zipcode.Lookup lookup = new Lookup();
    lookup.setZipCode(zipCode);
    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("USStreetAddressService error, Unable to lookup zip code", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("USStreetAddressService IO error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    }
    com.smartystreets.api.us_zipcode.Result result = lookup.getResult();
    City[] cities = result.getCities();

    ArrayList<ValidatedAddressDTO> validAddresses = new ArrayList<>();
    for (City city : cities) {
      ValidatedAddressDTO address =
          new ValidatedAddressDTO(null, city.getCity(), city.getState(),
              city.getStateAbbreviation(), zipCode, null, null, null, null);
      validAddresses.add(address);
    }
    return validAddresses.toArray(new ValidatedAddressDTO[validAddresses.size()]);
  }
}
