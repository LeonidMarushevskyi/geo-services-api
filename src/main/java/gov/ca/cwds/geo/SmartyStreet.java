package gov.ca.cwds.geo;

import com.google.inject.Inject;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.us_street.Lookup;
import com.smartystreets.api.us_zipcode.City;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.api.ApiException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validates the address by calling the SmartyStreets API
 *
 * @author CWDS API Team
 */
public class SmartyStreet {

  private static final Logger LOGGER = LoggerFactory.getLogger(SmartyStreet.class);
  public static final String ERROR_CALLING_SMARTY_STREET = "ERROR calling SmartyStreet - ";
  String streetAddress;
  String cityName;
  String stateName;
  String stateAbbreviation;
  String zip;
  String zipExtension;
  boolean delPoint;
  Double latitude;
  Double longitude;
  private SmartyStreetsDAO smartyStreetsDAO;

  @Inject
  public SmartyStreet() {
    // Nothing to do
  }

  @Inject
  public SmartyStreet(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  @Inject
  public void setSmartyStreetsDAO(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  public ValidatedAddressDTO[] validateSingleUSAddress(
      String street, String city, String state, String zipCode) {

    ArrayList<Candidate> results =
        (ArrayList<Candidate>) getSmartyStreetsCandidates(street, city, state, zipCode);

    ArrayList<ValidatedAddressDTO> returnValidatedAddressDTOS = new ArrayList<>();

    if (results.isEmpty()) {
      delPoint = false;
      longitude = null;
      latitude = null;
      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              streetAddress, cityName, stateName, stateAbbreviation, zip, zipExtension, longitude, latitude, delPoint);
      returnValidatedAddressDTOS.add(address);
      return returnValidatedAddressDTOS.toArray(new ValidatedAddressDTO[0]);
    }

    for (int i = 0; i < results.size(); i++) {

      Candidate candidate = results.get(i);

      if (("Y").equals(candidate.getAnalysis().getDpvMatchCode())
          || ("S").equals(candidate.getAnalysis().getDpvMatchCode())
          || ("D").equals(candidate.getAnalysis().getDpvMatchCode())) {
        delPoint = true;
      } else {
        delPoint = false;
      }
      longitude = candidate.getMetadata().getLongitude();
      latitude = candidate.getMetadata().getLatitude();
      streetAddress = candidate.getDeliveryLine1();
      cityName = candidate.getComponents().getCityName();
      stateName = candidate.getComponents().getState();
      zip = candidate.getComponents().getZipCode();
      zipExtension = candidate.getComponents().getPlus4Code();

      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              streetAddress, cityName, stateName, stateAbbreviation, zip, zipExtension, longitude, latitude, delPoint);
      returnValidatedAddressDTOS.add(address);
    }
    return returnValidatedAddressDTOS.toArray(
        new ValidatedAddressDTO[returnValidatedAddressDTOS.size()]);
  }

  public ValidatedAddressDTO[] lookupSingleUSZip(String zipCode) {
    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    com.smartystreets.api.us_zipcode.Client client =
        new ClientBuilder(credentials).buildUsZipCodeApiClient();
    com.smartystreets.api.us_zipcode.Lookup lookup = new com.smartystreets.api.us_zipcode.Lookup();
    lookup.setZipCode(zipCode);
    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("SmartyStreet error, Unable to lookup zip code", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("SmartyStreet IO error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    }
    com.smartystreets.api.us_zipcode.Result result = lookup.getResult();
    City[] cities = result.getCities();

    ArrayList<ValidatedAddressDTO> validAddresses = new ArrayList<>();
    for (City city : cities) {
      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              null,
              city.getCity(),
              city.getState(),
              city.getStateAbbreviation(),
              zipCode,
              null,
              null,
              null,
              null);
      validAddresses.add(address);
    }
    return validAddresses.toArray(new ValidatedAddressDTO[validAddresses.size()]);
  }

  private List<Candidate> getSmartyStreetsCandidates(
      String street, String city, String state, String zipCode) {

    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    Client client = new ClientBuilder(credentials).buildUsStreetApiClient();

    Lookup lookup = createSmartyStreetsLookup(street, city, state, zipCode);

    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("SmartyStreet error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("SmartyStreet IO error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    }

    return lookup.getResult();
  }

  private Lookup createSmartyStreetsLookup(
      String street, String city, String state, String zipCode) {
    Lookup lookup = new Lookup();
    lookup.setStreet(street);
    lookup.setCity(city);
    lookup.setState(state);
    if (zipCode != null) {
      lookup.setZipCode(zipCode);
    } else {
      lookup.setZipCode("");
    }
    lookup.setMaxCandidates(smartyStreetsDAO.getMaxCandidates());
    return lookup;
  }
}
