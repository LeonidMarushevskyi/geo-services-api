package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementEpisode;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author CWDS CALS API Team
 */
@Entity
@javax.persistence.Table(name = "PLC_EPST")
public class PlacementEpisode extends BasePlacementEpisode {
  private static final long serialVersionUID = -3903845942588945920L;

  private Set<OutOfHomePlacement> outOfHomePlacements = new HashSet<>();

  private StaffPerson staffPerson;

  @Override
  @OneToMany
  @JoinColumn(name = "FKPLC_EPS0", referencedColumnName = "THIRD_ID")
  @OrderBy("startDt DESC")
  public Set<OutOfHomePlacement> getOutOfHomePlacements() {
    return outOfHomePlacements;
  }

  public void setOutOfHomePlacements(Set<OutOfHomePlacement> outOfHomePlacements) {
    this.outOfHomePlacements = outOfHomePlacements;
  }

  @Override
  @NotFound(action = NotFoundAction.IGNORE)
  @OneToOne
  @JoinColumn(name = "RMV_BY_ID", referencedColumnName = "IDENTIFIER")
  public StaffPerson getStaffPerson() {
    return staffPerson;
  }

  public void setStaffPerson(StaffPerson staffPerson) {
    this.staffPerson = staffPerson;
  }
}
