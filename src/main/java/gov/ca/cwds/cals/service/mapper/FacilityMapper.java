package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.persistence.model.cms.BaseCountyLicenseCase;
import gov.ca.cwds.cals.persistence.model.cms.BaseLicensingVisit;
import gov.ca.cwds.cals.persistence.model.cms.BasePlacementHome;
import gov.ca.cwds.cals.persistence.model.fas.LpaInformation;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.service.dto.ExpandedFacilityDTO;
import gov.ca.cwds.cals.service.dto.FacilityAddressDTO;
import gov.ca.cwds.cals.service.dto.FacilityChildDTO;
import gov.ca.cwds.cals.service.dto.FacilityDTO;
import gov.ca.cwds.cals.service.dto.HyperlinkDTO;
import gov.ca.cwds.cals.service.dto.PhoneDTO;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author CWDS CALS API Team
 */
@Mapper(imports = {Constants.class, HyperlinkDTO.class},
        uses={FacilityPostMappingProcessor.class, FacilityTypeMapper.class, CountyMapper.class,
              DistrictOfficeMapper.class, DictionaryMapper.class, TrailingSpacesRemovalPostMappingProcessor.class} )
public interface FacilityMapper {

    /**
     * Visit data is converted in {@link FasFacilityMapper}
     *
     * @param lisFacFile param to convert
     * @param lpaInformation param to convert
     * @return converted data
     */

