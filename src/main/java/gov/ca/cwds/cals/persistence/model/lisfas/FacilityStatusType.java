package gov.ca.cwds.cals.persistence.model.lisfas;

/**
 * @author CWDS CALS API Team
 */

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FACILITY_STATUS_TYPE")
public class FacilityStatusType extends LisTableFile {

    private static final long serialVersionUID = -1273775014654075758L;

    private Integer tblFacStatusCode;
    private String tblFacStatusDesc;

    @Basic
    @Column(name = "tbl_fac_status_code", nullable = true)
    public Integer getTblFacStatusCode() {
        return tblFacStatusCode;
    }

    public void setTblFacStatusCode(Integer tblFacStatusCode) {
        this.tblFacStatusCode = tblFacStatusCode;
    }

    @Basic
    @Column(name = "tbl_fac_status_desc", nullable = true, length = 70)
    public String getTblFacStatusDesc() {
        return tblFacStatusDesc;
    }

    public void setTblFacStatusDesc(String tblFacStatusDesc) {
        this.tblFacStatusDesc = tblFacStatusDesc;
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
