package gov.ca.cwds.geo.persistence.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Created by leonid.marushevskiy on 9/26/2017.
 */
public class AddressTest {

  @Test
  public void equals() throws Exception {
    Address address1 = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    Address address2 = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    assertEquals(address1, address2);
  }

  @Test
  public void equalsFailsWhenNotEqual() throws Exception {
    Address address = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    Address addressDifferentZip =
        new Address("1489 Black Bear St.", "Roseville", "CA", "95749", null);
    Address addressDifferentStreetAndCity =
        new Address("1488 Black Bear St.", "Rose", "AZ", "12345", null);
    Address addressDifferentCity =
        new Address("1489 Black Bear St.", "Rosevill", "CA", "95747", null);
    Address addressDifferentState =
        new Address("1489 Black Bear St.", "Roseville", "AZ", "95747", null);
    Address addressDifferentStreet =
        new Address("1488 Black Bear St.", "Roseville", "CA", "95747", null);
    assertNotEquals(address, addressDifferentZip);
    assertNotEquals(address, addressDifferentStreetAndCity);
    assertNotEquals(address, addressDifferentCity);
    assertNotEquals(address, addressDifferentState);
    assertNotEquals(address, addressDifferentStreet);
  }

  @Test
  public void equalsFailsWhenNotEqualForAddressWithNullFields() throws Exception {
    Address address = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    Address addressWithNullFields = new Address(null, null, null, null, null);
    assertNotEquals(address, addressWithNullFields);
    assertNotEquals(addressWithNullFields, address);
  }

  @Test
  public void equalsFailsWhenComparedToString() throws Exception {
    Address address = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    String addressAsString = "1489 Black Bear St., Roseville, CA, 95747";
    assertNotEquals(address, addressAsString);
  }

  @Test
  public void toStringConvertsCorrectly() throws Exception {
    Address address = new Address("1489 Black Bear St.", "Roseville", "CA", "95747", null);
    String addressAsString = "1489 Black Bear St., Roseville, CA, 95747";
    assertEquals(address.toString(), addressAsString);
  }

}
