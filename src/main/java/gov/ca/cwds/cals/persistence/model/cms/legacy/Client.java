package gov.ca.cwds.cals.persistence.model.cms.legacy;

import gov.ca.cwds.cals.persistence.model.cms.BaseClient;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(
    name = "Client.find",
    query = "SELECT c FROM Client c"
        + " JOIN c.placementEpisodes pe"
        + " JOIN pe.outOfHomePlacements ohp"
        + " JOIN ohp.placementHome ph"
        + " WHERE ph.licenseNo = :licenseNumber AND c.identifier = :childId"
)
@NamedQuery(
    name = "Client.findAll",
    query = "SELECT c FROM Client c" +
        " JOIN c.placementEpisodes pe" +
        " JOIN pe.outOfHomePlacements ohp" +
        " JOIN ohp.placementHome ph" +
        " WHERE ph.licenseNo = :licenseNumber" +
        " ORDER BY c.identifier "
)
@NamedQuery(
    name = "Client.findByFacilityId",
    query = "SELECT c FROM Client c" +
        " JOIN c.placementEpisodes pe" +
        " JOIN pe.outOfHomePlacements ohp" +
        " JOIN ohp.placementHome ph" +
        " WHERE ph.id = :facilityId"
)
@Entity
@javax.persistence.Table(name = "CLIENT_T")
public class Client extends BaseClient {

  private static final long serialVersionUID = -1570433180700848831L;

  private Set<PlacementEpisode> placementEpisodes = new HashSet<>();

  @Override
  @OneToMany
  @JoinColumn(name = "FKCLIENT_T", referencedColumnName = "IDENTIFIER")
  @OrderBy("removalDt DESC")
  public Set<PlacementEpisode> getPlacementEpisodes() {
    return placementEpisodes;
  }

  public void setPlacementEpisodes(Set<PlacementEpisode> placementEpisodes) {
    this.placementEpisodes = placementEpisodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Client)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Client client = (Client) o;

    return placementEpisodes != null ? placementEpisodes.equals(client.placementEpisodes)
        : client.placementEpisodes == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (placementEpisodes != null ? placementEpisodes.hashCode() : 0);
    return result;
  }
}
