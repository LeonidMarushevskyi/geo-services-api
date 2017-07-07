package gov.ca.cwds.cals.web.rest.rfa.configuration;

import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import gov.ca.cwds.cals.web.rest.RestClientTestRule;

/**
 * @author CWDS CALS API Team
 */

public abstract class TestExternalEntityConfiguration<T extends BaseDTO, G extends CollectionDTO<T>> extends
    TestInternalEntityConfiguration<T> {

  private Class<G> collectionDTOClass;

  public TestExternalEntityConfiguration(
      RestClientTestRule clientTestRule,
      Class<T> entityClass,
      Class<G> collectionDTOClass,
      String apiPath) {
    super(clientTestRule, entityClass, apiPath);
    this.collectionDTOClass = collectionDTOClass;
  }

  public abstract void modifyEntity(T entity);

  public Class<G> getCollectionDTOClass() {
    return collectionDTOClass;
  }

  public void setCollectionDTOClass(
      Class<G> collectionDTOClass) {
    this.collectionDTOClass = collectionDTOClass;
  }

}
