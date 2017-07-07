package gov.ca.cwds.cals.service.rfa;

import gov.ca.cwds.cals.persistence.dao.calsns.RFAExternalEntityDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntity;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntityDTO;
import gov.ca.cwds.cals.service.CrudServiceAdapter;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFAExternalEntityFactory;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S00119")
public class AbstractRFAExternalEntitiesCollectionService<
    Entity extends RFAExternalEntity<EntityDTO>,
    EntityDTO extends RFAExternalEntityDTO,
    EntitiesDTO extends CollectionDTO<EntityDTO>>
    extends CrudServiceAdapter {

  private RFAExternalEntityDao<Entity, EntityDTO, EntitiesDTO> dao;
  private RFAExternalEntityFactory<Entity, EntityDTO, EntitiesDTO> configuration;

  public AbstractRFAExternalEntitiesCollectionService(
      RFAExternalEntityDao<Entity, EntityDTO, EntitiesDTO> dao,
      RFAExternalEntityFactory<Entity, EntityDTO, EntitiesDTO> configuration) {
    this.dao = dao;
    this.configuration = configuration;
  }

  @Override
  public Response find(Serializable params) {
    if (!(params instanceof RFAExternalEntityParameterObject)) {
      throw new IllegalStateException("RFA1aApplicantParameterObject is expected here");
    }
    List<Entity> entities =
        dao.findAllByFormId(((RFAExternalEntityParameterObject) params).getFormId());
    List<EntityDTO> collectDTOs =
        entities.stream().map(Entity::getEntityDTO).collect(Collectors.toList());
    return configuration.createEntitiesDTO(collectDTOs);
  }
}