    @Mapping(target = "lastVisitDate", ignore = true)
    @Mapping(target = "lastDeferredVisitDate", ignore = true)
    @Mapping(target = "lastVisitReason", ignore = true)
    @Mapping(target = "lastDeferredVisitReason", ignore = true)
    @Mapping(target = "inspections", ignore = true)
    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "annualVisitYear", ignore = true)
    @Mapping(target = "prelicensingVisitDate", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "href", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(source = "lisFacFile.facNbr", target = "id")
    @Mapping(source = "lisFacFile.facType.tblFacTypeCode", target = "type.code")
    @Mapping(source = "lisFacFile.facType.tblFacTypeDesc", target = "type.description")
    @Mapping(source = "lisFacFile.facName", target = "name")
    @Mapping(source = "lisFacFile.facLicenseeName", target = "licenseeName")
    @Mapping(source = "lisFacFile.facLicenseeType", target = "licenseeType")
    @Mapping(source = "lpaInformation.lpaCode", target = "assignedWorker.code")
    @Mapping(source = "lpaInformation.fullLpaName", target = "assignedWorker.description")
    @Mapping(source = "lisFacFile.facDoNbr.doNbr", target = "districtOffice.number")
    @Mapping(source = "lisFacFile.facDoNbr.doName", target = "districtOffice.name")
    @Mapping(source = "lisFacFile.facNbr", target = "licenseNumber")
    @Mapping(source = "lisFacFile.facStatus.tblFacStatusCode", target = "status.code")
    @Mapping(source = "lisFacFile.facStatus.tblFacStatusDesc", target = "status.description")
    @Mapping(source = "lisFacFile.facCapacity", target = "capacity")
    @Mapping(source = "lisFacFile.facLicEffDate", target = "licenseEffectiveDate")
    @Mapping(source = "lisFacFile.facOrigApplRecDate", target = "originalApplicationRecievedDate")
    @Mapping(source = "lisFacFile.facEmailAddress", target = "emailAddress")
    @Mapping(source = "lisFacFile.facCoNbr.tblCoNbr", target = "county.code")
    @Mapping(source = "lisFacFile.facCoNbr.tblCoDesc", target = "county.description")
    @Mapping(target = "complains", expression = "java(new HyperlinkDTO( String.format(Constants.API.FACILITIES + " +
        "\"/%s/\" + Constants.API.COMPLAINTS, lisFacFile.getFacNbr())))")
    FacilityDTO toFacilityDTO(LisFacFile lisFacFile, LpaInformation lpaInformation);

    @Mapping(target = "prelicensingVisitDate", ignore = true)
    @Mapping(target = "annualVisitYear", ignore = true)
    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "inspections", ignore = true)
    @Mapping(target = "lastDeferredVisitReason", ignore = true)
    @Mapping(target = "lastDeferredVisitDate", ignore = true)
    @Mapping(target = "id", source = "identifier")
    @Mapping(target = "name", source = "facltyNm")
    @Mapping(target = "type", source = "facilityType")
    @Mapping(target = "licenseeName", source = "licnseeNm")
    @Mapping(target = "assignedWorker", source = "countyLicenseCase.staffPerson")
    @Mapping(target = "districtOffice", source = "countyLicenseCase.staffPerson.county")
    @Mapping(target = "licenseNumber", source = "licenseNo")
    @Mapping(target = "status", source = "licenseStatus")
    @Mapping(target = "capacity", source = "maxCapNo")
    @Mapping(target = "licenseEffectiveDate", source = "licEfctdt")
    @Mapping(target = "originalApplicationRecievedDate", source = "licAplDt")
    @Mapping(target = "county", source = "county")
    @Mapping(target = "lastVisitDate", ignore = true)
    @Mapping(target = "lastVisitReason", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "href", ignore = true)
    @Mapping(target = "licenseeType", ignore = true)
    @Mapping(target = "complains", expression = "java(new HyperlinkDTO( String.format(Constants.API.FACILITIES + " +
        "\"/%s/\" + Constants.API.COMPLAINTS, placementHome.getIdentifier())))")
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "emailAddress", ignore = true)
    FacilityDTO toFacilityDTO(BasePlacementHome placementHome);

    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "prelicensingVisitDate", ignore = true)
    @Mapping(target = "annualVisitYear", ignore = true)
    @Mapping(target = "visits", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "inspections", ignore = true)
    @Mapping(target = "complains", ignore = true)
    @Mapping(target = "county", ignore = true)
    @Mapping(target = "lastDeferredVisitReason", ignore = true)
    @Mapping(target = "emailAddress", ignore = true)
    @Mapping(target = "lastDeferredVisitDate", ignore = true)
    @Mapping(target = "originalApplicationRecievedDate", ignore = true)
    @Mapping(target = "licenseEffectiveDate", ignore = true)
    @Mapping(target = "capacity", ignore = true)
    @Mapping(target = "licenseNumber", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "districtOffice", ignore = true)
    @Mapping(target = "assignedWorker", ignore = true)
    @Mapping(target = "licenseeType", ignore = true)
    @Mapping(target = "licenseeName", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "href", ignore = true)
    @Mapping(target = "lastVisitDate", source = "visitDate")
    @Mapping(target = "lastVisitReason.description", source = "visitType.shortDsc")
    void toFacilityDTO(@MappingTarget FacilityDTO facilityDTO, BaseLicensingVisit licensingVisit);

    ExpandedFacilityDTO toExpandedFacilityDTO(FacilityDTO facilityDTO, List<FacilityChildDTO> children);

    @AfterMapping
    default void after(@MappingTarget FacilityDTO facilityDTO, BasePlacementHome placementHome) {
        afterAddresses(facilityDTO, placementHome);
        afterPhones(facilityDTO, placementHome);
        afterLastVisit(facilityDTO, placementHome.getCountyLicenseCase());
    }

    default void afterLastVisit(@MappingTarget FacilityDTO facilityDTO, BaseCountyLicenseCase countyLicenseCase) {
        if (countyLicenseCase != null && CollectionUtils.isNotEmpty(countyLicenseCase.getLicensingVisits())) {
            List<? extends BaseLicensingVisit> licensingVisits = countyLicenseCase.getLicensingVisits();
            Mappers.getMapper(FacilityMapper.class).toFacilityDTO(
                    facilityDTO, licensingVisits.get(0));
        }
    }

    default void afterAddresses(@MappingTarget FacilityDTO facilityDTO, BasePlacementHome placementHome) {
        List<FacilityAddressDTO> facilityAddressDTOs = new ArrayList<>(2);

        FacilityAddressMapper facilityAddressMapper = Mappers.getMapper(FacilityAddressMapper.class);

        FacilityAddressDTO residentialAddress = facilityAddressMapper.toResidentialAddress(placementHome);
        if (residentialAddress != null) {
            facilityAddressDTOs.add(residentialAddress);
        }

        FacilityAddressDTO mailingAddress = facilityAddressMapper.toMailAddress(placementHome);
        if (mailingAddress != null) {
            facilityAddressDTOs.add(mailingAddress);
        }
        facilityDTO.setAddress(facilityAddressDTOs);
    }

    default void afterPhones(@MappingTarget FacilityDTO facilityDTO, BasePlacementHome placementHome) {
        List<PhoneDTO> phoneDTOs = new ArrayList<>(2);

        PhoneMapper phoneMapper = Mappers.getMapper(PhoneMapper.class);

        PhoneDTO primaryPhone = phoneMapper.toPrimaryPhoneDTO(placementHome);
        if (primaryPhone != null) {
            phoneDTOs.add(primaryPhone);
        }

        PhoneDTO alternativePhone = phoneMapper.toAlternatePhoneDTO(placementHome);
        if (alternativePhone != null) {
            phoneDTOs.add(alternativePhone);
        }
        facilityDTO.setPhone(phoneDTOs);
    }
}
