package gov.ca.cwds.cals.service.dto.rfa;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import java.util.Collection;

/**
 * @author CWDS CALS API Team
 */
public class RFA1bFormCollectionDTO extends CollectionDTO<RFA1bFormDTO> {

  private static final long serialVersionUID = -1358155025777273977L;

  public RFA1bFormCollectionDTO() {
  }

  public RFA1bFormCollectionDTO(Collection<RFA1bFormDTO> collection) {
    super(collection);
  }
}
