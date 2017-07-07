package gov.ca.cwds.cals.service;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.cms.CountiesDao;
import gov.ca.cwds.cals.persistence.model.cms.County;
import gov.ca.cwds.cals.service.dto.CountiesDTO;
import gov.ca.cwds.cals.service.mapper.CountyMapper;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.services.CrudsService;
import java.io.Serializable;
import java.util.List;

/** @author CWDS CALS API Team */
public class CountiesService implements CrudsService {

  private CountiesDao countiesDao;
  private CountyMapper countyMapper;

  @Inject
  public CountiesService(CountiesDao countiesDao, CountyMapper countyMapper) {
    this.countiesDao = countiesDao;
    this.countyMapper = countyMapper;
  }

  @Override
  public Response find(Serializable serializable) {
    final CountiesDTO countiesDTO = new CountiesDTO();
    List<County> counties = countiesDao.findAll();
    counties.forEach(
        (County county) -> countiesDTO.getCounties().add(countyMapper.toCountyDTO(county)));
    return countiesDTO;
  }

  @Override
  public Response delete(Serializable serializable) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Response create(Request request) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Response update(Serializable serializable, Request request) {
    throw new UnsupportedOperationException();
  }
}
