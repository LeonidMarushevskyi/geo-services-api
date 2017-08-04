package gov.ca.cwds.geo.web.rest;

import static gov.ca.cwds.geo.Constants.ADDRESS;
import static gov.ca.cwds.geo.Constants.LOOKUP_ZIP_CODE;
import static gov.ca.cwds.geo.Constants.PREFIX;
import static gov.ca.cwds.geo.Constants.SUGGEST;
import static gov.ca.cwds.geo.Constants.VALIDATE_SINGLE;
import static gov.ca.cwds.geo.Constants.ZIP_CODE;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.geo.inject.AddressValidationServiceBackedResource;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.AddressService;
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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author CWDS API Team
 */
@Api(value = ADDRESS, tags = ADDRESS)
@Path(ADDRESS)
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
  @Path("/" + VALIDATE_SINGLE)
  @Timed
  @ApiResponses(
    value = {
        @ApiResponse(code = 400, message = "Bad Request (Malformed Payload): The request was malformed in some way and could not be parsed."),
        @ApiResponse(code = 401, message = "Unauthorized: The credentials were provided incorrectly or did not match any existing, active credentials."),
        @ApiResponse(code = 402, message = "Payment Required: There is no active subscription for the account associated with the credentials submitted with the request."),
        @ApiResponse(code = 422, message = "Unprocessable Entity (Unsuitable Payload): The value of the prefix input parameter was too long and could not be processed."),
        @ApiResponse(code = 429, message = "Too Many Requests: When using public \"website key\" authentication, we restrict the number of requests coming from a given source over too short of a time. If you use \"website key\" authentication, you can avoid this error by adding your IP address as an authorized host for the website key in question."),
        @ApiResponse(code = 200, message = "OK (success!)")
    }
  )
  @Consumes(value = MediaType.APPLICATION_JSON)
  @ApiOperation(
    value = "Validate Single Address",
    response = ValidatedAddressDTO[].class
  )
  public Response validateSingleAddress(
      @Valid @ApiParam(required = true) Address address) {
    ValidatedAddressDTO[] addresses;
    try {
      addresses =
          ((AddressService)
                  ((ServiceBackedResourceDelegate) resourceDelegate).getService())
              .fetchValidatedAddresses(address);
    } catch (Exception e) {
      throw new ApiException("ERROR calling USStreetAddressService to fetch Validated Addresses", e);
    }
    if (addresses != null) {
      return Response.ok(addresses).build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(null).build();
    }
  }

  @GET
  @Timed
  @Path("/" + LOOKUP_ZIP_CODE + "/{" + ZIP_CODE + "}" )
  @ApiResponses(
      value = {
          @ApiResponse(code = 400, message = "Bad Request (Malformed Payload): The request was malformed in some way and could not be parsed."),
          @ApiResponse(code = 401, message = "Unauthorized: The credentials were provided incorrectly or did not match any existing, active credentials."),
          @ApiResponse(code = 402, message = "Payment Required: There is no active subscription for the account associated with the credentials submitted with the request."),
          @ApiResponse(code = 422, message = "Unprocessable Entity (Unsuitable Payload): The value of the prefix input parameter was too long and could not be processed."),
          @ApiResponse(code = 429, message = "Too Many Requests: When using public \"website key\" authentication, we restrict the number of requests coming from a given source over too short of a time. If you use \"website key\" authentication, you can avoid this error by adding your IP address as an authorized host for the website key in question."),
          @ApiResponse(code = 200, message = "OK (success!)")
      }
  )
  @ApiOperation(
      value = "Lookup City and State by Zip Code",
      response = ValidatedAddressDTO[].class
  )
  public Response getCityStateByZipCode(
      @PathParam(ZIP_CODE) @ApiParam(required = true, name = ZIP_CODE, value = "Zip Code") String zipCode) {
    ValidatedAddressDTO[] addresses;
    try {
      addresses =
          ((AddressService)
              ((ServiceBackedResourceDelegate) resourceDelegate).getService())
              .lookupSingleUSZip(zipCode);
    } catch (Exception e) {
      throw new ApiException("ERROR calling USStreetAddressService to lookup City and State by Zip Code", e);
    }
    if (addresses != null) {
      return Response.ok(addresses).build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(null).build();
    }
  }

  @GET
  @Timed
  @Path("/" + SUGGEST + "/{" + PREFIX + "}" )
  @ApiResponses(
      value = {
          @ApiResponse(code = 400, message = "Bad Request (Malformed Payload): The request was malformed in some way and could not be parsed."),
          @ApiResponse(code = 401, message = "Unauthorized: The credentials were provided incorrectly or did not match any existing, active credentials."),
          @ApiResponse(code = 402, message = "Payment Required: There is no active subscription for the account associated with the credentials submitted with the request."),
          @ApiResponse(code = 422, message = "Unprocessable Entity (Unsuitable Payload): The value of the prefix input parameter was too long and could not be processed."),
          @ApiResponse(code = 429, message = "Too Many Requests: When using public \"website key\" authentication, we restrict the number of requests coming from a given source over too short of a time. If you use \"website key\" authentication, you can avoid this error by adding your IP address as an authorized host for the website key in question."),
          @ApiResponse(code = 200, message = "OK (success!)")
      }
  )
  @ApiOperation(
      value = "Autocomplete Address by prefix",
      response = Address[].class
  )
  public Response suggestAddress(
      @PathParam(PREFIX) @ApiParam(required = true, name = PREFIX, value = "Required. The part of the address that has already been typed. Maximum length is 128 bytes.") String prefix) {
    Address[] addresses;
    try {
      addresses =
          ((AddressService)
              ((ServiceBackedResourceDelegate) resourceDelegate).getService())
              .suggestAddress(prefix);
    } catch (Exception e) {
      throw new ApiException("ERROR calling USStreetAddressService to autocomplete Address", e);
    }
    if (addresses != null) {
      return Response.ok(addresses).build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity(null).build();
    }
  }
}
