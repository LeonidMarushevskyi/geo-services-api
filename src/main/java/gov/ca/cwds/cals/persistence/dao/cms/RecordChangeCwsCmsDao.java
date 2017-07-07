package gov.ca.cwds.cals.persistence.dao.cms;

import com.google.inject.Inject;
import gov.ca.cwds.cals.persistence.model.RecordChange;
import gov.ca.cwds.cals.persistence.dao.stream.QueryCreator;
import gov.ca.cwds.cals.persistence.dao.stream.RecordChangesStreamer;
import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.inject.CmsSessionFactory;
import java.util.Date;
import java.util.stream.Stream;
import org.hibernate.SessionFactory;

/**
 * @author CWDS TPT-2
 */
public class RecordChangeCwsCmsDao extends BaseDaoImpl<RecordChange> {

  @Inject
  public RecordChangeCwsCmsDao(@CmsSessionFactory SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @SuppressWarnings("unchecked") // because of getNamedNativeQuery
  public Stream<RecordChange> streamChangedFacilityRecords(final Date after) {
    QueryCreator<RecordChange> queryCreator = (session, entityClass) -> session
        .getNamedNativeQuery(entityClass.getSimpleName() + ".findChangedFacilityRecordsInCWSCMS")
        .setParameter("dateAfter", after).setReadOnly(true);
    return new RecordChangesStreamer(this, queryCreator).createStream();
  }
}
