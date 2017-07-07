package gov.ca.cwds.cals.persistence.model.cms;

import gov.ca.cwds.data.persistence.PersistentObject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */
@MappedSuperclass
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public abstract class BaseStaffPerson implements PersistentObject {

    private static final long serialVersionUID = 5518501308828983601L;

    private County county;
    private String cntySpfcd;
    private String identifier;
    private LocalDate endDt;
    private String firstName;
    private String jobTlDsc;
    private String lastName;
    private String midIniNm;
    private String nmprfxDsc;
    private Long phoneNo;
    private Integer telExtNo;
    private LocalDate startDt;
    private String sufxTldsc;
    private String tlcmtrInd;
    private String lstUpdId;
    private Timestamp lstUpdTs;
    private String fkcwsOfft;
    private String avlocDsc;
    private String ssrsWkrid;
    private String dtywkrInd;
    private String fkcwsaddrt;
    private String emailAddr;

    @Transient
    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Basic
    @javax.persistence.Column(name = "CNTY_SPFCD")
    public String getCntySpfcd() {
        return cntySpfcd;
    }

    public void setCntySpfcd(String cntySpfcd) {
        this.cntySpfcd = cntySpfcd;
    }

    @Id
    @javax.persistence.Column(name = "IDENTIFIER", nullable = false, length = 3)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @javax.persistence.Column(name = "END_DT", nullable = true)
    public LocalDate getEndDt() {
        return endDt;
    }

    public void setEndDt(LocalDate endDt) {
        this.endDt = endDt;
    }

    @Basic
    @javax.persistence.Column(name = "FIRST_NM", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @javax.persistence.Column(name = "JOB_TL_DSC", nullable = false, length = 30)
    public String getJobTlDsc() {
        return jobTlDsc;
    }

    public void setJobTlDsc(String jobTlDsc) {
        this.jobTlDsc = jobTlDsc;
    }

    @Basic
    @javax.persistence.Column(name = "LAST_NM", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @javax.persistence.Column(name = "MID_INI_NM", nullable = false, length = 1)
    public String getMidIniNm() {
        return midIniNm;
    }

    public void setMidIniNm(String midIniNm) {
        this.midIniNm = midIniNm;
    }

    @Basic
    @javax.persistence.Column(name = "NMPRFX_DSC", nullable = false, length = 6)
    public String getNmprfxDsc() {
        return nmprfxDsc;
    }

    public void setNmprfxDsc(String nmprfxDsc) {
        this.nmprfxDsc = nmprfxDsc;
    }

    @Basic
    @javax.persistence.Column(name = "PHONE_NO", nullable = false, precision = 0)
    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @javax.persistence.Column(name = "TEL_EXT_NO", nullable = false)
    public Integer getTelExtNo() {
        return telExtNo;
    }

    public void setTelExtNo(Integer telExtNo) {
        this.telExtNo = telExtNo;
    }

    @Basic
    @javax.persistence.Column(name = "START_DT", nullable = false)
    public LocalDate getStartDt() {
        return startDt;
    }

    public void setStartDt(LocalDate startDt) {
        this.startDt = startDt;
    }

    @Basic
    @javax.persistence.Column(name = "SUFX_TLDSC", nullable = false, length = 4)
    public String getSufxTldsc() {
        return sufxTldsc;
    }

    public void setSufxTldsc(String sufxTldsc) {
        this.sufxTldsc = sufxTldsc;
    }

    @Basic
    @javax.persistence.Column(name = "TLCMTR_IND", nullable = false, length = 1)
    public String getTlcmtrInd() {
        return tlcmtrInd;
    }

    public void setTlcmtrInd(String tlcmtrInd) {
        this.tlcmtrInd = tlcmtrInd;
    }

    @Basic
    @javax.persistence.Column(name = "LST_UPD_ID", nullable = false, length = 3)
    public String getLstUpdId() {
        return lstUpdId;
    }

    public void setLstUpdId(String lstUpdId) {
        this.lstUpdId = lstUpdId;
    }

    @Basic
    @javax.persistence.Column(name = "LST_UPD_TS", nullable = false)
    public Timestamp getLstUpdTs() {
        return lstUpdTs;
    }

    public void setLstUpdTs(Timestamp lstUpdTs) {
        this.lstUpdTs = lstUpdTs;
    }

    @Basic
    @javax.persistence.Column(name = "FKCWS_OFFT", nullable = false, length = 10)
    public String getFkcwsOfft() {
        return fkcwsOfft;
    }

    public void setFkcwsOfft(String fkcwsOfft) {
        this.fkcwsOfft = fkcwsOfft;
    }

    @Basic
    @javax.persistence.Column(name = "AVLOC_DSC", nullable = false, length = 160)
    public String getAvlocDsc() {
        return avlocDsc;
    }

    public void setAvlocDsc(String avlocDsc) {
        this.avlocDsc = avlocDsc;
    }

    @Basic
    @javax.persistence.Column(name = "SSRS_WKRID", nullable = false, length = 4)
    public String getSsrsWkrid() {
        return ssrsWkrid;
    }

    public void setSsrsWkrid(String ssrsWkrid) {
        this.ssrsWkrid = ssrsWkrid;
    }

    @Basic
    @javax.persistence.Column(name = "DTYWKR_IND", nullable = false, length = 1)
    public String getDtywkrInd() {
        return dtywkrInd;
    }

    public void setDtywkrInd(String dtywkrInd) {
        this.dtywkrInd = dtywkrInd;
    }

    @Basic
    @javax.persistence.Column(name = "FKCWSADDRT", nullable = false, length = 10)
    public String getFkcwsaddrt() {
        return fkcwsaddrt;
    }

    public void setFkcwsaddrt(String fkcwsaddrt) {
        this.fkcwsaddrt = fkcwsaddrt;
    }

    @Basic
    @javax.persistence.Column(name = "EMAIL_ADDR", nullable = true, length = 50)
    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
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
        return getIdentifier();
    }
}
