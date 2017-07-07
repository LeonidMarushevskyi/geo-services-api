package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.cms.BaseClient;
import gov.ca.cwds.cals.persistence.model.cms.BaseStaffPerson;
import gov.ca.cwds.cals.service.dto.PersonDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

/**
 * @author CWDS CALS API Team
 */
@Mapper(uses = TrailingSpacesRemovalPostMappingProcessor.class)
public interface PersonMapper {

    List<PersonDTO> toPerson(Set<BaseClient> clients);

    @Mapping(target = "firstName", source = "comFstNm")
    @Mapping(target = "lastName", source = "comLstNm")
    @Mapping(target = "gender", source = "genderCd")
    @Mapping(target = "dateOfBirth", source = "birthDt")

    @Mapping(target = "id",          ignore = true)
    @Mapping(target = "age",         ignore = true)
    @Mapping(target = "ssn",         ignore = true)
    @Mapping(target = "ethnicityId", ignore = true)
    PersonDTO toPerson(BaseClient client);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "id",          ignore = true)
    @Mapping(target = "gender",      ignore = true)
    @Mapping(target = "age",         ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    @Mapping(target = "ssn",         ignore = true)
    @Mapping(target = "ethnicityId", ignore = true)
    PersonDTO toPersonDTO(BaseStaffPerson staffPerson);

    @AfterMapping
    default void fillAge(@MappingTarget PersonDTO personDTO) {
        LocalDate dateOfBirth = personDTO.getDateOfBirth();
        if (dateOfBirth != null) {
            Period period = Period.between(dateOfBirth, LocalDate.now());
            personDTO.setAge(period.getYears());
        }
    }
}
