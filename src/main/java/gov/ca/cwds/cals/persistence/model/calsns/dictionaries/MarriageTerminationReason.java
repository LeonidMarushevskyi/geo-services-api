package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team.
 */
@NamedQuery(
    name = MarriageTerminationReason.NAMED_QUERY_FIND_ALL,
    query = "FROM MarriageTerminationReason ORDER BY id ASC"
)
@Entity
@Table(name = "marriage_termination_reason")
public class MarriageTerminationReason extends BaseDictionary {

  private static final long serialVersionUID = 1351466432617639006L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".MarriageTerminationReason" + NAMED_QUERY_FIND_ALL_SUFFIX;

}
