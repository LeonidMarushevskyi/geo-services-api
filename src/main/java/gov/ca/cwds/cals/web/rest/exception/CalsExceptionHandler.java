package gov.ca.cwds.cals.web.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author CWDS CALS API Team
 */

@Provider
public class CalsExceptionHandler implements ExceptionMapper<UserFriendlyException> {

    @Override
    public Response toResponse(UserFriendlyException exception) {
        return Response.status(exception.getResponseStatus()).entity(exception.getCalsExceptionInfo())
                .type(MediaType.APPLICATION_JSON).build();
    }
}
