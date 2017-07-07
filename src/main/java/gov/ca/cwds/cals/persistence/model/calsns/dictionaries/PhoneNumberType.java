package gov.ca.cwds.cals.persistence.model.calsns.dictionaries;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(name = PhoneNumberType.NAMED_QUERY_FIND_ALL, query = "FROM PhoneNumberType ORDER BY id ASC")
@Entity
@Table(name = "phone_number_type")
public class PhoneNumberType extends BaseDictionary {

  public static final String NAMED_QUERY_FIND_ALL =
      NAMED_QUERY_PREFIX + ".PhoneNumberType" + NAMED_QUERY_FIND_ALL_SUFFIX;

  private static final long serialVersionUID = -2143879745194043708L;

}
