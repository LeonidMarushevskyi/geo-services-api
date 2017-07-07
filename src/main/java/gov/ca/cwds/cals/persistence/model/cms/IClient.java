package gov.ca.cwds.cals.persistence.model.cms;

import java.util.Set;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S1609") // this interface is not meant to be functional
public interface IClient<PE extends BasePlacementEpisode> {
  Set<PE> getPlacementEpisodes();
}
