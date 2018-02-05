package gov.ca.cwds.geo.service;

import com.google.inject.Inject;
import com.jcabi.aspects.Cacheable;
import com.jcabi.aspects.Loggable;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.BatchFullException;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Batch;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Components;
import com.smartystreets.api.us_street.Lookup;
import com.smartystreets.api.us_street.Metadata;
import gov.ca.cwds.geo.persistence.dao.SmartyStreetsDAO;
import gov.ca.cwds.geo.persistence.model.Address;
import gov.ca.cwds.geo.service.dto.ValidatedAddressDTO;
import gov.ca.cwds.rest.api.ApiException;
import gov.ca.cwds.rest.exception.BusinessValidationException;
import gov.ca.cwds.rest.exception.IssueDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validates the address by calling the SmartyStreets API
 *
 * @author CWDS API Team
 */
public class USStreetAddressService {

  private static final Logger LOGGER = LoggerFactory.getLogger(USStreetAddressService.class);

  private static final String ERROR_CALLING_SMARTY_STREET = "ERROR calling USStreetAddressService - ";
  private final SmartyStreetsDAO smartyStreetsDAO;
  private Client client;

  @Inject
  public USStreetAddressService(SmartyStreetsDAO smartyStreetsDAO) {
    this.smartyStreetsDAO = smartyStreetsDAO;
    StaticCredentials credentials = new StaticCredentials(smartyStreetsDAO.getClientId(), smartyStreetsDAO.getToken());
    client = new ClientBuilder(credentials).buildUsStreetApiClient();

  }

  @Loggable
  public ValidatedAddressDTO[] validateSingleUSAddress(String street, String city, String state, String zipCode) {
    final List<Candidate> candidates = getSmartyStreetsCandidates(street, city, state, zipCode);
    if (candidates.isEmpty()) {
      final Set<IssueDetails> issueDetails = generateIssueDetails();
      throw new BusinessValidationException(issueDetails);
    }
    return candidates.stream()
        .map(this::toValidatedAddressDTO)
        .toArray(ValidatedAddressDTO[]::new);
  }

  @Loggable
  public ValidatedAddressDTO[] validateAddress(String street, String city, String state, String zipCode) {
    final List<Candidate> candidates = getSmartyStreetsCandidates(street, city, state, zipCode);
    return candidates.stream()
        .map(this::toValidatedAddressDTO)
        .toArray(ValidatedAddressDTO[]::new);
  }

  @Loggable(Loggable.DEBUG)
  public ValidatedAddressDTO[] validateBatchAddress(Address[] addresses) {
    List<Candidate> candidates = new ArrayList<>();
    if (addresses.length > 0) {
      candidates = validateBatch(addresses);
    }
    return candidates.stream()
        .map(this::toValidatedAddressDTO)
        .toArray(ValidatedAddressDTO[]::new);
  }


  private Set<IssueDetails> generateIssueDetails() {
    final Set<IssueDetails> issueDetails = new HashSet<>();
    final IssueDetails issueDetail = new IssueDetails();
    issueDetail.setIncidentId(UUID.randomUUID().toString());
    issueDetail.setTechnicalMessage("Address is not deliverable");
    issueDetails.add(issueDetail);
    return issueDetails;
  }

  private ValidatedAddressDTO toValidatedAddressDTO(Candidate candidate) {
    final Components components = candidate.getComponents();
    final Metadata metadata = candidate.getMetadata();
    final String dpvMatchCode = candidate.getAnalysis().getDpvMatchCode();
    return new ValidatedAddressDTO(
        candidate.getDeliveryLine1(),
        components.getCityName(),
        components.getState(),
        null,
        components.getZipCode(),
        components.getPlus4Code(),
        metadata.getLongitude(),
        metadata.getLatitude(),
        isDeliverableMatchCode(dpvMatchCode)
    );
  }

  private boolean isDeliverableMatchCode(String dpvMatchCode) {
    return "Y".equals(dpvMatchCode)
        || "S".equals(dpvMatchCode)
        || "D".equals(dpvMatchCode);
  }


  public List<Candidate> getSmartyStreetsCandidates(String street, String city, String state, String zipCode) {
    Lookup lookup = createSmartyStreetsLookup(street, city, state, zipCode);

    try {
      client.send(lookup);
    } catch (SmartyException e) {
      LOGGER.error("USStreetAddressService error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("USStreetAddressService IO error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    }

    return lookup.getResult();
  }

  public List<Candidate> validateBatch(Address[] addresses) {
    List<Candidate> candidates = new ArrayList<>();
    try {
      Batch batch = createSmartyStreetsBatch(addresses);
      client.send(batch);
      for (Lookup lookup : batch.getAllLookups()) {
        candidates.addAll(lookup.getResult());
      }
    } catch (SmartyException e) {
      LOGGER.error("USStreetAddressService error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    } catch (IOException e) {
      LOGGER.error("USStreetAddressService IO error, Unable to validate the address", e);
      throw new ApiException(ERROR_CALLING_SMARTY_STREET, e);
    }
    return candidates;
  }

  private Batch createSmartyStreetsBatch(Address[] addresses) throws BatchFullException {
    Batch batch = new Batch();
    for (Address address: addresses) {
      Lookup lookup = new Lookup();
      lookup.setCity(address.getCity());
      lookup.setStreet(address.getStreetAddress());
      lookup.setState(address.getState());
      lookup.setZipCode(address.getZip());
      batch.add(lookup);
    }
    return batch;
  }

  private Lookup createSmartyStreetsLookup(
      String street, String city, String state, String zipCode) {
    Lookup lookup = new Lookup();
    lookup.setStreet(street);
    lookup.setCity(city);
    lookup.setState(state);
    lookup.setZipCode(zipCode == null ? StringUtils.EMPTY : zipCode);
    lookup.setMaxCandidates(smartyStreetsDAO.getMaxCandidates());
    return lookup;
  }
}
