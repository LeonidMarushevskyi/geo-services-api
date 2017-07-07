package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = EthnicityType.NAMED_QUERY_FIND_ALL, query = "FROM EthnicityType ORDER BY id ASC")
@Entity
@Table(name = "ethnicity_type")
public class EthnicityType extends BaseDictionary {

  private static final long serialVersionUID = -7703852815579312269L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".EthnicityType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
