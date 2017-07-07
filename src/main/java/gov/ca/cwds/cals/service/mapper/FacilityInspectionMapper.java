package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.service.dto.FacilityDeficiencyDTO;
import gov.ca.cwds.cals.service.dto.FacilityInspectionDTO;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author CWDS CALS API Team
 */
@Mapper(uses = {TrailingSpacesRemovalPostMappingProcessor.class})
public interface FacilityInspectionMapper {

    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "deficiencies", ignore = true)
    @Mapping(target = "id", source = "originalunidkey")
    @Mapping(target = "href", ignore = true)
    @Mapping(target = "representativeSignatureDate", source = "dateSigned")
    FacilityInspectionDTO toFacilityInspectionDto(Rr809Dn rr809Dn);

    @Mapping(target = "deficiencyType",     source = "deftype1")
    @Mapping(target = "pocDate",            source = "pocDate")
    @Mapping(target = "facSectionViolated", source = "facSectionviolated")
    @Mapping(target = "deficiency",         expression = "java( concat(rr809Dn.getDeficiency1(), rr809Dn.getDeficiency1Cont()) )")
    @Mapping(target = "correctionPlan",     expression = "java( concat(rr809Dn.getCorrectionPlan(), rr809Dn.getCorrectionPlanCont()) )")
    // rrcpoc
    @Mapping(target = "pocDateCleared",     source = "rrcpoc.pocDatecleared")
    @Mapping(target = "pocComment",         expression = "java(" +
            "rr809Dn.getRrcpoc() != null ? " +
            "concat(rr809Dn.getRrcpoc().getPocComments(),rr809Dn.getRrcpoc().getPocCommentsCont()) : null)")
    FacilityDeficiencyDTO toPlanOfCorrectionDTO(Rr809Dn rr809Dn);

    @Mapping(target = "deficiencyType",     source = "deftype2Ab")
    @Mapping(target = "pocDate",            source = "pocDate1")
    @Mapping(target = "facSectionViolated", source = "facSectionviolated1")
    @Mapping(target = "deficiency",         expression = "java(concat(rr809Dn.getDeficiency11(), rr809Dn.getDeficiency2Cont()) )")
    @Mapping(target = "correctionPlan",     expression = "java(concat(rr809Dn.getCorrectionPlan1(), rr809Dn.getCorrectionPlan2Cont()) )")
    // rrcpoc
    @Mapping(target = "pocDateCleared",     source = "rrcpoc.pocDatecleared1")
    @Mapping(target = "pocComment",         expression = "java(" +
            "rr809Dn.getRrcpoc() != null ? " +
            "concat(rr809Dn.getRrcpoc().getPocComments1(), rr809Dn.getRrcpoc().getPocCommentsCont1()) : null)")
    FacilityDeficiencyDTO toPlanOfCorrectionDTO1(Rr809Dn rr809Dn);

    @Mapping(target = "deficiencyType",     source = "deftype3Ab")
    @Mapping(target = "pocDate",            source = "pocDate2")
    @Mapping(target = "facSectionViolated", source = "facSectionviolated2")
    @Mapping(target = "deficiency",         expression = "java( concat(rr809Dn.getDeficiency12(), rr809Dn.getDeficiency3Cont()) )")
    @Mapping(target = "correctionPlan",     expression = "java( concat(rr809Dn.getCorrectionPlan2(), rr809Dn.getCorrectionPlan3Cont()) )")
    // rrcpoc
    @Mapping(target = "pocDateCleared",     source = "rrcpoc.pocDatecleared2")
    @Mapping(target = "pocComment",         expression = "java(" +
            "rr809Dn.getRrcpoc() != null ? " +
            "concat(rr809Dn.getRrcpoc().getPocComments2(), rr809Dn.getRrcpoc().getPocCommentsCont3Cont()) : null)")
    FacilityDeficiencyDTO toPlanOfCorrectionDTO2(Rr809Dn rr809Dn);

    @Mapping(target = "deficiencyType",     source = "deftype4Ab")
    @Mapping(target = "pocDate",            source = "pocDate3")
    @Mapping(target = "facSectionViolated", source = "facSectionviolated3")
    @Mapping(target = "deficiency",         source = "deficiency13")
    @Mapping(target = "correctionPlan",     source = "correctionPlan3")
    // rrcpoc
    @Mapping(target = "pocDateCleared",     source = "rrcpoc.pocDatecleared3")
    @Mapping(target = "pocComment",         source = "rr809Dn.rrcpoc.pocComments3")
    FacilityDeficiencyDTO toPlanOfCorrectionDTO3(Rr809Dn rr809Dn);

    @AfterMapping
    default void fillPlanOfCorrectionDTOs(
            @MappingTarget FacilityInspectionDTO facilityInspectionDTO, Rr809Dn rr809Dn) {

        List<FacilityDeficiencyDTO> defs = facilityInspectionDTO.getDeficiencies();
        facilityInspectionDTO.setDeficiencies(defs);
        if (StringUtils.isNotEmpty(rr809Dn.getFacSectionviolated())) {
            defs.add(toPlanOfCorrectionDTO(rr809Dn));
        }
        if (StringUtils.isNotEmpty(rr809Dn.getFacSectionviolated1())) {
            defs.add(toPlanOfCorrectionDTO1(rr809Dn));
        }
        if (StringUtils.isNotEmpty(rr809Dn.getFacSectionviolated2())) {
            defs.add(toPlanOfCorrectionDTO2(rr809Dn));
        }
        if (StringUtils.isNotEmpty(rr809Dn.getFacSectionviolated3())) {
            defs.add(toPlanOfCorrectionDTO3(rr809Dn));
        }


        StringBuilder hrefSb = new StringBuilder();
        hrefSb.append('/').append(Constants.API.FACILITIES)
                .append('/').append(rr809Dn.getFacilityNumberText())
                .append('/').append(Constants.API.INSPECTIONS)
                .append('/').append(facilityInspectionDTO.getId());

        facilityInspectionDTO.setHref(hrefSb.toString());
    }

    default String concat(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (string != null && !string.isEmpty()) {
                sb.append(' ').append(string);
            }
        }
        String res = sb.toString().trim();
        return res.isEmpty() ? null : res;
    }

}
