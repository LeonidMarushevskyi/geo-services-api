package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import gov.ca.cwds.cals.persistence.hibernate.JsonType;

/**
 * @author CWDS CALS API Team
 */
public class RFA1bFormJsonType extends JsonType {

  public Class<RFA1bFormDTO> returnedClass() {
    return RFA1bFormDTO.class;
  }

}
