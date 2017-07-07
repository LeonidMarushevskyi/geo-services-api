package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.ADDRESS;
import static gov.ca.cwds.geo.Constants.VALIDATE_SINGLE;

import com.google.inject.Inject;
import gov.ca.cwds.geo.inject.AddressValidationServiceBackedResource;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.AddressValidationService;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.api.ApiException;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import gov.ca.cwds.rest.resources.ServiceBackedResourceDelegate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.HttpStatus;

/**
 * A resource providing a RESTful interface for {@link ValidatedAddressDTO}. It delegates functions
 * to {@link ResourceDelegate}. It decorates the {@link ResourceDelegate} not in functionality but
 * with @see <a href= "https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X">Swagger
 * Annotations</a> and <a
 * href="https://jersey.java.net/documentation/latest/user-guide.html#jaxrs-resources">Jersey
 * Annotations</a>
 *
 * @author CWDS API Team
 */
@Api(value = ADDRESS, tags = ADDRESS)
@Path(ADDRESS + "/" + VALIDATE_SINGLE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {
  private ResourceDelegate resourceDelegate;

  /**
   * Constructor
   *
   * @param resourceDelegate The resourceDelegate to delegate to.
   */
  @Inject
  public AddressResource(
      @AddressValidationServiceBackedResource ResourceDelegate resourceDelegate) {
    this.resourceDelegate = resourceDelegate;
  }

  /**
   * Returns a list of Validated Addresses
   *
   * @param address The {@link Address}
   * @return The {@link Response}
   */
  @POST
  @ApiResponses(
    value = {
      @ApiResponse(code = 400, message = "Unable to process JSON"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 406, message = "Accept Header not supported"),
      @ApiResponse(code = 422, message = "Unable to validate Address")
    }
  )
  @Consumes(value = MediaType.APPLICATION_JSON)
  @ApiOperation(
    value = "Validate Single Address",
    code = HttpStatus.SC_OK,
    response = ValidatedAddressDTO[].class
  )
  public Response validateSingleAddress(
      @Valid @ApiParam(hidden = false, required = true) Address address) {
    ValidatedAddressDTO[] addresses = null;
    try {
      addresses =
          ((AddressValidationService)
                  ((ServiceBackedResourceDelegate) resourceDelegate).getService())
              .fetchValidatedAddresses(address);
    } catch (Exception e) {
      throw new ApiException("ERROR calling SmartyStreet to fetch Validated Addresses", e);
    }
    if (addresses != null) {
      return Response.ok(addresses).build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(null).build();
    }
  }
}
