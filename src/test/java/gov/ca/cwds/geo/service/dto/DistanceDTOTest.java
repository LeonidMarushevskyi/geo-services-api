package gov.ca.cwds.geo.service.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class DistanceDTOTest {

  @Test
  public void setterAndGetter() {
    DistanceDTO target = new DistanceDTO();
    target.setMiles((double) 2);
    Double actual = target.getMiles();
    assertEquals(actual, new Double(2));
  }

  @Test
  public void constructorCreation() {
    DistanceDTO target = new DistanceDTO((double) 3);
    Double actual = target.getMiles();
    assertEquals(actual, new Double(3));
  }

}
