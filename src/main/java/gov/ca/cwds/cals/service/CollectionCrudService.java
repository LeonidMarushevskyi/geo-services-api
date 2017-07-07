package gov.ca.cwds.cals.service;

import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.Service;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author CWDS CALS API Team
 */
public interface CollectionCrudService extends Service {
    Response find(Serializable params);

    Response delete(Serializable params);

    Response create(Serializable params, Request request);

    Response update(Serializable params, Request request);

    Collection<Response> getAll(Serializable params);
}
