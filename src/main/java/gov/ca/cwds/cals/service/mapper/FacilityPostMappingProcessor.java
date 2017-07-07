package gov.ca.cwds.cals.service.mapper;

import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.cals.service.dto.FacilityAddressDTO;
import gov.ca.cwds.cals.service.dto.FacilityDTO;
import gov.ca.cwds.cals.service.dto.PhoneDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

@Mapper
public abstract class FacilityPostMappingProcessor {

    private static final PhoneMapper PHONE_MAPPER = Mappers.getMapper(PhoneMapper.class);
    private static final MailAddressMapper MAIL_ADDRESS_MAPPER = Mappers.getMapper(MailAddressMapper.class);
    private static final ResidentialAddressMapper RESIDENTIAL_ADDRESS_MAPPER = Mappers.getMapper(
            ResidentialAddressMapper.class);


    @AfterMapping
    protected void fillAddresses(LisFacFile lisFacFile, @MappingTarget FacilityDTO facilityDTO) {
        mapAddresses(lisFacFile, facilityDTO);
        mapPhones(lisFacFile, facilityDTO);
    }

    private void mapPhones(LisFacFile lisFacFile, FacilityDTO facilityDTO) {
        List<PhoneDTO> phones = new ArrayList<>(1);
        phones.add(PHONE_MAPPER.lisFacilityToPhoneDTO(lisFacFile));
        facilityDTO.setPhone(phones);
    }

    private void mapAddresses(LisFacFile lisFacFile, FacilityDTO facilityDTO) {
        List<FacilityAddressDTO> addresses = new ArrayList<>(2);
        FacilityAddressDTO residentialAddress = RESIDENTIAL_ADDRESS_MAPPER.lisFacilityToFacilityAddressDTO(lisFacFile);
        FacilityAddressDTO mailAddress = MAIL_ADDRESS_MAPPER.lisFacilityToFacilityAddressDTO(lisFacFile);
        addresses.add(residentialAddress);
        addresses.add(mailAddress);
        facilityDTO.setAddress(addresses);
    }

}
