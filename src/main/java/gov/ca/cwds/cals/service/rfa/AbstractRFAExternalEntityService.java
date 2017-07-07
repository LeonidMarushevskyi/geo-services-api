package gov.ca.cwds.cals.service.rfa;

import static gov.ca.cwds.cals.Constants.SYSTEM_USER_ID;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import gov.ca.cwds.cals.persistence.dao.calsns.RFAExternalEntityDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntity;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntityDTO;
import gov.ca.cwds.cals.service.CrudServiceAdapter;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFAExternalEntityFactory;
import gov.ca.cwds.cals.web.rest.exception.CalsExceptionInfo;
import gov.ca.cwds.cals.web.rest.exception.UserFriendlyException;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author CWDS CALS API Team.
 */
@SuppressWarnings("squid:S00119")
public abstract class AbstractRFAExternalEntityService<
    Entity extends RFAExternalEntity<EntityDTO>,
    EntityDTO extends RFAExternalEntityDTO,
    ParameterObject extends RFAExternalEntityParameterObject<EntityDTO>,
    EntitiesDTO extends CollectionDTO<EntityDTO>
    > extends CrudServiceAdapter {

  private RFAExternalEntityDao<Entity, EntityDTO, EntitiesDTO> dao;
  private RFAExternalEntityFactory<Entity, EntityDTO, EntitiesDTO> configuration;

  public AbstractRFAExternalEntityService(
      RFAExternalEntityDao<Entity, EntityDTO, EntitiesDTO> dao,
      RFAExternalEntityFactory<Entity, EntityDTO, EntitiesDTO> configuration) {
    this.dao = dao;
    this.configuration = configuration;
  }

  @Override
  public Response create(Request request) {
    ParameterObject params = getParamObject(request);
    EntityDTO entityDTO = params.getEntityDTO();

    if (entityDTO == null) {
      entityDTO = configuration.createEntityDTO();
    }

    Entity entity = configuration.createEntity();

    RFAServiceHelper.fillCreateBaseFields(entity, SYSTEM_USER_ID);

    entity.setEntityDTO(entityDTO);
    entity.setFormId(params.getFormId());
    entity = dao.create(entity);
    entityDTO = entity.getEntityDTO();
    entityDTO.setId(entity.getId());
    return entityDTO;
  }

  @Override
  public Response find(Serializable params) {
    ParameterObject entityParams = getParamObject(params);
    Entity entity =
        dao.findEntityByFormIdAndEntityId(
            entityParams.getFormId(), entityParams.getEntityId());
    if (entity == null) {
      throw new UserFriendlyException(
          CalsExceptionInfo.RFA_1A_APPLICANT_NOT_FOUND_BY_ID, NOT_FOUND);
    } else {
      EntityDTO entityDto = entity.getEntityDTO();
      entityDto.setId(entity.getId());
      return entityDto;
    }
  }

  @Override
  public Response delete(Serializable params) {
    ParameterObject entityParams = getParamObject(params);
    Entity entity =
        dao.deleteApplicant(entityParams.getFormId(), entityParams.getEntityId());
    EntityDTO deleted = null;
    if (entity != null) {
      deleted = entity.getEntityDTO();
    }
    return deleted;
  }

  @Override
  public Response update(Serializable entityId, Request params) {
    ParameterObject entityParams = getParamObject(params);
    Entity entity = null;
    if (entityId instanceof Long) {
      entity =
          dao.findEntityByFormIdAndEntityId(entityParams.getFormId(), (Long) entityId);
    }
    if (entity != null) {
      entity.setEntityDTO(entityParams.getEntityDTO());
      entity.setUpdateDateTime(LocalDateTime.now());
      entity.setUpdateUserId(SYSTEM_USER_ID);
    }

    Entity updated = dao.update(entity);

    EntityDTO entityDTO = null;
    // Update RFA 1a Form
    if (updated != null) {
      entityDTO = updated.getEntityDTO();
      entityDTO.setId(updated.getId());
    }

    return entityDTO;
  }

  private ParameterObject getParamObject(Object params) {
    if (!(params instanceof RFAExternalEntityParameterObject)) {
      throw new IllegalStateException("RFA1aApplicantParameterObject is expected here");
    }
    return (ParameterObject) params;
  }

}
