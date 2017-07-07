package gov.ca.cwds.cals.persistence.hibernate;

/**
 * @author CWDS CALS API Team
 */
public class ConvertingException extends RuntimeException {

  public ConvertingException(String s, Exception ex) {
    super(s, ex);
  }
}
