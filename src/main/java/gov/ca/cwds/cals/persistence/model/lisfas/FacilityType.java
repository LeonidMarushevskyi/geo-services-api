package gov.ca.cwds.cals.persistence.model.lisfas;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author CWDS CALS API Team
 */

@NamedQuery(name = "FacilityType.findAll",
        query = "FROM FacilityType order by tblFacTypeDesc")

@Entity
@DiscriminatorValue("FACILITY_TYPE")
public class FacilityType extends LisTableFile {

    private static final long serialVersionUID = -3760714538653384441L;

    private Integer tblFacTypeCode;
    private String tblFacTypeDesc;

    @Basic
    @Column(name = "tbl_fac_type_code", nullable = true)
    public Integer getTblFacTypeCode() {
        return tblFacTypeCode;
    }

    public void setTblFacTypeCode(Integer tblFacTypeCode) {
        this.tblFacTypeCode = tblFacTypeCode;
    }

    @Basic
    @Column(name = "tbl_fac_type_desc", nullable = true, length = 70)
    public String getTblFacTypeDesc() {
        return tblFacTypeDesc;
    }

    public void setTblFacTypeDesc(String tblFacTypeDesc) {
        this.tblFacTypeDesc = tblFacTypeDesc;
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
