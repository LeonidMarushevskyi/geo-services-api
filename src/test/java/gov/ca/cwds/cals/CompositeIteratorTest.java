package gov.ca.cwds.cals;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author CWDS TPT-2
 */
public class CompositeIteratorTest {

  private Iterator<String> iterator1;
  private Iterator<String> iterator2;
  private Iterator<String> iterator3;
  private Iterator<String> iterator4;
  private Iterator<String> iterator5;

  @Before
  public void setUp() {
    iterator1 = new ArrayList<String>() {{
      add("a");
      add("b");
      add("c");
    }}.iterator();
    iterator2 = new ArrayList<String>().iterator(); // intentionally empty
    iterator3 = new ArrayList<String>() {{
      add("d");
      add("e");
    }}.iterator();
    iterator4 = new ArrayList<String>() {{
      add("f");
    }}.iterator();
    iterator5 = new ArrayList<String>() {{
      add("g");
    }}.iterator();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmpty() {
    new CompositeIterator<>();
  }

  @Test
  public void testIteration() {
    CompositeIterator<String> compositeIterator1 = new CompositeIterator<>(iterator1, iterator2,
        iterator3, iterator4);
    int iterationCount = 0;
    while (compositeIterator1.hasNext()) {
      ++iterationCount;
      compositeIterator1.next();
    }
    assertEquals(6, iterationCount);

    setUp();
    compositeIterator1 = new CompositeIterator<>(iterator1, iterator2, iterator3, iterator4);
    CompositeIterator<String> compositeIterator2 = new CompositeIterator<>(compositeIterator1,
        iterator5);
    iterationCount = 0;
    while (compositeIterator2.hasNext()) {
      ++iterationCount;
      compositeIterator2.next();
    }
    assertEquals(7, iterationCount);
  }
}
