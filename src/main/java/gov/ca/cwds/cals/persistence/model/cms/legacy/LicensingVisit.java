package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BaseLicensingVisit;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CWDS CALS API Team
 */
@Entity
@Table(name = "LIC_VSTT")
public class LicensingVisit extends BaseLicensingVisit {

  private static final long serialVersionUID = -8288205929550791794L;
}
