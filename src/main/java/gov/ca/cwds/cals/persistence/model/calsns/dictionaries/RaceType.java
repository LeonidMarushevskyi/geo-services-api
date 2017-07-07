package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = RaceType.NAMED_QUERY_FIND_ALL, query = "FROM RaceType ORDER BY id ASC")
@Entity
@Table(name = "race_type")
public class RaceType extends BaseDictionary {

  private static final long serialVersionUID = -1974798271404624843L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".RaceType" + NAMED_QUERY_FIND_ALL_SUFFIX;

}
