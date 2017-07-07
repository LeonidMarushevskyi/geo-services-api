package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team.
 */
@NamedQuery(name = ResidenceOwnershipType.NAMED_QUERY_FIND_ALL, query = "FROM ResidenceOwnershipType ORDER BY id ASC")
@Entity
@Table(name = "residence_ownership_type")
public class ResidenceOwnershipType extends BaseDictionary {

  private static final long serialVersionUID = 1L;

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".ResidenceOwnershipType" + NAMED_QUERY_FIND_ALL_SUFFIX;
}
