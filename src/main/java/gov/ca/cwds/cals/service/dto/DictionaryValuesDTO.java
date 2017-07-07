package gov.ca.cwds.cals.service.dto;

import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.BaseDictionary;
import java.util.Collection;

/**
 * @author CWDS CALS API Team
 */
public class DictionaryValuesDTO extends CollectionDTO<BaseDictionary> {

  private static final long serialVersionUID = -7443355954138550300L;

  public DictionaryValuesDTO() {
  }

  public DictionaryValuesDTO(Collection<BaseDictionary> collection) {
    super(collection);
  }
}
