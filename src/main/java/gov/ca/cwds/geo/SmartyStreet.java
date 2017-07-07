package gov.ca.cwds.geo;

import com.google.inject.Inject;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.us_street.Lookup;
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
  String streetAddress;
  String cityName;
  String stateName;
  Integer zip;
  Integer zipExtension;
  boolean delPoint;
  Double latitude;
  Double longitude;
  private SmartyStreetsDAO smartyStreetsDAO;

  /** */
  @Inject
  public SmartyStreet() {
    // default constructor
  }

  /** @param smartyStreetsDAO to set the smartyStreetsDAO */
  @Inject
  public SmartyStreet(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  /** @param smartyStreetsDAO the smartyStreetsDAO to set the smartyStreetsDAO */
  @Inject
  public void setSmartyStreetsDAO(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  /**
   * @param street incoming street address
   * @param city incoming city name
   * @param state incoming state
   * @param zipCode incoming zip code
   * @return returns a validated address back
   */
  public ValidatedAddressDTO[] usStreetSingleAddress(
      String street, String city, String state, Integer zipCode) {

    ArrayList<Candidate> results =
        (ArrayList<Candidate>) getSmartyStreetsCandidates(street, city, state, zipCode);

    ArrayList<ValidatedAddressDTO> returnValidatedAddressDTOS = new ArrayList<>();

    if (results.isEmpty()) {
      delPoint = false;
      longitude = null;
      latitude = null;
      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              streetAddress, cityName, stateName, zip, zipExtension, longitude, latitude, delPoint);
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
      zip = Integer.parseInt(candidate.getComponents().getZipCode());
      zipExtension = Integer.parseInt(candidate.getComponents().getPlus4Code());

      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              streetAddress, cityName, stateName, zip, zipExtension, longitude, latitude, delPoint);
      returnValidatedAddressDTOS.add(address);
    }
    return returnValidatedAddressDTOS.toArray(new ValidatedAddressDTO[returnValidatedAddressDTOS.size()]);
  }

  /**
   * @param street incoming street address
   * @param city incoming city name
   * @param state incoming state
   * @param zipCode incoming zip code
   * @return returns a address back
   */
  public List<Candidate> getSmartyStreetsCandidates(
      String street, String city, String state, Integer zipCode) {

    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());

    Client client = new ClientBuilder(credentials).buildUsStreetApiClient();

    Lookup lookup = createSmartyStreetsLookup(street, city, state, zipCode);

    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("SmartyStreet error, Unable to validate the address", e);
      throw new ApiException("ERROR calling SmartyStreet - ", e);
    } catch (IOException e) {
      LOGGER.error("SmartyStreet IO error, Unable to validate the address", e);
      throw new ApiException("ERROR calling SmartyStreet - ", e);
    }

    return lookup.getResult();
  }

  /**
   * @param street incoming street address
   * @param city incoming city name
   * @param state incoming state
   * @param zipCode incoming zip code
   * @return returns lookup
   */
  public Lookup createSmartyStreetsLookup(
      String street, String city, String state, Integer zipCode) {
    Lookup lookup = new Lookup();
    lookup.setStreet(street);
    lookup.setCity(city);
    lookup.setState(state);
    if (zipCode > 0) {
      lookup.setZipCode(Integer.toString(zipCode));
    } else {
      lookup.setZipCode("");
    }
    lookup.setMaxCandidates(smartyStreetsDAO.getMaxCandidates());
    return lookup;
  }
}
