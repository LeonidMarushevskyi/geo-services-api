package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = NameType.NAMED_QUERY_FIND_ALL, query = "FROM NameType ORDER BY id ASC")
@Entity
@Table(name = "name_type")
public class NameType extends BaseDictionary {

  private static final long serialVersionUID = -6596915568825308193L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".NameType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
