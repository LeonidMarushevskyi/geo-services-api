package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(
        name = "PlacementHome.find",
        query = "SELECT ph FROM PlacementHome ph "
                + " LEFT JOIN FETCH ph.countyLicenseCase cls"
                + " LEFT JOIN FETCH cls.staffPerson sp"
                + " LEFT JOIN FETCH cls.licensingVisits lv"
                + " WHERE ph.identifier = :facilityId"
)
@Entity
@javax.persistence.Table(name = "PLC_HM_T")
public class PlacementHome extends BasePlacementHome {
    private static final long serialVersionUID = 8516376534560115439L;

    private CountyLicenseCase countyLicenseCase;

    @Override
    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FKCNTY_CST", referencedColumnName = "IDENTIFIER")
    public CountyLicenseCase getCountyLicenseCase() {
        return countyLicenseCase;
    }

    public void setCountyLicenseCase(CountyLicenseCase countyLicenseCase) {
        this.countyLicenseCase = countyLicenseCase;
    }
}
