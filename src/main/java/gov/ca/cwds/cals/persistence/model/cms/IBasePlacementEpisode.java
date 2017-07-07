package gov.ca.cwds.cals.persistence.model.cms;

import java.util.Set;

/**
 * @author CWDS CALS API Team
 */
public interface IBasePlacementEpisode<OHP extends BaseOutOfHomePlacement, SP extends BaseStaffPerson> {
  Set<OHP> getOutOfHomePlacements();
  SP getStaffPerson();
}
