package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.CHILDREN;
import static gov.ca.cwds.cals.Constants.API.FACILITIES;
import static gov.ca.cwds.cals.Constants.API.PathParams.CHILD_ID;
import static gov.ca.cwds.cals.Constants.API.PathParams.FACILITY_ID;
import static gov.ca.cwds.cals.Constants.UnitOfWork.CMS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FacilityChildCollectionServiceBackedResource;
import gov.ca.cwds.cals.inject.FacilityChildServiceBackedResource;
import gov.ca.cwds.cals.service.dto.FacilityChildDTO;
import gov.ca.cwds.cals.service.dto.FacilityChildrenDTO;
import gov.ca.cwds.cals.web.rest.parameter.FacilityChildParameterObject;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author CWDS CALS API Team
 */
@Api(tags = {FACILITIES})
@Path(FACILITIES + "/{"+ FACILITY_ID + "}/" + CHILDREN)
@Produces(MediaType.APPLICATION_JSON)
public class FacilityChildResource {
    private ResourceDelegate resourceDelegate;
    private ResourceDelegate collectionResourceDelegate;

    @Inject
    public FacilityChildResource(
        @FacilityChildServiceBackedResource ResourceDelegate resourceDelegate,
        @FacilityChildCollectionServiceBackedResource ResourceDelegate collectionResourceDelegate) {
        this.resourceDelegate = resourceDelegate;
        this.collectionResourceDelegate = collectionResourceDelegate;
    }

    @UnitOfWork(value = CMS)
    @GET
    @Timed
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 406, message = "Accept Header not supported")})
    @ApiOperation(value = "Returns Children collection by Facility Id", response = FacilityChildrenDTO.class)
    public Response getChildren(@PathParam(FACILITY_ID)  @ApiParam(required = true, name = FACILITY_ID,
            value = "The license number of the Placement Home") String facilityLicenseNumber) {
        return collectionResourceDelegate.get(new FacilityChildParameterObject(facilityLicenseNumber));
    }

    @UnitOfWork(value = CMS)
    @GET
    @Timed
    @Path("/{" + CHILD_ID + "}")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 406, message = "Accept Header not supported")})
    @ApiOperation(value = "Returns Child by Facility Id and Child Id", response = FacilityChildDTO.class)
    public Response getChild(@PathParam(FACILITY_ID)  @ApiParam(required = true, name = FACILITY_ID, value = "The license number of the Placement Home") String facilityLicenseNumber,
            @PathParam(CHILD_ID) @ApiParam(required = true, name = CHILD_ID, value = "The id of the Client") String childId) {
        return resourceDelegate.get(new FacilityChildParameterObject(facilityLicenseNumber, childId));
    }
}
