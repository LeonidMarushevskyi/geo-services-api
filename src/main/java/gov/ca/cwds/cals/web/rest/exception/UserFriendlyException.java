package gov.ca.cwds.cals.web.rest.exception;

import javax.ws.rs.core.Response.Status;

/**
 * @author CWDS CALS API Team
 */

public class UserFriendlyException extends RuntimeException {

    private final CalsExceptionInfo calsExceptionInfo;

    private final Status responseStatus;

    public UserFriendlyException(CalsExceptionInfo calsExceptionInfo, Status responseStatus) {
        this.calsExceptionInfo = calsExceptionInfo;
        this.responseStatus = responseStatus;
    }

    public CalsExceptionInfo getCalsExceptionInfo() {
        return calsExceptionInfo;
    }

    public Status getResponseStatus() {
        return responseStatus;
    }
}
