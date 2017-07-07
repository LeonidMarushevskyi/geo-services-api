package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.service.dto.FacilityAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS CALS API Team
 */

@FunctionalInterface
@Mapper(uses = TrailingSpacesRemovalPostMappingProcessor.class)
public interface MailAddressMapper {

    @Mapping(source = "facMailStreetAddr", target = "address.streetAddress")
    @Mapping(source = "facMailCity", target = "address.city")
    @Mapping(source = "facMailState", target = "address.state")
    @Mapping(source = "facMailZipCode", target = "address.zipCode")
    @Mapping(constant = Constants.AddressTypes.MAIL, target = "type")
    @Mapping(target = "id", ignore = true)
    FacilityAddressDTO lisFacilityToFacilityAddressDTO(LisFacFile lisFacFile);

}
