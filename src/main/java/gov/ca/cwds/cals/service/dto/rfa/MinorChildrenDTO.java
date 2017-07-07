package gov.ca.cwds.cals.service.dto.rfa;

import gov.ca.cwds.cals.persistence.model.calsns.rfa.MinorChildDTO;
import gov.ca.cwds.cals.service.dto.CollectionDTO;
import java.util.Collection;

/**
 * @author CWDS CALS API Team
 */
public class MinorChildrenDTO extends CollectionDTO<MinorChildDTO> {

  private static final long serialVersionUID = 3347226957017640546L;

  public MinorChildrenDTO() {
  }

  public MinorChildrenDTO(Collection<MinorChildDTO> collection) {
    super(collection);
  }
}
