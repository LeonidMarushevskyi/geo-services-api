package gov.ca.cwds.cals.web.rest;

import static gov.ca.cwds.cals.Constants.API.DICTIONARIES;
import static gov.ca.cwds.cals.Constants.API.FACILITY_TYPES;
import static gov.ca.cwds.cals.Constants.UnitOfWork.LIS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FacilityTypeCollectionServiceBackedResource;
import gov.ca.cwds.cals.service.dto.FacilityTypesDTO;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author CWDS CALS API Team
 */
@Api(value = FACILITY_TYPES, tags = {DICTIONARIES})
@Path(DICTIONARIES + "/" + FACILITY_TYPES)
@Produces(MediaType.APPLICATION_JSON)
public class FacilityTypeResource {
    private ResourceDelegate collectionResourceDelegate;

    @Inject
    public FacilityTypeResource(
        @FacilityTypeCollectionServiceBackedResource ResourceDelegate collectionResourceDelegate) {
        this.collectionResourceDelegate = collectionResourceDelegate;
    }

    @UnitOfWork(LIS)
    @GET
    @Timed
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 406, message = "Accept Header not supported")})
    @ApiOperation(value = "Returns Facility Types", response = FacilityTypesDTO.class)
    public Response getFacilityTypes() {
        return collectionResourceDelegate.get(null);
    }
}
