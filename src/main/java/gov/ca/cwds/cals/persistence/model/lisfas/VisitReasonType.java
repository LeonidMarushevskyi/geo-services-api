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
@DiscriminatorValue("VISIT_REASON_TYPE")
public class VisitReasonType extends LisTableFile {

    private static final long serialVersionUID = -1174117626895471708L;
    
    private Integer tblVisitReasonCode;
    private String tblVisitReasonDesc;

    @Basic
    @Column(name = "tbl_visit_reason_code", nullable = true)
    public Integer getTblVisitReasonCode() {
        return tblVisitReasonCode;
    }

    public void setTblVisitReasonCode(Integer tblVisitReasonCode) {
        this.tblVisitReasonCode = tblVisitReasonCode;
    }

    @Basic
    @Column(name = "tbl_visit_reason_desc", nullable = true, length = 70)
    public String getTblVisitReasonDesc() {
        return tblVisitReasonDesc;
    }

    public void setTblVisitReasonDesc(String tblVisitReasonDesc) {
        this.tblVisitReasonDesc = tblVisitReasonDesc;
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
