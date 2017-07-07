package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.service.dto.PhoneDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static gov.ca.cwds.cals.Constants.PhoneTypes.ALTERNATE;
import static gov.ca.cwds.cals.Constants.PhoneTypes.PRIMARY;

/**
 * @author CWDS CALS API Team
 */

@Mapper(uses = TrailingSpacesRemovalPostMappingProcessor.class)
@DecoratedWith(PhoneMapperDecorator.class)
public interface PhoneMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "relation", constant = PRIMARY)
    @Mapping(target = "type", constant = "Cell")
    @Mapping(target = "number", source = "facPhoneNbr")
    PhoneDTO lisFacilityToPhoneDTO(LisFacFile lisFacFile);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "relation", constant = PRIMARY)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "number", source = "prmTelNo")
    PhoneDTO toPrimaryPhoneDTO(BasePlacementHome placementHome);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "relation", constant = ALTERNATE)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "number", source = "bckTelNo")
    PhoneDTO toAlternatePhoneDTO(BasePlacementHome placementHome);

}
