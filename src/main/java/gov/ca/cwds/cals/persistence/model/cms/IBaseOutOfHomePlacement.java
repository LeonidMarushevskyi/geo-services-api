package gov.ca.cwds.cals.persistence.model.cms;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S1609") // this interface is not meant to be functional
public interface IBaseOutOfHomePlacement<PH extends BasePlacementHome> {
   PH getPlacementHome();
}
