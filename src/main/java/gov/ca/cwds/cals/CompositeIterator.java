package gov.ca.cwds.cals;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author CWDS TPT-2
 */
public class CompositeIterator<T> implements Iterator<T> {
  private Iterator<T>[] iteratorArray;
  private int currentIteratorIndex = -1;
  private Iterator<T> currentIterator;

  @SafeVarargs
  public CompositeIterator(Iterator<T>... iteratorArray) {
    // validate parameter
    Objects.requireNonNull(iteratorArray);
    if (iteratorArray.length == 0) {
      throw new IllegalArgumentException("At least one Iterator is required");
    }
    // initialize
    this.iteratorArray = iteratorArray;
    this.currentIterator = nextIterator();
  }

  @Override
  public boolean hasNext() {
    if (currentIterator.hasNext()) {
      return true;
    } else {
      boolean has = false;
      while (hasNextIterator()) {
        currentIterator = nextIterator();
        if (currentIterator.hasNext()) {
          has = true;
          break;
        }
      }
      return has;
    }
  }

  @Override
  public T next() {
    if (hasNext()) {
      return currentIterator.next();
    } else {
      throw new NoSuchElementException();
    }
  }

  private boolean hasNextIterator() {
    return currentIteratorIndex + 1 < iteratorArray.length;
  }

  private Iterator<T> nextIterator() {
    if (hasNextIterator()) {
      Iterator<T> it = iteratorArray[++currentIteratorIndex];
      Objects.requireNonNull(it);
      return it;
    } else {
      throw new NoSuchElementException();
    }
  }
}
