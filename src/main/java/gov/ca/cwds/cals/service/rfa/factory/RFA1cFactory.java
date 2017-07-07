package gov.ca.cwds.cals.service.rfa.factory;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1cFormCollectionDTO;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

public class RFA1cFactory
    implements RFAExternalEntityFactory<RFA1cForm, RFA1cFormDTO, RFA1cFormCollectionDTO> {

  public static final RFAExternalEntityFactory<RFA1cForm, RFA1cFormDTO, RFA1cFormCollectionDTO>
      INSTANCE = new RFA1cFactory();

  private RFA1cFactory() {
  }

  @Override
  public RFA1cFormDTO createEntityDTO() {
    return new RFA1cFormDTO();
  }

  @Override
  public RFA1cForm createEntity() {
    return new RFA1cForm();
  }

  @Override
  public Class<RFA1cForm> getEntityClass() {
    return RFA1cForm.class;
  }

  @Override
  public RFA1cFormCollectionDTO createEntitiesDTO(List<RFA1cFormDTO> collectDTOs) {
    return new RFA1cFormCollectionDTO(collectDTOs);
  }

  @Override
  public String getFindAllByFormNamedQuery() {
    return RFA1cForm.NAMED_QUERY_FIND_ALL_BY_FORM;
  }

  @Override
  public String getFindByFormIdAndEntityIdNamedQuery() {
    return RFA1cForm.NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMC_ID;
  }

}

