package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = GenderType.NAMED_QUERY_FIND_ALL, query = "FROM GenderType ORDER BY id ASC")
@Entity
@Table(name = "gender_type")
public class GenderType extends BaseDictionary {

  private static final long serialVersionUID = 1879954465871059275L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".GenderType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
