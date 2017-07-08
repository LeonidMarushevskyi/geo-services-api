package gov.ca.cwds.geo.web.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import com.smartystreets.api.us_street.Analysis;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Components;
import com.smartystreets.api.us_street.Metadata;
import gov.ca.cwds.geo.SmartyStreet;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;

/** @author CWDS API Team */
@SuppressWarnings("javadoc")
public class SmartyStreetTest {

  private static final SmartyStreet spySmartyStreet = spy(new SmartyStreet());

  @Test
  public void successfulWithEmptyCandidate() throws Exception {
    ArrayList<Candidate> empty = new ArrayList<Candidate>();
    String a = "a";
    String b = "b";
    String c = "c";
    String z = "";
    Mockito.doReturn(empty).when(spySmartyStreet).getSmartyStreetsCandidates(a, b, c, z);
    ValidatedAddressDTO[] actual = spySmartyStreet.validateSingleUSAddress(a, b, c, z);
    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] = new ValidatedAddressDTO(null, null, null, null, null, null, null, null, false);
    assertThat(actual[0], is(equalTo(expected[0])));
  }

  /*
   * Successful Tests
   */
  @Test
  public void successfulWithDpvY() throws Exception {
    ArrayList<Candidate> dpvY = new ArrayList<Candidate>();
    Candidate mockcandidate1 = mock(Candidate.class);
    Analysis mockanalysis1 = mock(Analysis.class);
    Components mockancomponents1 = mock(Components.class);
    Metadata mockanmetadata1 = mock(Metadata.class);
    Mockito.when(mockcandidate1.getDeliveryLine1()).thenReturn("106 Big Valley Rd");
    Mockito.when(mockcandidate1.getComponents()).thenReturn(mockancomponents1);
    Mockito.when(mockancomponents1.getCityName()).thenReturn("Folsom");
    Mockito.when(mockancomponents1.getState()).thenReturn("California");
    Mockito.when(mockancomponents1.getZipCode()).thenReturn("95630");
    Mockito.when(mockancomponents1.getPlus4Code()).thenReturn("2145");
    Mockito.when(mockcandidate1.getMetadata()).thenReturn(mockanmetadata1);
    Mockito.when(mockanmetadata1.getLongitude()).thenReturn(-121.13233);
    Mockito.when(mockanmetadata1.getLatitude()).thenReturn(38.64028);
    Mockito.when(mockcandidate1.getAnalysis()).thenReturn(mockanalysis1);
    Mockito.when(mockanalysis1.getDpvMatchCode()).thenReturn("Y");
    dpvY.add(mockcandidate1);
    String a = "106 Big Valley Rd";
    String b = "folsom";
    String c = "ca";
    String z = "95630";
    Mockito.doReturn(dpvY).when(spySmartyStreet).getSmartyStreetsCandidates(a, b, c, z);
    ValidatedAddressDTO[] actual = spySmartyStreet.validateSingleUSAddress(a, b, c, z);
    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[1];
    expected[0] =
        new ValidatedAddressDTO(
            "106 Big Valley Rd", "Folsom", "California", null, "95630", "2145", -121.13233, 38.64028, true);
    assertThat(actual[0], is(equalTo(expected[0])));
  }

  @Test
  public void successfulWithMultipleCandidates() throws Exception {
    ArrayList<Candidate> multiCandidates = new ArrayList<Candidate>();
    Candidate mockcandidate1 = mock(Candidate.class);
    Analysis mockanalysis1 = mock(Analysis.class);
    Components mockancomponents1 = mock(Components.class);
    Metadata mockanmetadata1 = mock(Metadata.class);
    Mockito.when(mockcandidate1.getDeliveryLine1()).thenReturn("106 Big Valley Rd");
    Mockito.when(mockcandidate1.getComponents()).thenReturn(mockancomponents1);
    Mockito.when(mockancomponents1.getCityName()).thenReturn("Folsom");
    Mockito.when(mockancomponents1.getState()).thenReturn("CA");
    Mockito.when(mockancomponents1.getZipCode()).thenReturn("95630");
    Mockito.when(mockancomponents1.getPlus4Code()).thenReturn("2145");
    Mockito.when(mockcandidate1.getMetadata()).thenReturn(mockanmetadata1);
    Mockito.when(mockanmetadata1.getLongitude()).thenReturn(-121.13233);
    Mockito.when(mockanmetadata1.getLatitude()).thenReturn(38.64028);
    Mockito.when(mockcandidate1.getAnalysis()).thenReturn(mockanalysis1);
    Mockito.when(mockanalysis1.getDpvMatchCode()).thenReturn("Y");
    multiCandidates.add(mockcandidate1);

    Candidate mockcandidate2 = mock(Candidate.class);
    Analysis mockanalysis2 = mock(Analysis.class);
    Components mockancomponents2 = mock(Components.class);
    Metadata mockanmetadata2 = mock(Metadata.class);
    Mockito.when(mockcandidate2.getDeliveryLine1()).thenReturn("106 Big Valley Ct");
    Mockito.when(mockcandidate2.getComponents()).thenReturn(mockancomponents2);
    Mockito.when(mockancomponents2.getCityName()).thenReturn("Folsom");
    Mockito.when(mockancomponents2.getState()).thenReturn("CA");
    Mockito.when(mockancomponents2.getZipCode()).thenReturn("95630");
    Mockito.when(mockancomponents2.getPlus4Code()).thenReturn("2145");
    Mockito.when(mockcandidate2.getMetadata()).thenReturn(mockanmetadata2);
    Mockito.when(mockanmetadata2.getLongitude()).thenReturn(-121.13232);
    Mockito.when(mockanmetadata2.getLatitude()).thenReturn(38.68207);
    Mockito.when(mockcandidate2.getAnalysis()).thenReturn(mockanalysis2);
    Mockito.when(mockanalysis2.getDpvMatchCode()).thenReturn("S");
    multiCandidates.add(mockcandidate2);

    String a = "106 Big Valley";
    String b = "folsom";
    String c = "ca";
    String z = null;
    Mockito.doReturn(multiCandidates).when(spySmartyStreet).getSmartyStreetsCandidates(a, b, c, z);
    ValidatedAddressDTO[] actual = spySmartyStreet.validateSingleUSAddress(a, b, c, z);
    ValidatedAddressDTO[] expected = new ValidatedAddressDTO[2];
    expected[0] =
        new ValidatedAddressDTO(
            "106 Big Valley Rd", "Folsom", "CA", null, "95630", "2145", -121.13233, 38.64028, true);
    expected[1] =
        new ValidatedAddressDTO(
            "106 Big Valley Ct", "Folsom", "CA", null, "95630", "2145", -121.13232, 38.68207, true);
    assertThat(actual[0], is(equalTo(expected[0])));
    assertThat(actual[1], is(equalTo(expected[1])));
  }
}
