package gov.ca.cwds.cals.service.rfa;

import static gov.ca.cwds.cals.Constants.SYSTEM_USER_ID;
import static gov.ca.cwds.cals.web.rest.exception.CalsExceptionInfo.RFA_1A_APPLICATION_NOT_FOUND_BY_ID;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicationDTO;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.CrudServiceAdapter;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormDTO;
import gov.ca.cwds.cals.service.mapper.rfa.RFA1aFormMapper;
import gov.ca.cwds.cals.web.rest.exception.UserFriendlyException;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aFormService extends CrudServiceAdapter {

  private RFA1aFormsDao dao;
  private RFA1aFormMapper mapper;

  @Inject
  public RFA1aFormService(RFA1aFormsDao dao, RFA1aFormMapper mapper) {
    this.dao = dao;
    this.mapper = mapper;
  }

  @Override
  public Response create(Request request) {
    RFA1aForm form = new RFA1aForm();
    ApplicationDTO application;

    if (request == null) {
      application = new ApplicationDTO();
    } else if (!(request instanceof ApplicationDTO)) {
      throw new IllegalArgumentException("Cannot convert request to Application");
    } else {
      application = (ApplicationDTO) request;
    }

    LocalDateTime now = LocalDateTime.now();
    form.setCreateDateTime(now);
    form.setCreateUserId(SYSTEM_USER_ID);
    form.setUpdateDateTime(now);
    form.setUpdateUserId(SYSTEM_USER_ID);

    form.setApplication(application);
    form = dao.create(form);

    return mapper.toRFA1aFormDTO(form);
  }

  @Override
  public Response find(Serializable formId) {
    RFA1aForm form = dao.find(formId);
    return mapper.toRFA1aFormDTO(form);
  }

  @Override
  public Response update(Serializable formId, Request request) {
    RFA1aForm rfa1aForm = dao.find(formId);
    if (rfa1aForm == null) {
      throw new UserFriendlyException(RFA_1A_APPLICATION_NOT_FOUND_BY_ID, NOT_FOUND);
    }
    if (!(request instanceof RFA1aFormDTO)) {
      throw new IllegalArgumentException("request is not of expected type: RFA1aFormDTO");
    }
    RFA1aFormDTO formDTO = (RFA1aFormDTO) request;
    mapper.toRFA1aForm(rfa1aForm, formDTO);
    rfa1aForm.setUpdateDateTime(LocalDateTime.now());
    rfa1aForm.setUpdateUserId(SYSTEM_USER_ID);
    dao.update(rfa1aForm);
    return mapper.toRFA1aFormDTO(dao.find(formId));
  }

}
