package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import com.jcabi.aspects.Cacheable;
import com.jcabi.aspects.Loggable;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_autocomplete.Client;
import com.smartystreets.api.us_autocomplete.GeolocateType;
import com.smartystreets.api.us_autocomplete.Lookup;
import com.smartystreets.api.us_autocomplete.Suggestion;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Autocomplete address by calling the SmartyStreets API
 *
 * @author CWDS TPT2
 */
public class USAutocompleteService {

  private SmartyStreetsDAO smartyStreetsDAO;
  private Client client;

  @Inject
  public USAutocompleteService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    StaticCredentials credentials =
        new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    this.client = new ClientBuilder(credentials).buildUsAutocompleteApiClient();

  }

  @Loggable(Loggable.DEBUG)
  Address[] suggestAddress(String prefix, String preferredState, int maxSuggestions)
      throws IOException, SmartyException {
    Lookup lookup = new Lookup(prefix);
    lookup.addPrefer(preferredState);
    lookup.setMaxSuggestions(maxSuggestions);
    lookup.setGeolocateType(GeolocateType.CITY);
    lookup.setPreferRatio(1);

    Suggestion[] suggestions = client.send(lookup);

    ArrayList<Address> addresses = new ArrayList<>();
    for (Suggestion suggestion : suggestions) {
      Address address =
          new Address(
              suggestion.getStreetLine(), suggestion.getCity(), suggestion.getState(), null, null);
      addresses.add(address);
    }
    return addresses.toArray(new Address[addresses.size()]);
  }
}
