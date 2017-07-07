package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team.
 */
@NamedQuery(name = LicenseType.NAMED_QUERY_FIND_ALL, query = "FROM LicenseType ORDER BY id ASC")
@Entity
@Table(name = "license_type")
public class LicenseType extends BaseDictionary {

  private static final long serialVersionUID = -3278919966978860583L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".LicenseType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
