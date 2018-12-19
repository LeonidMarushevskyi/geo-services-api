package gov.ca.cwds.geo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.DistanceDTO;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author CWDS API Team
 */
@SuppressWarnings("javadoc")
public class AddressServiceTest {

  private SmartyStreetsDAO smartyStreetsDao;
  private DistanceService distanceService;
  private USStreetAddressService usStreetAddressService;
  private USZipCodeService usZipCodeService;
  private USAutocompleteService usAutocompleteService;
  private AddressService target;

  @Before
  public void setup() throws Exception {

    smartyStreetsDao = mock(SmartyStreetsDAO.class);
    distanceService = mock(DistanceService.class);
    usStreetAddressService = mock(USStreetAddressService.class);
    usZipCodeService = mock(USZipCodeService.class);
    usAutocompleteService = mock(USAutocompleteService.class);

    target =
        new AddressService(smartyStreetsDao, distanceService, usStreetAddressService,
            usZipCodeService, usAutocompleteService);

  }

  @Test
  public void fetchValidatedAddresses() throws Exception {

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);

    Address address = new Address("1489 Black Bear St.", "Folsom", "CA", "95630", null);

    when(
        usStreetAddressService.validateSingleUSAddress("1489 Black Bear St.", "Folsom", "CA",
            "95630")).thenReturn(expected);
    ValidatedAddressDTO[] actual = target.fetchValidatedAddresses(address);

    assertThat(actual, is(equalTo(expected)));
  }

  @Test
  public void calculateDistance() throws Exception {

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);

    Address address = new Address("1489 Black Bear St.", "Folsom", "CA", "95630", null);

    when(
        usStreetAddressService.validateSingleUSAddress("1489 Black Bear St.", "Folsom", "CA",
            "95630")).thenReturn(expected);

    DistanceDTO actual = target.calculateDistance(address, address);

    assertThat(actual.getMiles(), is(equalTo((double) 0)));
  }

  @Test
  public void lookupSingleUSZip() throws Exception {

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);

    when(usZipCodeService.lookupSingleUSZip("95630")).thenReturn(expected);

    ValidatedAddressDTO[] actual = target.lookupSingleUSZip("95630");

    assertThat(actual, is(equalTo(expected)));
  }

  @Test
  public void suggestAddress() throws Exception {

    smartyStreetsDao = new SmartyStreetsDAO("client", "token", 10);
    AddressService target =
        new AddressService(smartyStreetsDao, distanceService, usStreetAddressService,
            usZipCodeService, usAutocompleteService);

    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);
    Address[] address = new Address[1];
    address[0] = new Address("1489 Black Bear St.", "Folsom", "CA", "95630", null);

    when(
        usStreetAddressService.validateSingleUSAddress("1489 Black Bear St.", "Folsom", "CA",
            "95630")).thenReturn(expected);
    when(usStreetAddressService.validateBatchAddress(address)).thenReturn(expected);
    when(usAutocompleteService.suggestAddress("1489 Black Bear St.,Folsom", "CA", 10)).thenReturn(
        address);

    ValidatedAddressDTO[] actual = target.suggestAddress("1489 Black Bear St.,Folsom");

    assertThat(actual, is(equalTo(expected)));
  }

}
