package gov.ca.cwds.cals.persistence.model.fas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */


@NamedQuery(
        name = LpaInformation.FIND_ASSIGNED_WORKER_BY_LPA_CODE,
        query = "SELECT l FROM LpaInformation l WHERE l.lpaCode = :" +
                LpaInformation.PARAM_LPA_CODE
)
@Entity
@Table(name = "lpa_information", schema = "fas")
public class LpaInformation implements PersistentObject {

    private static final long serialVersionUID = -3566583736496919788L;

    public static final String FIND_ASSIGNED_WORKER_BY_LPA_CODE = "findAssignedWorkerByLPACode";
    public static final String PARAM_LPA_CODE = "lpaCode";

    private String fullLpaName;
    private String lpaCode;

    @Id
    @Column(name = "lpa_code", length = 254, insertable = false, updatable = false)
    public String getLpaCode() {
        return lpaCode;
    }

    public void setLpaCode(String lpaCode) {
        this.lpaCode = lpaCode;
    }

    @Basic
    @Column(name = "full_lpa_name", length = 254)
    public String getFullLpaName() {
        return fullLpaName;
    }

    public void setFullLpaName(String fullLpaName) {
        this.fullLpaName = fullLpaName;
    }

    @Transient
    @Override
    public Serializable getPrimaryKey() {
        return lpaCode;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}

