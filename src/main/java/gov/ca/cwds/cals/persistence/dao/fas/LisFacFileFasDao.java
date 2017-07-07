package gov.ca.cwds.cals.persistence.dao.fas;

import com.google.inject.Inject;
import gov.ca.cwds.cals.inject.FasSessionFactory;
import gov.ca.cwds.cals.persistence.model.lisfas.LisFacFile;
import gov.ca.cwds.data.BaseDaoImpl;
import org.hibernate.SessionFactory;

/**
 * @author CWDS CALS API Team
 */
public class LisFacFileFasDao extends BaseDaoImpl<LisFacFile> {

    @Inject
    public LisFacFileFasDao(@FasSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
