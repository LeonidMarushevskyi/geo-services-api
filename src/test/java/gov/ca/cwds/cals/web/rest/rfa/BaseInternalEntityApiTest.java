package gov.ca.cwds.cals.web.rest.rfa;

import gov.ca.cwds.cals.BaseCalsApiIntegrationTest;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS CALS API Team
 */

public abstract class BaseInternalEntityApiTest<T extends BaseDTO> extends
    BaseCalsApiIntegrationTest implements InternalEntityApiHelper {

  protected abstract BaseInternalEntityApiHelper<T> getInternalEntityApiHelper();

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCalsns();
  }

  @Override
  @Test
  public void getApplicationNotFound() throws Exception {
    getInternalEntityApiHelper().getApplicationNotFound();
  }

  @Test
  @Override
  public void putApplicationNotFound() throws Exception {
    getInternalEntityApiHelper().putApplicationNotFound();
  }

  @Test
  @Override
  public void getEntityNotFound() throws Exception {
    getInternalEntityApiHelper().getEntityNotFound();
  }

  @Test
  @Override
  public void putAndGetEntity() throws Exception {
    getInternalEntityApiHelper().putAndGetEntity();
  }
}
