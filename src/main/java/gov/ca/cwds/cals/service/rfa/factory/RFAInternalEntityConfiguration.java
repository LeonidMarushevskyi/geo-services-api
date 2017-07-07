package gov.ca.cwds.cals.service.rfa.factory;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;

/**
 * @author CWDS CALS API Team
 */
public abstract class RFAInternalEntityConfiguration<T extends BaseDTO> {

  private Class<T> entityClass;

  public RFAInternalEntityConfiguration(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public Class<T> getEntityClass() {
    return entityClass;
  }

  protected abstract T retrieveEntityFromTheForm(RFA1aForm form);

  public Response getEntityFromTheForm(RFA1aForm form) {
    T entity = retrieveEntityFromTheForm(form);
    return (Response) entity;
  }

  public void putEntityToTheForm(RFA1aForm form, Request request) {
    if (!(request.getClass().isAssignableFrom(entityClass))) {
      throw new IllegalStateException(
          "Unexpected request class type. Expected is " + entityClass.getSimpleName());
    }
    saveEntityToTheForm(form, (T) request);
  }

  protected abstract void saveEntityToTheForm(RFA1aForm form, T entity);

}
