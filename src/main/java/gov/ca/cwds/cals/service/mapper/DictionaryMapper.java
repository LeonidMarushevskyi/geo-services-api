package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.BaseStaffPerson;
import gov.ca.cwds.cals.persistence.model.cms.LicenseStatus;
import gov.ca.cwds.cals.service.dto.DictionaryDTO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS CALS API Team
 */
@Mapper(
    imports = StringUtils.class,
    uses = TrailingSpacesRemovalPostMappingProcessor.class
)
public interface DictionaryMapper {

  @Mapping(target = "description", expression = "java(StringUtils.trimToEmpty(staffPerson.getFirstName()) + ' ' + staffPerson.getLastName())")
    @Mapping(target = "code", ignore = true)
    DictionaryDTO toDictionary(BaseStaffPerson staffPerson);

    @Mapping(target = "code", source = "lgcId")
    @Mapping(target = "description", source = "shortDsc")
    DictionaryDTO toDictionary(LicenseStatus licenseStatus);
}
