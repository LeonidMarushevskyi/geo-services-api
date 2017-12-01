package gov.ca.cwds.geo.web.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

/**
 * Additional HTTP Status Codes are to be placed in this class.
 * See {@link Response.Status}
 *
 * @author CWDS TPT-3 Team
 */
public enum ResponseStatus implements Response.StatusType {

  UNPROCESSABLE_ENTITY(422, "Unprocessable Entity");

  private final int code;
  private final String reason;
  private final Response.Status.Family family;

  ResponseStatus(int statusCode, String reasonPhrase) {
    this.code = statusCode;
    this.reason = reasonPhrase;
    this.family = Response.Status.Family.familyOf(statusCode);
  }

  @Override
  public int getStatusCode() {
    return code;
  }

  @Override
  public Family getFamily() {
    return family;
  }

  @Override
  public String getReasonPhrase() {
    return reason;
  }
}
