package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.service.dto.FacilityAddressDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static gov.ca.cwds.cals.Constants.AddressTypes.MAIL;
import static gov.ca.cwds.cals.Constants.AddressTypes.RESIDENTIAL;

/**
 * @author CWDS CALS API Team
 */
@Mapper(uses = {AddressMapper.class, TrailingSpacesRemovalPostMappingProcessor.class})
@DecoratedWith(FacilityAddressMapperDecorator.class)
public interface FacilityAddressMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", constant = RESIDENTIAL)
    @Mapping(target = "address", source = "placementHome", qualifiedByName = RESIDENTIAL)
    FacilityAddressDTO toResidentialAddress(BasePlacementHome placementHome);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", constant = MAIL)
    @Mapping(target = "address", source = "placementHome", qualifiedByName = MAIL)
    FacilityAddressDTO toMailAddress(BasePlacementHome placementHome);

}
