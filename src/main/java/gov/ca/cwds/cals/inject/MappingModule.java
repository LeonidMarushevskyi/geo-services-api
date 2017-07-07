package gov.ca.cwds.cals.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cals.service.mapper.ComplaintMapper;
import gov.ca.cwds.cals.service.mapper.ComplaintMapperImpl;
import gov.ca.cwds.cals.service.mapper.CountyMapper;
import gov.ca.cwds.cals.service.mapper.CountyMapperImpl;
import gov.ca.cwds.cals.service.mapper.FacilityChildMapper;
import gov.ca.cwds.cals.service.mapper.FacilityChildMapperImpl;
import gov.ca.cwds.cals.service.mapper.FacilityInspectionMapper;
import gov.ca.cwds.cals.service.mapper.FacilityInspectionMapperImpl;
import gov.ca.cwds.cals.service.mapper.FacilityMapper;
import gov.ca.cwds.cals.service.mapper.FacilityMapperImpl;
import gov.ca.cwds.cals.service.mapper.FacilityTypeMapper;
import gov.ca.cwds.cals.service.mapper.FacilityTypeMapperImpl;
import gov.ca.cwds.cals.service.mapper.FasFacilityMapper;
import gov.ca.cwds.cals.service.mapper.FasFacilityMapperImpl;
import gov.ca.cwds.cals.service.mapper.rfa.RFA1aFormMapper;
import gov.ca.cwds.cals.service.mapper.rfa.RFA1aFormMapperImpl;

/**
 * DI (dependency injection) setup for mapping classes.
 *
 * @author CWDS CALS API Team
 */

public class MappingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FacilityMapper.class).to(FacilityMapperImpl.class).asEagerSingleton();
        bind(FasFacilityMapper.class).to(FasFacilityMapperImpl.class).asEagerSingleton();
        bind(FacilityChildMapper.class).to(FacilityChildMapperImpl.class).asEagerSingleton();
        bind(FacilityInspectionMapper.class).to(FacilityInspectionMapperImpl.class).asEagerSingleton();
        bind(ComplaintMapper.class).to(ComplaintMapperImpl.class).asEagerSingleton();
        bind(CountyMapper.class).to(CountyMapperImpl.class).asEagerSingleton();
        bind(FacilityTypeMapper.class).to(FacilityTypeMapperImpl.class).asEagerSingleton();

        bind(RFA1aFormMapper.class).to(RFA1aFormMapperImpl.class).asEagerSingleton();
    }

}


