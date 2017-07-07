package gov.ca.cwds.cals.persistence.model.cms;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author CWDS CALS API Team
 */
@Entity
@Cacheable
@DiscriminatorValue(value = "LIC_STC ")
public class LicenseStatus extends SystemCodeTable {
    private static final long serialVersionUID = 42L;
}
