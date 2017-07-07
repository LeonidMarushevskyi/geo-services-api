package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.cals.service.dto.CountyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS CALS API Team
 */
@FunctionalInterface
@Mapper(uses = TrailingSpacesRemovalPostMappingProcessor.class)
public interface CountyMapper {

    @Mapping(target = "code", source = "lgcId")
    @Mapping(target = "description", source = "shortDsc")
    @Mapping(target = "lisCode", ignore = true)
    CountyDTO toCountyDTO(County county);

}
