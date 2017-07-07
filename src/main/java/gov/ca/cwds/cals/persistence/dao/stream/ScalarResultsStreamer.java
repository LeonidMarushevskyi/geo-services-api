package gov.ca.cwds.cals.persistence.dao.stream;

import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.data.persistence.PersistentObject;
import org.hibernate.ScrollableResults;

/**
 * @author CWDS TPT-2
 */
public class ScalarResultsStreamer<E extends PersistentObject> extends
    AbstractResultsStreamer<E> {

  public ScalarResultsStreamer(BaseDaoImpl<E> dao, QueryCreator<E> queryCreator) {
    super(dao, queryCreator);
  }

  @SuppressWarnings("unchecked")
  protected final E getResult(ScrollableResults scrollableResults) {
    return (E) scrollableResults.get(0);
  }
}
