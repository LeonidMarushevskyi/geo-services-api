package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.FACILITIES;
import static gov.ca.cwds.cals.Constants.API.PathParams.FACILITY_ID;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.Utils;
import gov.ca.cwds.cals.inject.FacilityServiceBackedResource;
import gov.ca.cwds.cals.service.dto.FacilityDTO;
import gov.ca.cwds.cals.web.rest.parameter.FacilityParameterObject;
import gov.ca.cwds.rest.resources.ResourceDelegate;
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
 *  @author CALS API Team
 *
 */

@Api(value = FACILITIES, tags = FACILITIES)
@Path(FACILITIES)
@Produces(MediaType.APPLICATION_JSON)
public class FacilityResource {

    private ResourceDelegate resourceDelegate;

    @Inject
    public FacilityResource(@FacilityServiceBackedResource ResourceDelegate resourceDelegate) {
        this.resourceDelegate = resourceDelegate;
    }

    @GET
    @Timed
    @Path("/{" + FACILITY_ID + "}")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 406, message = "Accept Header not supported")})
    @ApiOperation(value = "Returns Facility by Id", response = FacilityDTO.class)
    public Response getFacilityById(@PathParam(FACILITY_ID) @ApiParam(required = true, name = FACILITY_ID,
            value = "Currently it's PLC_HM_T.IDENTIFIER for CWSCMS or lis_fac_file.fac_nbr for LIS") String facilityNumber) {

        FacilityParameterObject parameterObject = Utils.createFacilityParameterObject(facilityNumber);
        return resourceDelegate.get(parameterObject);
    }
}
