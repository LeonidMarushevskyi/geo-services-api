package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.service.dto.FacilityAddressDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * @author CWDS CALS API Team
 */
public abstract class FacilityAddressMapperDecorator implements FacilityAddressMapper {
    private FacilityAddressMapper delegate;

    public FacilityAddressMapperDecorator(FacilityAddressMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public FacilityAddressDTO toResidentialAddress(BasePlacementHome placementHome) {
        FacilityAddressDTO facilityAddressDTO = null;

        Integer zipCode = placementHome.getZipNo();
        Short zipSuffix = placementHome.getZipSfxNo();
        if (StringUtils.isNoneBlank(placementHome.getStreetNo(), placementHome.getStreetNm(), placementHome.getCityNm())
                || zipCode > 0
                || zipSuffix > 0) {
            facilityAddressDTO = delegate.toResidentialAddress(placementHome);
        }
        return facilityAddressDTO;
    }

    @Override
    public FacilityAddressDTO toMailAddress(BasePlacementHome placementHome) {
        FacilityAddressDTO facilityAddressDTO = null;

        Integer zipCode = placementHome.getpZipNo();
        Short zipSuffix = placementHome.getPyZipSfx();
        if (StringUtils.isNoneBlank(placementHome.getPstreetNo(), placementHome.getPstreetNm(), placementHome.getpCityNm())
                || zipCode > 0
                || zipSuffix > 0) {
            facilityAddressDTO = delegate.toMailAddress(placementHome);
        }
        return facilityAddressDTO;
    }

}
