package gov.ca.cwds.cals.persistence.model.lisfas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */

@Entity
@Table(name = "lis_table_file")
@DiscriminatorFormula(
        "CASE WHEN tbl_fac_type_code   IS NOT NULL THEN 'FACILITY_TYPE'" +
        "     WHEN tbl_fac_status_code IS NOT NULL THEN 'FACILITY_STATUS_TYPE'" +
        "     WHEN tbl_co_nbr IS NOT NULL THEN 'COUNTY'" +
        "     WHEN tbl_visit_reason_code IS NOT NULL THEN 'VISIT_REASON_TYPE' end"
)
public abstract class LisTableFile implements PersistentObject {

    private static final long serialVersionUID = 3362198377330883827L;

    private Integer isnLisTableFile;

    @Id
    @Column(name = "isn_lis_table_file", nullable = false)
    public Integer getIsnLisTableFile() {
        return isnLisTableFile;
    }

    public void setIsnLisTableFile(Integer isnLisTableFile) {
        this.isnLisTableFile = isnLisTableFile;
    }

    @Override
    @Transient
    public Serializable getPrimaryKey() {
        return getIsnLisTableFile();
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
