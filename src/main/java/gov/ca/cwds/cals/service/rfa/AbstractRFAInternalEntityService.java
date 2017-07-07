package gov.ca.cwds.cals.service.rfa;

import static gov.ca.cwds.cals.Constants.SYSTEM_USER_ID;
import static gov.ca.cwds.cals.web.rest.exception.CalsExceptionInfo.RFA_1A_APPLICATION_NOT_FOUND_BY_ID;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.CrudServiceAdapter;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.cals.service.rfa.factory.RFAInternalEntityConfiguration;
import gov.ca.cwds.cals.web.rest.exception.UserFriendlyException;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author CWDS CALS API Team.
 */
public abstract class AbstractRFAInternalEntityService<T extends BaseDTO> extends
    CrudServiceAdapter {

  private final RFA1aFormsDao applicationDao;
  private RFAInternalEntityConfiguration<T> configuration;

  public AbstractRFAInternalEntityService(RFA1aFormsDao applicationDao,
      RFAInternalEntityConfiguration<T> configuration) {
    this.applicationDao = applicationDao;
    this.configuration = configuration;
  }

  @Override
  public Response find(Serializable applicationId) {
    RFA1aForm form = applicationDao.find(applicationId);
    if (form == null) {
      throw new UserFriendlyException(RFA_1A_APPLICATION_NOT_FOUND_BY_ID, NOT_FOUND);
    }
    return configuration.getEntityFromTheForm(form);
  }

  @Override
  public Response update(Serializable applicationId, Request request) {
    RFA1aForm form = applicationDao.find(applicationId);
    if (form == null) {
      throw new UserFriendlyException(RFA_1A_APPLICATION_NOT_FOUND_BY_ID, NOT_FOUND);
    }
    form.setUpdateDateTime(LocalDateTime.now());
    form.setUpdateUserId(SYSTEM_USER_ID);

    configuration.putEntityToTheForm(form, request);

    RFA1aForm updatedForm = applicationDao.update(form);
    return configuration.getEntityFromTheForm(updatedForm);
  }
}
