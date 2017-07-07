package gov.ca.cwds.cals.persistence.model.lisfas;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author CWDS CALS API Team
 */

@Entity
@DiscriminatorValue("COUNTY")
public class County extends LisTableFile {

    private static final long serialVersionUID = 8555919317317204161L;

    private Integer tblCoNbr;
    private String tblCoDesc;

    @Basic
    @Column(name = "tbl_co_nbr", nullable = true)
    public Integer getTblCoNbr() {
        return tblCoNbr;
    }

    public void setTblCoNbr(Integer tblCoNbr) {
        this.tblCoNbr = tblCoNbr;
    }

    @Basic
    @Column(name = "tbl_co_desc", nullable = true, length = 20)
    public String getTblCoDesc() {
        return tblCoDesc;
    }

    public void setTblCoDesc(String tblCoDesc) {
        this.tblCoDesc = tblCoDesc;
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

