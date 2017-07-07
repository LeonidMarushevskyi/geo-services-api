package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;

/**
 * @author CWDS CALS API Team
 */

public class RFAExternalEntityDTO extends BaseDTO implements Request, Response {

  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
