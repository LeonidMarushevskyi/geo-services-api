package gov.ca.cwds.cals.web.rest.parameter;

import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */
public class RFAExternalEntityParameterObject<T extends BaseDTO> implements Request,
    Serializable {

  private static final long serialVersionUID = -531872197296633529L;

  private Long formId;
  private Long entityId;
  private T entityDTO;

  public RFAExternalEntityParameterObject(Long formId) {
    this.formId = formId;
  }

  public RFAExternalEntityParameterObject(Long formId, T entityDTO) {
    this.formId = formId;
    this.entityDTO = entityDTO;
  }

  public RFAExternalEntityParameterObject(Long formId, Long entityId) {
    this.formId = formId;
    this.entityId = entityId;
  }

  public Long getFormId() {
    return formId;
  }

  public T getEntityDTO() {
    return entityDTO;
  }

  public Long getEntityId() {
    return entityId;
  }
}

