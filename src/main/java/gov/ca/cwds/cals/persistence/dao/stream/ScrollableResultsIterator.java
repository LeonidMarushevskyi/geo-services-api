package gov.ca.cwds.cals.persistence.dao.stream;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.hibernate.ScrollableResults;

/**
 * @author CWDS TPT-2
 */
public abstract class ScrollableResultsIterator<T> implements Iterator<T> {

  private T next;
  private ScrollableResults scrollableResults;

  ScrollableResultsIterator(ScrollableResults scrollableResults) {
    this.scrollableResults = scrollableResults;
    moveForward();
  }

  @Override
  public final boolean hasNext() {
    return next != null;
  }

  @Override
  public final T next() {
    if (next != null) {
      T result = next;
      moveForward();
      return result;
    } else {
      throw new NoSuchElementException();
    }
  }

  private void moveForward() {
    if (scrollableResults.next()) {
      next = extractResult(scrollableResults);
    } else {
      next = null;
    }
  }

  protected abstract T extractResult(ScrollableResults scrollableResults);
}
