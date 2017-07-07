package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = AddressType.NAMED_QUERY_FIND_ALL, query = "FROM AddressType ORDER BY id ASC")
@Entity
@Table(name = "address_type")
public class AddressType extends BaseDictionary {

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".AddressType" + NAMED_QUERY_FIND_ALL_SUFFIX;

  private static final long serialVersionUID = -4638495219558167830L;

}
