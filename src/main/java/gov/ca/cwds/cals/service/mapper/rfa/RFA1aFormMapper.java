package gov.ca.cwds.cals.service.mapper.rfa;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aForm;
import gov.ca.cwds.cals.service.dto.rfa.RFA1aFormDTO;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author CWDS CALS API Team.
 */
@Mapper
public interface RFA1aFormMapper {

  @Mapping(target = "initialApplication", source = "application.initialApplication")
  @Mapping(target = "otherType", source = "application.otherType")
  @Mapping(target = "otherTypeDescription", source = "application.otherTypeDescription")
  @Mapping(target = "applicationCounty", source = "application.applicationCounty")
  RFA1aFormDTO toRFA1aFormDTO(RFA1aForm form);

  List<RFA1aFormDTO> toRFA1aFormsDTO(List<RFA1aForm> forms);

  @Mapping(target = "applicantsDeclaration", ignore = true)
  @Mapping(target = "references", ignore = true)
  @Mapping(target = "applicantsHistory", ignore = true)
  @Mapping(target = "adoptionHistory", ignore = true)
  @Mapping(target = "applicantEntities", ignore = true)
  @Mapping(target = "relationships", ignore = true)
  @Mapping(target = "residence", ignore = true)
  @Mapping(target = "childDesired", ignore = true)
  @Mapping(target = "updateDateTime", ignore = true)
  @Mapping(target = "updateUserId", ignore = true)
  @Mapping(target = "createDateTime", ignore = true)
  @Mapping(target = "createUserId", ignore = true)
  @Mapping(target = "id", ignore = true)
  @InheritInverseConfiguration
  void toRFA1aForm(@MappingTarget RFA1aForm rfa1aForm, RFA1aFormDTO formDTO);

}
