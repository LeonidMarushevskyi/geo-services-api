package gov.ca.cwds.cals.persistence.model.cms;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author CWDS CALS API Team
 */
@Entity
@DiscriminatorColumn(name = "FKS_META_T")
@Table(name = "SYS_CD_C")
public abstract class SystemCodeTable implements PersistentObject {

    private static final long serialVersionUID = -3979949426929339075L;

    private Short sysId;
    private Short categoryid;
    private String inactvInd;
    private String otherCd;
    private String shortDsc;
    private String lgcId;
    private String lstUpdId;
    private Timestamp lstUpdTs;
    private String thirdId;
    private String fksMetaT;
    private String longDsc;

    @Id
    @Column(name = "SYS_ID")
    public Short getSysId() {
        return sysId;
    }

    public void setSysId(Short sysId) {
        this.sysId = sysId;
    }

    @Basic
    @Column(name = "CATEGORYID")
    public Short getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Short categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "INACTV_IND")
    public String getInactvInd() {
        return inactvInd;
    }

    public void setInactvInd(String inactvInd) {
        this.inactvInd = inactvInd;
    }

    @Basic
    @Column(name = "OTHER_CD")
    public String getOtherCd() {
        return otherCd;
    }

    public void setOtherCd(String otherCd) {
        this.otherCd = otherCd;
    }

    @Basic
    @Column(name = "SHORT_DSC")
    public String getShortDsc() {
        return shortDsc;
    }

    public void setShortDsc(String shortDsc) {
        this.shortDsc = shortDsc;
    }

    @Basic
    @Column(name = "LGC_ID")
    public String getLgcId() {
        return lgcId;
    }

    public void setLgcId(String lgcId) {
        this.lgcId = lgcId;
    }

    @Basic
    @Column(name = "LST_UPD_ID")
    public String getLstUpdId() {
        return lstUpdId;
    }

    public void setLstUpdId(String lstUpdId) {
        this.lstUpdId = lstUpdId;
    }

    @Basic
    @Column(name = "LST_UPD_TS")
    public Timestamp getLstUpdTs() {
        return lstUpdTs;
    }

    public void setLstUpdTs(Timestamp lstUpdTs) {
        this.lstUpdTs = lstUpdTs;
    }

    @Basic
    @Column(name = "THIRD_ID")
    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    @Basic
    @Column(name = "FKS_META_T", insertable = false, updatable = false)
    public String getFksMetaT() {
        return fksMetaT;
    }

    public void setFksMetaT(String fksMetaT) {
        this.fksMetaT = fksMetaT;
    }

    @Basic
    @Column(name = "LONG_DSC")
    public String getLongDsc() {
        return longDsc;
    }

    public void setLongDsc(String longDsc) {
        this.longDsc = longDsc;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    @Transient
    public Serializable getPrimaryKey() {
        return getSysId();
    }
}
