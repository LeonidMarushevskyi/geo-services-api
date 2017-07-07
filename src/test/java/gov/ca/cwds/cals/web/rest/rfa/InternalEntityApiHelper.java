package gov.ca.cwds.cals.web.rest.rfa;

/**
 * @author CWDS CALS API Team
 */

public interface InternalEntityApiHelper {

  void getApplicationNotFound() throws Exception;

  void putApplicationNotFound() throws Exception;

  void getEntityNotFound() throws Exception;

  void putAndGetEntity() throws Exception;
}
