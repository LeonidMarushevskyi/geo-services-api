package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = StateType.NAMED_QUERY_FIND_ALL, query = "FROM StateType ORDER BY id ASC")
@Entity
@Table(name = "state_type")
public class StateType extends BaseDictionary {

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".StateType" + NAMED_QUERY_FIND_ALL_SUFFIX;

  private static final long serialVersionUID = -3799114345234018083L;
}
