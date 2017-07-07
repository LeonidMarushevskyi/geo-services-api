package gov.ca.cwds.cals.service.mapper;

import static gov.ca.cwds.cals.Constants.AddressTypes.MAIL;
import static gov.ca.cwds.cals.Constants.AddressTypes.RESIDENTIAL;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.service.dto.AddressDTO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * @author CWDS CALS API Team
 */
@Mapper(
    imports = StringUtils.class,
    uses = TrailingSpacesRemovalPostMappingProcessor.class
)
public interface AddressMapper {

    @Named(RESIDENTIAL)
    @Mapping(target = "streetAddress", expression = "java(StringUtils.trimToEmpty(placementHome.getStreetNo()) + ' ' + placementHome.getStreetNm())")
    @Mapping(target = "city", source = "cityNm")
    @Mapping(target = "state", source = "stateCode.lgcId")
    @Mapping(target = "zipCode", source = "zipNo")
    @Mapping(target = "zipSuffixCode", source = "zipSfxNo")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    @Mapping(target = "lattitude", ignore = true)
    @Mapping(target = "deliverable", ignore = true)
    AddressDTO toResidentialAddressDTO(BasePlacementHome placementHome);

    @Named(MAIL)
    @Mapping(target = "streetAddress", expression = "java(StringUtils.trimToEmpty(placementHome.getPstreetNo()) + ' ' + placementHome.getPstreetNm())")
    @Mapping(target = "city", source = "pCityNm")
    @Mapping(target = "state", source = "payeeStateCode.lgcId")
    @Mapping(target = "zipCode", source = "pZipNo")
    @Mapping(target = "zipSuffixCode", source = "pyZipSfx")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    @Mapping(target = "lattitude", ignore = true)
    @Mapping(target = "deliverable", ignore = true)
    AddressDTO toMailAddressDTO(BasePlacementHome placementHome);
}

