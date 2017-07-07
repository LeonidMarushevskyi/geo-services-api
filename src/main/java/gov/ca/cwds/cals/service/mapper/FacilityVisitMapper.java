package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.service.dto.FacilityVisitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static gov.ca.cwds.cals.Constants.VisitTypes.ANNUAL_10_MONTH;
import static gov.ca.cwds.cals.Constants.VisitTypes.ANNUAL_22_MONTH;
import static gov.ca.cwds.cals.Constants.VisitTypes.POST_LICENSING;
import static gov.ca.cwds.cals.Constants.VisitTypes.RENEWAL;
import static gov.ca.cwds.cals.Constants.VisitTypes.MIDDLE_YEAR;

/**
 * @author CWDS CALS API Team
 */
@Mapper
public interface FacilityVisitMapper {

    @Mapping(target = "visitType", constant = ANNUAL_10_MONTH)
    @Mapping(target = "approval", source = "facAnnual10MoVisitAppr")
    @Mapping(target = "visitDate", source = "facAnnual10MoVisitDate")
    @Mapping(target = "visitDeferredDate", source = "facAnnual10MoDeferDate")
    FacilityVisitDTO toAnnual10MonthFacilityVisitDTO(LisFacFile lisFacFile);

    @Mapping(target = "visitType", constant = ANNUAL_22_MONTH)
    @Mapping(target = "approval", source = "facAnnual22MoVisitAppr")
    @Mapping(target = "visitDate", source = "facAnnual22MoVisitDate")
    @Mapping(target = "visitDeferredDate", source = "facAnnual22MoDeferDate")
    FacilityVisitDTO toAnnual22MonthFacilityVisitDTO(LisFacFile lisFacFile);

    @Mapping(target = "visitType", constant = POST_LICENSING)
    @Mapping(target = "approval", source = "facPostLicVisitAppr")
    @Mapping(target = "visitDate", source = "facPostLicVisitDate")
    @Mapping(target = "visitDeferredDate", source = "facPostLicDeferDate")
    FacilityVisitDTO toPostLicensingFacilityVisitDTO(LisFacFile lisFacFile);

    @Mapping(target = "visitType", constant = RENEWAL)
    @Mapping(target = "approval", source = "facRenewalVisitAppr")
    @Mapping(target = "visitDate", source = "facRenewalVisitDate")
    @Mapping(target = "visitDeferredDate", source = "facRenewalDeferDate")
    FacilityVisitDTO toRenewalFacilityVisitDTO(LisFacFile lisFacFile);

    @Mapping(target = "visitType", constant = MIDDLE_YEAR)
    @Mapping(target = "approval", source = "facMidYrVisitAppr")
    @Mapping(target = "visitDate", source = "facMidYrVisitDate")
    @Mapping(target = "visitDeferredDate", source = "facMidYrDeferDate")
    FacilityVisitDTO toMiddleYearVisitDTO(LisFacFile lisFacFile);


}
