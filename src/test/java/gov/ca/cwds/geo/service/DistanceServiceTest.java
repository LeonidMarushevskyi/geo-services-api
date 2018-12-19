package gov.ca.cwds.geo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;

import org.junit.Test;

/**
 * 
 * @author CWDS API Team
 */
public class DistanceServiceTest {

  @Test
  public void calculateDistance() {
    DistanceService target = new DistanceService();

    ValidatedAddressDTO address1 =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO address2 =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);
    Double actual = target.calculateDistance(address1, address2);

    assertThat(actual, is(equalTo(new Double(0))));
  }

}
