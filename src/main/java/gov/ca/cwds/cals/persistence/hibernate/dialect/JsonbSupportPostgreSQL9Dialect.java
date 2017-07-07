package gov.ca.cwds.cals.persistence.hibernate.dialect;

import java.sql.Types;
import org.hibernate.dialect.PostgreSQL9Dialect;

/**
 * @author CWDS CALS API Team
 */
public class JsonbSupportPostgreSQL9Dialect extends PostgreSQL9Dialect {

  public JsonbSupportPostgreSQL9Dialect() {
    this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
  }
}
