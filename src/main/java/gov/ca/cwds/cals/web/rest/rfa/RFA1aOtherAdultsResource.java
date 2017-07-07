package gov.ca.cwds.cals.web.rest.rfa;

import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_APPLICATION_ID;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_OTHER_ADULT;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_OTHER_ADULT_ID;
import static gov.ca.cwds.cals.Constants.API.RFA_1A_FORMS;
import static gov.ca.cwds.cals.Constants.API.RFA_1A_OTHER_ADULTS;
import static gov.ca.cwds.cals.Constants.RFA;
import static gov.ca.cwds.cals.Constants.UnitOfWork.CALSNS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.RFA1aOtherAdultsCollectionServiceBackedResource;
import gov.ca.cwds.cals.inject.RFA1aOtherAdultsServiceBackedResource;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.OtherAdultDTO;
import gov.ca.cwds.cals.service.dto.rfa.OtherAdultCollectionDTO;
import gov.ca.cwds.cals.web.rest.parameter.RFAExternalEntityParameterObject;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author CWDS CALS API Team
 */
@Api(tags = {RFA})
@Path(RFA_1A_FORMS + "/{" + RFA_1A_APPLICATION_ID + "}/" + RFA_1A_OTHER_ADULTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RFA1aOtherAdultsResource {

  private ResourceDelegate resourceDelegate;
  private ResourceDelegate collectionResourceDelegate;

  @Inject
  public RFA1aOtherAdultsResource(
      @RFA1aOtherAdultsServiceBackedResource ResourceDelegate resourceDelegate,
      @RFA1aOtherAdultsCollectionServiceBackedResource
          ResourceDelegate collectionResourceDelegate) {
    this.resourceDelegate = resourceDelegate;
    this.collectionResourceDelegate = collectionResourceDelegate;
  }

  @UnitOfWork(CALSNS)
  @POST
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Creates and returns RFA 1a Other Adult object", response = OtherAdultDTO.class)
  public Response createOtherAdult(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long applicationId,
      @ApiParam(required = true, name = RFA_1A_OTHER_ADULT, value = "The RFA-1a OtherAdult object")
          OtherAdultDTO otherAdult) {
    return resourceDelegate.create(
        new RFAExternalEntityParameterObject<>(applicationId, otherAdult));
  }

  @UnitOfWork(CALSNS)
  @PUT
  @Path("/{" + RFA_1A_OTHER_ADULT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Update and returns RFA 1a OtherAdult object", response = OtherAdultDTO.class)
  public Response updateMinorChild(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1a Application Id"
      )
          Long applicationId,
      @PathParam(RFA_1A_OTHER_ADULT_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_OTHER_ADULT_ID,
          value = "The RFA-1a OtherAdult Id"
      )
          Long minorChildId,
      @ApiParam(required = true, name = RFA_1A_OTHER_ADULT, value = "The RFA-1a OtherAdult object")
          OtherAdultDTO otherAdult) {
    return resourceDelegate.update(
        minorChildId, new RFAExternalEntityParameterObject<>(applicationId, otherAdult));
  }

  @UnitOfWork(CALSNS)
  @GET
  @Path("/{" + RFA_1A_OTHER_ADULT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Returns RFA 1a Form's OtherAdult by Id", response = OtherAdultDTO.class)
  public Response getOtherAdultById(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1a Application Id"
      )
          Long applicationId,
      @PathParam(RFA_1A_OTHER_ADULT_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_OTHER_ADULT_ID,
          value = "The RFA-1a OtherAdult Id"
      )
          Long otherAdultId) {

    return resourceDelegate
        .get(new RFAExternalEntityParameterObject<OtherAdultDTO>(applicationId, otherAdultId));
  }

  @UnitOfWork(CALSNS)
  @GET
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(
      value = "Returns RFA 1a Form's Other Adults by Application Id",
      response = OtherAdultCollectionDTO.class
  )
  public Response getOtherAdultsByFormId(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1a Application Id"
      )
          Long applicationId) {
    return collectionResourceDelegate
        .get(new RFAExternalEntityParameterObject<OtherAdultDTO>(applicationId));
  }

  @UnitOfWork(CALSNS)
  @DELETE
  @Path("/{" + RFA_1A_OTHER_ADULT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found")
      }
  )
  @ApiOperation(value = "Delete RFA 1a Form's OtherAdult by Id")
  public Response deleteOtherAdult(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long applicationId,
      @PathParam(RFA_1A_OTHER_ADULT_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_OTHER_ADULT_ID,
          value = "The RFA-1a OtherAdult Id"
      )
          Long otherAdultId) {
    return resourceDelegate.delete(
        new RFAExternalEntityParameterObject<OtherAdultDTO>(applicationId, otherAdultId));
  }
}
