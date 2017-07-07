package gov.ca.cwds.cals.service.dto.rfa;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cFormDTO;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import java.util.Collection;

/**
 * @author CWDS CALS API Team
 */
public class RFA1cFormCollectionDTO extends CollectionDTO<RFA1cFormDTO> {

  private static final long serialVersionUID = -8715594699708054558L;

  public RFA1cFormCollectionDTO() {
  }

  public RFA1cFormCollectionDTO(Collection<RFA1cFormDTO> collection) {
    super(collection);
  }
}
