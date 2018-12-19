package gov.ca.cwds.geo.service.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class ValidatedAddressDTOTest {

  @Test
  public void equals() throws Exception {
    ValidatedAddressDTO address1 =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);

    ValidatedAddressDTO address2 =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", "95630", "1234", "2145",
            -121.13233, 38.64028, true);

    assertEquals(address1, address2);
  }

  @Test
  public void equalsFailsWhenNotEqual() throws Exception {
    ValidatedAddressDTO address =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressDifferentCity =
        new ValidatedAddressDTO("1489 Black Bear St.", "Fols", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressDifferentStreet =
        new ValidatedAddressDTO("1488 Black Bear St.", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressDifferentZip =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", null, "9563", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressDifferentState =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "AZ", null, "95630", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressDifferentZipExt =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", null, "95630", "214",
            -121.13233, 38.64028, true);
    assertNotEquals(address, addressDifferentCity);
    assertNotEquals(address, addressDifferentStreet);
    assertNotEquals(address, addressDifferentZip);
    assertNotEquals(address, addressDifferentState);
    assertNotEquals(address, addressDifferentZipExt);
  }

  @Test
  public void equalsFailsWhenNotEqualForAddressWithNullFields() throws Exception {
    ValidatedAddressDTO address =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);
    ValidatedAddressDTO addressWithAllNullFields =
        new ValidatedAddressDTO(null, null, null, null, null, null, null, null, null);

    assertNotEquals(address, addressWithAllNullFields);
    assertNotEquals(addressWithAllNullFields, address);
  }


  @Test
  public void equalsFailsWhenComparedToString() throws Exception {
    ValidatedAddressDTO address =
        new ValidatedAddressDTO("1489 Black Bear St.", "Folsom", "CA", null, "95630", "2145",
            -121.13233, 38.64028, true);
    String addressAsString =
        "1489 Black Bear St.,Folsom, CA, null, 95630, 2145,-121.13233, 38.64028, true";

    assertNotEquals(address, addressAsString);
  }

}
