package gov.ca.cwds.geo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;

import org.junit.Test;

import com.smartystreets.api.us_autocomplete.Client;
import com.smartystreets.api.us_autocomplete.Suggestion;

/**
 * 
 * @author CWDS API Team
 */
public class USAutocompleteServiceTest {

  @Test
  public void suggestAddress() throws Exception {
    SmartyStreetsDAO smartyStreetsDao = mock(SmartyStreetsDAO.class);
    Client autocompleteClient = mock(Client.class);
    USAutocompleteService target = new USAutocompleteService(smartyStreetsDao, autocompleteClient);

    Suggestion suggestion = mock(Suggestion.class);
    when(suggestion.getCity()).thenReturn("Folsom");
    when(suggestion.getState()).thenReturn("CA");
    when(suggestion.getStreetLine()).thenReturn("1489 Black Bear St.");

    Suggestion[] suggestions = new Suggestion[1];
    suggestions[0] = suggestion;

    when(autocompleteClient.send(any())).thenReturn(suggestions);

    Address[] expected = new Address[1];
    expected[0] = new Address("1489 Black Bear St.", "Folsom", "CA", null, null);

    Address[] actual = target.suggestAddress("1489 Black Bear St.", "CA", 10);

    assertThat(actual, is(equalTo(expected)));
  }

}
