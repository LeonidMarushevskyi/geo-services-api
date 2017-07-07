package gov.ca.cwds.cals.service.mapper;


import gov.ca.cwds.cals.persistence.model.cms.BaseClient;
import gov.ca.cwds.cals.persistence.model.cms.BaseOutOfHomePlacement;
import gov.ca.cwds.cals.persistence.model.cms.BasePlacementEpisode;
import gov.ca.cwds.cals.persistence.model.cms.BaseStaffPerson;
import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.cals.service.dto.FacilityChildDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Set;

/**
 *
 *  @author CWDS CALS API Team
 *
 */
@Mapper(uses = {PersonMapper.class, TrailingSpacesRemovalPostMappingProcessor.class})
public interface FacilityChildMapper {

    @Mapping(target = "id", source = "client.identifier")
    @Mapping(target = "person", source = "client")
    @Mapping(target = "dateOfPlacement", ignore = true)
    @Mapping(target = "countyOfOrigin", ignore = true)
    @Mapping(target = "assignedWorker", ignore = true)
    @Mapping(target = "facilityId", ignore = true)
    @Mapping(target = "messages", ignore = true)
    FacilityChildDTO toFacilityChildDTO(BaseClient client);

    @Mapping(target = "assignedWorker", source = "staffPerson")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    @Mapping(target = "dateOfPlacement", ignore = true)
    @Mapping(target = "countyOfOrigin", ignore = true)
    @Mapping(target = "facilityId", ignore = true)
    @Mapping(target = "messages", ignore = true)
    FacilityChildDTO toFacilityChildDTO(@MappingTarget FacilityChildDTO facilityChildDTO, BaseStaffPerson staffPerson);

    @Mapping(target = "countyOfOrigin", source = "shortDsc")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    @Mapping(target = "dateOfPlacement", ignore = true)
    @Mapping(target = "assignedWorker", ignore = true)
    @Mapping(target = "facilityId", ignore = true)
    @Mapping(target = "messages", ignore = true)
    FacilityChildDTO toFacilityChildDTO(@MappingTarget FacilityChildDTO facilityChildDTO, County county);

    @Mapping(target = "dateOfPlacement", source = "startDt")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    @Mapping(target = "countyOfOrigin", ignore = true)
    @Mapping(target = "assignedWorker", ignore = true)
    @Mapping(target = "facilityId", ignore = true)
    @Mapping(target = "messages", ignore = true)
    FacilityChildDTO toFacilityChildDTO(@MappingTarget FacilityChildDTO facilityChildDTO, BaseOutOfHomePlacement outOfHomePlacement);

    @AfterMapping
    default void after(@MappingTarget FacilityChildDTO facilityChildDTO, BaseClient client) {
        Set<? extends BasePlacementEpisode> placementEpisodes = client.getPlacementEpisodes();
        if (!placementEpisodes.isEmpty()) {

            FacilityChildMapper facilityChildMapper = Mappers.getMapper(FacilityChildMapper.class);

            BasePlacementEpisode placementEpisode = placementEpisodes.iterator().next();
            County county = placementEpisode.getCounty();
            facilityChildMapper.toFacilityChildDTO(facilityChildDTO, county);

            BaseStaffPerson staffPerson = placementEpisode.getStaffPerson();
            facilityChildMapper.toFacilityChildDTO(facilityChildDTO, staffPerson);

            Set<? extends BaseOutOfHomePlacement> outOfHomePlacements = placementEpisode.getOutOfHomePlacements();
            if (!outOfHomePlacements.isEmpty()) {

                BaseOutOfHomePlacement outOfHomePlacement = outOfHomePlacements.iterator().next();
                facilityChildMapper.toFacilityChildDTO(facilityChildDTO, outOfHomePlacement);
            }
        }
    }
}
