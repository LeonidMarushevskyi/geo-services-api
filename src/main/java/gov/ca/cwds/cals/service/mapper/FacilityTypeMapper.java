package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.FacilityType;
import gov.ca.cwds.cals.service.dto.FacilityTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author CWDS CALS API Team
 */
@Mapper(uses = TrailingSpacesRemovalPostMappingProcessor.class)
public interface FacilityTypeMapper {

    List<FacilityTypeDTO> toFacilityTypeDTO(List<gov.ca.cwds.cals.persistence.model.lisfas.FacilityType> facilityTypes);

    @Mapping(target = "code", source = "tblFacTypeCode")
    @Mapping(target = "description", source = "tblFacTypeDesc")
    FacilityTypeDTO toFacilityTypeDTO(gov.ca.cwds.cals.persistence.model.lisfas.FacilityType facilityType);

    @Mapping(target = "code", source = "lgcId")
    @Mapping(target = "description", source = "shortDsc")
    FacilityTypeDTO toFacilityTypeDTO(FacilityType facilityType);

}
