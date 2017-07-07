package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = LanguageType.NAMED_QUERY_FIND_ALL, query = "FROM LanguageType ORDER BY id ASC")
@Entity
@Table(name = "language_type")
public class LanguageType extends BaseDictionary {

  private static final long serialVersionUID = 6826680604709572750L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".LanguageType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
