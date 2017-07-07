package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = IncomeType.NAMED_QUERY_FIND_ALL, query = "FROM IncomeType ORDER BY id ASC")
@Entity
@Table(name = "income_type")
public class IncomeType extends BaseDictionary {

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".IncomeType" + NAMED_QUERY_FIND_ALL_SUFFIX;

  private static final long serialVersionUID = -564433065858546891L;

}
