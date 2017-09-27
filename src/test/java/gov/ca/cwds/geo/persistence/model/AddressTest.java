package gov.ca.cwds.geo.persistence.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by leonid.marushevskiy on 9/26/2017.
 */
public class AddressTest {

  @Test
  public void equals() throws Exception {
    Address address1 = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    Address address2 = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    Address address3 = new Address("1489 Black Bear St.", "Roseville", "CA", "95749", null);
    assertEquals(address1, address2);
    assertNotEquals(address1,address3);
  }

}