package gov.ca.cwds.geo;

import gov.ca.cwds.geo.web.rest.AddressResourceIT;
import gov.ca.cwds.geo.web.rest.SystemInformationResourceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddressResourceIT.class, SystemInformationResourceTest.class})
public class SmokeTestSuite {

}
