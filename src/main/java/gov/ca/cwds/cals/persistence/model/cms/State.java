package gov.ca.cwds.cals.persistence.model.cms;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author CWDS CALS API Team
 */
@Entity
@Cacheable
@DiscriminatorValue(value = "STATE_C ")
public class State extends SystemCodeTable {
    private static final long serialVersionUID = 42L;
}