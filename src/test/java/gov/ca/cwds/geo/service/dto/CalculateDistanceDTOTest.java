package gov.ca.cwds.geo.service.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import gov.ca.cwds.geo.persistence.model.Address;

import org.junit.Test;



public class CalculateDistanceDTOTest {

  @Test
  public void settersAndGetters() {
    CalculateDistanceDTO target = new CalculateDistanceDTO();
    Address firstAddress = new Address("106 Big Valley Rd", "Folsom", "CA", "95630", null);
    Address secondAddress = new Address("10 Big Valley Rd", "Folsom", "CA", "95630", null);
    target.setFirstAddress(firstAddress);
    target.setSecondAddress(secondAddress);
    Address expectedFirstAddress = new Address("106 Big Valley Rd", "Folsom", "CA", "95630", null);
    Address expectedSecondAddress = new Address("10 Big Valley Rd", "Folsom", "CA", "95630", null);

    assertThat(firstAddress, is(expectedFirstAddress));
    assertThat(secondAddress, is(expectedSecondAddress));
  }

}
