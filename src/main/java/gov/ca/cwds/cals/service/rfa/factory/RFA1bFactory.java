package gov.ca.cwds.cals.service.rfa.factory;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1bFormCollectionDTO;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

public class RFA1bFactory
    implements RFAExternalEntityFactory<RFA1bForm, RFA1bFormDTO, RFA1bFormCollectionDTO> {

  public static final RFAExternalEntityFactory<RFA1bForm, RFA1bFormDTO, RFA1bFormCollectionDTO>
      INSTANCE = new RFA1bFactory();

  private RFA1bFactory() {
  }

  @Override
  public RFA1bFormDTO createEntityDTO() {
    return new RFA1bFormDTO();
  }

  @Override
  public RFA1bForm createEntity() {
    return new RFA1bForm();
  }

  @Override
  public Class<RFA1bForm> getEntityClass() {
    return RFA1bForm.class;
  }

  @Override
  public RFA1bFormCollectionDTO createEntitiesDTO(List<RFA1bFormDTO> collectDTOs) {
    return new RFA1bFormCollectionDTO(collectDTOs);
  }

  @Override
  public String getFindAllByFormNamedQuery() {
    return RFA1bForm.NAMED_QUERY_FIND_ALL_BY_FORM;
  }

  @Override
  public String getFindByFormIdAndEntityIdNamedQuery() {
    return RFA1bForm.NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMB_ID;
  }

}

