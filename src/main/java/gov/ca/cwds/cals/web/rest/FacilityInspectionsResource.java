package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.FACILITIES;
import static gov.ca.cwds.cals.Constants.API.INSPECTIONS;
import static gov.ca.cwds.cals.Constants.API.PathParams.FACILITY_ID;
import static gov.ca.cwds.cals.Constants.API.PathParams.INSPECTION_ID;
import static gov.ca.cwds.cals.Constants.UnitOfWork.FAS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FacilityInspectionCollectionServiceBackedResource;
import gov.ca.cwds.cals.inject.FacilityInspectionServiceBackedResource;
import gov.ca.cwds.cals.service.dto.FacilityInspectionDTO;
import gov.ca.cwds.cals.service.dto.FacilityInspectionsDTO;
import gov.ca.cwds.cals.web.rest.parameter.FacilityInspectionParameterObject;
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
@Path(FACILITIES + "/{"+ FACILITY_ID + "}/" + INSPECTIONS)
@Produces(MediaType.APPLICATION_JSON)
public class FacilityInspectionsResource {

    private ResourceDelegate resourceDelegate;
    private ResourceDelegate collectionResourceDelegate;

    @Inject
    public FacilityInspectionsResource(
        @FacilityInspectionServiceBackedResource ResourceDelegate resourceDelegate,
        @FacilityInspectionCollectionServiceBackedResource ResourceDelegate collectionResourceDelegate) {
        this.resourceDelegate = resourceDelegate;
        this.collectionResourceDelegate = collectionResourceDelegate;
    }

    @UnitOfWork(value = FAS)
    @GET
    @Timed
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found")})
    @ApiOperation(value = "Returns collection of Inspections by Facility Id",
            response = FacilityInspectionsDTO.class)
    public Response getFacilityInspections(
                        @PathParam(FACILITY_ID)
                        @ApiParam(required = true, name = FACILITY_ID, value = "The id of the Facility")
                        Integer facilityId){

        return collectionResourceDelegate.get(facilityId);
    }

    @UnitOfWork(value = FAS)
    @GET
    @Timed
    @Path("/{" + INSPECTION_ID + "}")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found")})
    @ApiOperation(value = "Returns Inspection by Facility Id and Inspection Id",
            response = FacilityInspectionDTO.class)
    public Response getFacilityInspectionById(
                        @PathParam(FACILITY_ID)
                        @ApiParam(required = true, name = FACILITY_ID, value = "The id of the Facility")
                        Integer facilityId,

                        @PathParam(INSPECTION_ID)
                        @ApiParam(required = true, name = INSPECTION_ID, value = "The id of the Inspection")
                        String inspectionId) {

        return resourceDelegate.get(new FacilityInspectionParameterObject(facilityId, inspectionId));
    }

}
