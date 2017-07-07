package gov.ca.cwds.cals.web.rest.rfa;

import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_APPLICANT;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_APPLICANT_ID;
import static gov.ca.cwds.cals.Constants.API.PathParams.RFA_1A_APPLICATION_ID;
import static gov.ca.cwds.cals.Constants.API.RFA_1A_APPLICANTS;
import static gov.ca.cwds.cals.Constants.API.RFA_1A_FORMS;
import static gov.ca.cwds.cals.Constants.RFA;
import static gov.ca.cwds.cals.Constants.UnitOfWork.CALSNS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.RFA1aApplicantServiceBackedResource;
import gov.ca.cwds.cals.inject.RFA1aApplicantsCollectionServiceBackedResource;
import gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantDTO;
import gov.ca.cwds.cals.service.dto.rfa.ApplicantCollectionDTO;
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
@Path(RFA_1A_FORMS + "/{" + RFA_1A_APPLICATION_ID + "}/" + RFA_1A_APPLICANTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RFA1aApplicantsResource {

  private ResourceDelegate resourceDelegate;
  private ResourceDelegate collectionResourceDelegate;

  @Inject
  public RFA1aApplicantsResource(
      @RFA1aApplicantServiceBackedResource ResourceDelegate resourceDelegate,
      @RFA1aApplicantsCollectionServiceBackedResource
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
  @ApiOperation(value = "Creates and returns RFA 1a Applicant", response = ApplicantDTO.class)
  public Response createApplicant(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long formId,
      @ApiParam(required = true, name = RFA_1A_APPLICANT, value = "The RFA-1a Applicant object")
          ApplicantDTO applicant) {
    return resourceDelegate.create(new RFAExternalEntityParameterObject<>(formId, applicant));
  }

  @UnitOfWork(CALSNS)
  @PUT
  @Path("/{" + RFA_1A_APPLICANT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Update and returns RFA 1a Applicant", response = ApplicantDTO.class)
  public Response updateApplicant(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long formId,
      @PathParam(RFA_1A_APPLICANT_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICANT_ID, value = "The RFA-1a Applicant Id")
          Long applicantId,
      @ApiParam(required = true, name = RFA_1A_APPLICANT, value = "The RFA-1a Applicant object")
          ApplicantDTO applicant) {
    return resourceDelegate.update(
        applicantId, new RFAExternalEntityParameterObject<>(formId, applicant));
  }

  @UnitOfWork(CALSNS)
  @GET
  @Path("/{" + RFA_1A_APPLICANT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 406, message = "Accept Header not supported")
      }
  )
  @ApiOperation(value = "Returns RFA 1a Form's Applicant by Id", response = ApplicantDTO.class)
  public Response getApplicantById(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long formId,
      @PathParam(RFA_1A_APPLICANT_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICANT_ID, value = "The RFA-1a Applicant Id")
          Long applicantId) {

    return resourceDelegate
        .get(new RFAExternalEntityParameterObject<ApplicantDTO>(formId, applicantId));
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
      value = "Returns RFA 1a Form's Applicants by Form Id",
      response = ApplicantCollectionDTO.class
  )
  public Response getApplicantsByFormId(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long formId) {
    return collectionResourceDelegate
        .get(new RFAExternalEntityParameterObject<ApplicantDTO>(formId));
  }

  @UnitOfWork(CALSNS)
  @DELETE
  @Path("/{" + RFA_1A_APPLICANT_ID + "}")
  @Timed
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authorized"),
          @ApiResponse(code = 404, message = "Not found")
      }
  )
  @ApiOperation(value = "Delete RFA 1a Form's Applicant by Id")
  public Response deleteApplicant(
      @PathParam(RFA_1A_APPLICATION_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICATION_ID, value = "The RFA-1a Form Id")
          Long formId,
      @PathParam(RFA_1A_APPLICANT_ID)
      @ApiParam(required = true, name = RFA_1A_APPLICANT_ID, value = "The RFA-1a Applicant Id")
          Long applicantId) {
    return resourceDelegate
        .delete(new RFAExternalEntityParameterObject<ApplicantDTO>(formId, applicantId));
  }
}
