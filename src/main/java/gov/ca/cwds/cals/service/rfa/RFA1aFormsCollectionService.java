package gov.ca.cwds.cals.service.rfa;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.calsns.RFA1aFormsDao;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.CrudServiceAdapter;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormCollectionDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormDTO;
import gov.ca.cwds.cals.service.mapper.rfa.RFA1aFormMapper;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */
public class RFA1aFormsCollectionService extends CrudServiceAdapter {

  private RFA1aFormsDao dao;
  private RFA1aFormMapper rfa1aFormMapper;

  @Inject
  public RFA1aFormsCollectionService(RFA1aFormsDao dao, RFA1aFormMapper rfa1aFormMapper) {
    this.dao = dao;
    this.rfa1aFormMapper = rfa1aFormMapper;
  }

  @Override
  public Response find(Serializable params) {
    List<RFA1aForm> forms = dao.findAll();
    List<RFA1aFormDTO> formDTOs = rfa1aFormMapper.toRFA1aFormsDTO(forms);
    return new RFA1aFormCollectionDTO(formDTOs);
  }

}
