package gov.ca.cwds.geo.persistence.dao;

import com.google.inject.Inject;
import gov.ca.cwds.rest.SmartyStreetsConfiguration;

/**
 * A DAO for SmartyStreets.
 * 
 * @author CWDS API Team
 */
public class SmartyStreetsDao {

  private final String clientId;
  private final String token;
  private final Integer maxCandidates;

  /**
   * Constructor. Construct from required fields.
   * 
   * @param clientId The Client login Id
   * @param token The Client login token
   * @param maxCandidates The maximum number of returned standardized Addresses
   */
  public SmartyStreetsDao(String clientId, String token, Integer maxCandidates) {
    super();
    this.clientId = clientId;
    this.token = token;
    this.maxCandidates = maxCandidates;
  }

  /**
   * Constructor. Construct from YAML configuration.
   * 
   * @param config The SmartyStreets configuration
   */
  @Inject
  public SmartyStreetsDao(SmartyStreetsConfiguration config) {
    this.clientId = config.getClientId();
    this.token = config.getToken();
    this.maxCandidates = config.getMaxCandidates();
  }

  /**
   * @return the clientId
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @return the maxCandidates
   */
  public Integer getMaxCandidates() {
    return maxCandidates;
  }

}
