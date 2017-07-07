package gov.ca.cwds.cals.service.rfa.factory;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.MinorChildDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild;
import gov.ca.cwds.cals.service.dto.rfa.MinorChildrenDTO;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

public class MinorChildFactory
    implements RFAExternalEntityFactory<RFA1aMinorChild, MinorChildDTO, MinorChildrenDTO> {

  public static final RFAExternalEntityFactory<RFA1aMinorChild, MinorChildDTO, MinorChildrenDTO>
      INSTANCE = new MinorChildFactory();

  private MinorChildFactory() {
  }

  @Override
  public MinorChildDTO createEntityDTO() {
    return new MinorChildDTO();
  }

  @Override
  public RFA1aMinorChild createEntity() {
    return new RFA1aMinorChild();
  }

  @Override
  public Class<RFA1aMinorChild> getEntityClass() {
    return RFA1aMinorChild.class;
  }

  @Override
  public MinorChildrenDTO createEntitiesDTO(List<MinorChildDTO> collectDTOs) {
    return new MinorChildrenDTO(collectDTOs);
  }

  @Override
  public String getFindAllByFormNamedQuery() {
    return RFA1aMinorChild.NAMED_QUERY_FIND_ALL_BY_FORM;
  }

  @Override
  public String getFindByFormIdAndEntityIdNamedQuery() {
    return RFA1aMinorChild.NAMED_QUERY_FIND_BY_FORM_ID_AND_CHILD_ID;
  }

}

