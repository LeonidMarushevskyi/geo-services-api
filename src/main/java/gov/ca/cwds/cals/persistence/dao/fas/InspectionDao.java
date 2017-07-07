package gov.ca.cwds.cals.persistence.dao.fas;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FasSessionFactory;
import gov.ca.cwds.cals.persistence.model.fas.Rr809Dn;
import gov.ca.cwds.cals.persistence.model.fas.Rrcpoc;
import gov.ca.cwds.data.BaseDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;

/** @author CWDS CALS API Team */
public class InspectionDao extends BaseDaoImpl<Rrcpoc> {
  private static final long serialVersionUID = 839402158987943034L;

  private static final Logger LOG = LoggerFactory.getLogger(InspectionDao.class);

  @Inject
  public InspectionDao(@FasSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Rr809Dn> findDeficienciesByFacilityNumber(Integer facilityNumber) {
    Session currentSession = getSessionFactory().getCurrentSession();
    Query<Rr809Dn> namedQuery =
        currentSession.createNamedQuery(Rr809Dn.NQ_FIND_BY_FACILITY_NUMBER, Rr809Dn.class);
    namedQuery.setParameter("facilityNumberText", formatFacilityNumber(facilityNumber));
    return namedQuery.list();
  }

  public Rr809Dn getDeficiencyByFacilityNumberAndId(Integer facilityNumber, String deficiencyId) {
    Session currentSession = getSessionFactory().getCurrentSession();
    Query<Rr809Dn> namedQuery =
        currentSession.createNamedQuery(
            Rr809Dn.NQ_FIND_BY_FACILITY_NUMBER_AND_DEFICIENCY_ID, Rr809Dn.class);
    String facilityNumberText = formatFacilityNumber(facilityNumber);
    namedQuery.setParameter("facilityNumberText", facilityNumberText);
    namedQuery.setParameter("deficiencyId", deficiencyId);
    Rr809Dn res = null;
    try {
      res = namedQuery.getSingleResult();
    } catch (NoResultException e) {
      LOG.warn(
          "There is no result for facilityNumberText: {} and deficiencyId {} ",
          facilityNumberText, deficiencyId);
      LOG.debug(e.getMessage(), e);
    }
    return res;
  }

  protected static String formatFacilityNumber(Integer facilityNumber) {
    return String.format("%09d", facilityNumber);
  }
}
