package gov.ca.cwds.cals.web.rest.rfa;

import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_APPLICATION_ID;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1B_FORM;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1B_FORM_ID;
import static gov.ca.cwds.cals.Constants.API.RFA_1A_FORMS;
import static gov.ca.cwds.cals.Constants.API.RFA_1B_FORMS;
import static gov.ca.cwds.cals.Constants.RFA;
import static gov.ca.cwds.cals.Constants.UnitOfWork.CALSNS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.RFA1bCollectionServiceBackedResource;
import gov.ca.cwds.cals.inject.RFA1bServiceBackedResource;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.rfa.RFA1bFormCollectionDTO;
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
@Path(RFA_1A_FORMS + "/{" + RFA_1A_APPLICATION_ID + "}/" + RFA_1B_FORMS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RFA1bFormsResource {

  private ResourceDelegate resourceDelegate;
  private ResourceDelegate collectionResourceDelegate;

  @Inject
  public RFA1bFormsResource(
      @RFA1bServiceBackedResource ResourceDelegate resourceDelegate,
      @RFA1bCollectionServiceBackedResource
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
  @ApiOperation(value = "Creates and returns RFA 1B form", response = RFA1bFormDTO.class)
  public Response createRFA1bForm(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long applicationId,
      @ApiParam(required = true, name = RFA_1B_FORM, value = "The RFA-1b Form object")
          RFA1bFormDTO rfa1bForm) {
    return resourceDelegate.create(
        new RFAExternalEntityParameterObject<>(applicationId, rfa1bForm));
  }

  @UnitOfWork(CALSNS)
  @PUT
  @Path("/{" + RFA_1B_FORM_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Updates and returns RFA 1B Form object", response = RFA1bFormDTO.class)
  public Response updateRFA1bForm(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1a Application Id"
      )
          Long applicationId,
      @PathParam(RFA_1B_FORM_ID)
      @ApiParam(
          required = true,
          name = RFA_1B_FORM_ID,
          value = "The RFA-1a Form Id"
      )
          Long rfa1BId,
      @ApiParam(required = true, name = RFA_1B_FORM, value = "The RFA-1B Form object")
          RFA1bFormDTO rfa1bFormDTO) {
    return resourceDelegate.update(
        rfa1BId, new RFAExternalEntityParameterObject<>(applicationId, rfa1bFormDTO));
  }

  @UnitOfWork(CALSNS)
  @GET
  @Path("/{" + RFA_1B_FORM_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Returns RFA 1B Form by RFA 1A id and RFA 1B id", response = RFA1bFormDTO.class)
  public Response getRFA1BFormById(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1a Application Id"
      )
          Long applicationId,
      @PathParam(RFA_1B_FORM_ID)
      @ApiParam(
          required = true,
          name = RFA_1B_FORM_ID,
          value = "The RFA 1B Form Id"
      )
          Long rfa1BFormId) {

    return resourceDelegate
        .get(new RFAExternalEntityParameterObject<RFA1bFormDTO>(applicationId, rfa1BFormId));
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
      value = "Returns RFA 1B Forms by Application Id",
      response = RFA1bFormCollectionDTO.class
  )
  public Response getRFA1bFormsByFormRFA1aFormId(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(
          required = true,
          name = RFA_1A_APPLICATION_ID,
          value = "The RFA-1A Application Id"
      )
          Long applicationId) {
    return collectionResourceDelegate
        .get(new RFAExternalEntityParameterObject<RFA1bFormDTO>(applicationId));
  }

  @UnitOfWork(CALSNS)
  @DELETE
  @Path("/{" + RFA_1B_FORM_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found")
      }
  )
  @ApiOperation(value = "Deletes RFA 1B Form")
  public Response deleteRFA1bForm(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA 1A Form Id")
          Long applicationId,
      @PathParam(RFA_1B_FORM_ID)
      @ApiParam(
          required = true,
          name = RFA_1B_FORM_ID,
          value = "The RFA 1B Form Id"
      )
          Long rfa1BFormId) {
    return resourceDelegate.delete(
        new RFAExternalEntityParameterObject<RFA1bFormDTO>(applicationId, rfa1BFormId));
  }
}
