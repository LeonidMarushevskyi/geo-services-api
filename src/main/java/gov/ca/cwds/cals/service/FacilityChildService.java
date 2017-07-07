package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.cms.ClientDao;
import gov.ca.cwds.cals.persistence.model.cms.BaseClient;
import gov.ca.cwds.cals.service.mapper.FacilityChildMapper;
import gov.ca.cwds.cals.web.rest.parameter.FacilityChildParameterObject;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */
public class FacilityChildService extends CrudServiceAdapter {
    private ClientDao clientDao;
    private FacilityChildMapper facilityChildMapper;

    @Inject
    public FacilityChildService(ClientDao clientDao, FacilityChildMapper facilityChildMapper) {
        this.clientDao = clientDao;
        this.facilityChildMapper = facilityChildMapper;
    }

    @Override
    public Response find(Serializable params) {
        FacilityChildParameterObject parameterObject = (FacilityChildParameterObject) params;
        BaseClient client = clientDao.findByParameterObject(parameterObject);
        return facilityChildMapper.toFacilityChildDTO(client);
    }
}
