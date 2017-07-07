package gov.ca.cwds.cals.web.rest.parameter;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.MinorChildDTO;
import gov.ca.cwds.rest.api.Request;
import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */
public class RFAMinorChildrenParameterObject implements Request, Serializable {

  private static final long serialVersionUID = 6694171109010473069L;

  private Long applicationId;
  private Long minorChildId;
  private MinorChildDTO minorChild;

  public RFAMinorChildrenParameterObject(Long applicationId) {
    this.applicationId = applicationId;
    this.minorChild = null;
    this.minorChildId = null;
  }

  public RFAMinorChildrenParameterObject(Long applicationId, MinorChildDTO minorChild) {
    this.applicationId = applicationId;
    this.minorChild = minorChild;
    this.minorChildId = null;
  }

  public RFAMinorChildrenParameterObject(Long applicationId, Long minorChildId) {
    this.applicationId = applicationId;
    this.minorChild = null;
    this.minorChildId = minorChildId;
  }

  public Long getApplicationId() {
    return applicationId;
  }

  public Long getMinorChildId() {
    return minorChildId;
  }

  public MinorChildDTO getMinorChild() {
    return minorChild;
  }
}
