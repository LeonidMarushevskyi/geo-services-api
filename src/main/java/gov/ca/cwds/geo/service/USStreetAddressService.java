package gov.ca.cwds.geo.service;

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
public class USStreetAddressService {

  private static final Logger LOGGER = LoggerFactory.getLogger(USStreetAddressService.class);
  private static final String ERROR_CALLING_SMARTY_STREET = "ERROR calling USStreetAddressService - ";
  private String streetAddress;
  private String cityName;
  private String stateName;
  private String stateAbbreviation;
  private String zip;
  private String zipExtension;
  private SmartyStreetsDAO smartyStreetsDAO;

  @Inject
  public USStreetAddressService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  @Inject
  public void setSmartyStreetsDAO(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
  }

  public ValidatedAddressDTO[] validateSingleUSAddress(
      String street, String city, String state, String zipCode) {

    boolean delPoint;

    ArrayList<Candidate> results =
        (ArrayList<Candidate>) getSmartyStreetsCandidates(street, city, state, zipCode);

    ArrayList<ValidatedAddressDTO> returnValidatedAddressDTOS = new ArrayList<>();

    if (results.isEmpty()) {
      ValidatedAddressDTO address =
          new ValidatedAddressDTO(
              streetAddress, cityName, stateName, stateAbbreviation, zip, zipExtension, null, null, false);
      returnValidatedAddressDTOS.add(address);
      return returnValidatedAddressDTOS.toArray(new ValidatedAddressDTO[0]);
    }

    for (Candidate candidate : results) {

      if (("Y").equals(candidate.getAnalysis().getDpvMatchCode())
          || ("S").equals(candidate.getAnalysis().getDpvMatchCode())
          || ("D").equals(candidate.getAnalysis().getDpvMatchCode())) {
        delPoint = true;
      } else {
        delPoint = false;
      }
      Double longitude = candidate.getMetadata().getLongitude();
      Double latitude = candidate.getMetadata().getLatitude();
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



  public List<Candidate> getSmartyStreetsCandidates(
      String street, String city, String state, String zipCode) {

    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    Client client = new ClientBuilder(credentials).buildUsStreetApiClient();

    Lookup lookup = createSmartyStreetsLookup(street, city, state, zipCode);

    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("USStreetAddressService error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("USStreetAddressService IO error, Unable to validate the address", e);
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
