package gov.ca.cwds.cals.persistence.dao.cms;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.dao.stream.QueryCreator;
import gov.ca.cwds.cals.persistence.dao.stream.ScalarResultsStreamer;
import gov.ca.cwds.cals.persistence.model.cms.legacy.Client;
import gov.ca.cwds.cals.web.rest.parameter.FacilityChildParameterObject;
import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.inject.CmsSessionFactory;
import java.util.stream.Stream;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CWDS CALS API Team
 */
public class ClientDao extends BaseDaoImpl<Client> {

  private static final Logger LOG = LoggerFactory.getLogger(ClientDao.class);

  @Inject
  public ClientDao(@CmsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Client findByParameterObject(FacilityChildParameterObject parameterObject) {
    Session session = getSessionFactory().getCurrentSession();
    Class<Client> entityClass = getEntityClass();
    Query<Client> query =
        session.createNamedQuery(entityClass.getSimpleName() + ".find", entityClass);

    String licenseNumber = parameterObject.getLicenseNumber();
    query.setParameter("licenseNumber", licenseNumber);

    String childId = parameterObject.getChildId();
    query.setParameter("childId", childId);

    query.setMaxResults(1);

    Client client = null;
    try {
      client = query.getSingleResult();
    } catch (NoResultException e) {
      LOG.warn(
          "There is no result for licenseNumber = {} and childId = {}", licenseNumber, childId);
      LOG.debug(e.getMessage(), e);
    }

    return client;
  }

  public Stream<Client> streamByLicenseNumber(String licenseNumber) {
    QueryCreator<Client> queryCreator = (session, entityClass) -> session
        .createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass)
        .setParameter("licenseNumber", licenseNumber);
    return new ScalarResultsStreamer<>(this, queryCreator).createStream();
  }

  public Stream<Client> streamByLicenseNumber(Integer licenseNumber) {
    return streamByLicenseNumber(String.valueOf(licenseNumber));
  }

  public Stream<Client> streamByFacilityId(String facilityId) {
    QueryCreator<Client> queryCreator = (session, entityClass) -> session
        .createNamedQuery(entityClass.getSimpleName() + ".findByFacilityId", entityClass)
        .setParameter("facilityId", facilityId);
    return new ScalarResultsStreamer<>(this, queryCreator).createStream();
  }
}
