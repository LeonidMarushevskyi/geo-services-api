package gov.ca.cwds.cals.web.rest.rfa;

/**
 * @author CWDS CALS API Team
 */

public interface ExternalEntityApiHelper {

  void createEntity() throws Exception;

  void updateEntity() throws Exception;

  void getEntityById() throws Exception;

  void getEntitiesByFormId() throws Exception;

  void deleteEntity() throws Exception;

}
