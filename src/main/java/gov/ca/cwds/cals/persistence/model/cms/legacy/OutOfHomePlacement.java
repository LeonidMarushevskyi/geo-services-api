package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BaseOutOfHomePlacement;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author CWDS CALS API Team
 */
@Entity
@javax.persistence.Table(name = "O_HM_PLT")
public class OutOfHomePlacement extends BaseOutOfHomePlacement {
    private static final long serialVersionUID = 8899107757146812647L;

    private PlacementHome placementHome;

    @Override
    @ManyToOne
    @JoinColumn(name = "FKPLC_HM_T", referencedColumnName = "IDENTIFIER")
    public PlacementHome getPlacementHome() {
        return placementHome;
    }

    public void setPlacementHome(PlacementHome placementHome) {
        this.placementHome = placementHome;
    }
}
