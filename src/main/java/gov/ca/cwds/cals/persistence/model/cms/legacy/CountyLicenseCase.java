package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BaseCountyLicenseCase;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */
@Entity
@Table(name = "CNTY_CST")
public class CountyLicenseCase extends BaseCountyLicenseCase {

  private static final long serialVersionUID = 5487129105879851952L;

  private List<LicensingVisit> licensingVisits;

  private StaffPerson staffPerson;

  @Override
  @NotFound(action = NotFoundAction.IGNORE)
  @OneToMany
  @JoinColumn(name = "FKCNTY_CST", referencedColumnName = "IDENTIFIER")
  @OrderBy("visitDate DESC")
  public List<LicensingVisit> getLicensingVisits() {
    return licensingVisits;
  }

  public void setLicensingVisits(List<LicensingVisit> licensingVisits) {
    this.licensingVisits = licensingVisits;
  }

  @Override
  @NotFound(action = NotFoundAction.IGNORE)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FKSTFPERST", referencedColumnName = "IDENTIFIER")
  public StaffPerson getStaffPerson() {
    return staffPerson;
  }

  public void setStaffPerson(StaffPerson fkstfperst) {
    this.staffPerson = fkstfperst;
  }
}
