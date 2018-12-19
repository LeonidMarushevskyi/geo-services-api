package gov.ca.cwds.geo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConstantsTest {

  @Test
  public void systemInformation() {
    assertEquals("system-information", Constants.API.SYSTEM_INFORMATION);
  }

  @Test
  public void address() {
    assertEquals("address", Constants.ADDRESS);
  }

  @Test
  public void validate() {
    assertEquals("validate", Constants.VALIDATE_SINGLE);
  }

  @Test
  public void lookup() {
    assertEquals("lookup", Constants.LOOKUP_ZIP_CODE);
  }

  @Test
  public void zipCode() {
    assertEquals("zipCode", Constants.ZIP_CODE);
  }

  @Test
  public void suggest() {
    assertEquals("suggest", Constants.SUGGEST);
  }

  @Test
  public void distance() {
    assertEquals("distance", Constants.DISTANCE);
  }

  @Test
  public void prefix() {
    assertEquals("prefix", Constants.PREFIX);
  }

}
