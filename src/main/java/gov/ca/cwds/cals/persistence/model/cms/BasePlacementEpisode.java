package gov.ca.cwds.cals.persistence.model.cms;

import gov.ca.cwds.data.persistence.PersistentObject;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author CWDS CALS API Team
 */
@MappedSuperclass
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public abstract class BasePlacementEpisode implements IBasePlacementEpisode, PersistentObject {

    private static final long serialVersionUID = -3903845942588945919L;

    private County county;
    private LocalDate removalDt;
    private Short agyRspc;
    private String asgnSwCd;
    private String eligWkCd;
    private String chlRgtCd;
    private LocalDate detnordDt;
    private LocalDate dspOrdDt;
    private LocalDate plepsEndt;
    private String nfcPlctB;
    private LocalDate outCstDt;
    private Time outCstTm;
    private LocalDate petnFildt;
    private String fcisrvwtB;
    private String fcishrgtB;
    private Short prvtSvc;
    private Short rlsRsnc;
    private Short rmvRsnc;
    private Time removalTm;
    private String rmvByCd;
    private String rmvFrmNm;
    private Short rmvFrm1C;
    private String tmpCstind;
    private String lstUpdId;
    private Timestamp lstUpdTs;
    private String fkclientT;
    private String thirdId;
    private String comntDsc;
    private LocalDate endEntDt;
    private LocalDate rmvEntDt;
    private String rmvcr1Id;
    private String rmvcr1Cd;
    private String rmvcr2Id;
    private String rmvcr2Cd;
    private Short rmvFrm2C;
    private String termRsCd;
    private String termDsc;
    private Short termTyC;
    private String fmlystrCd;
    private String birthyr1;
    private String birthyr2;
    private String rsfsurbNm;
    private Short gvrEntc;
    private String plc24HrCd;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "GVR_ENTC", referencedColumnName = "SYS_ID", insertable = false, updatable = false)
    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Basic
    @javax.persistence.Column(name = "REMOVAL_DT", nullable = false)
    public LocalDate getRemovalDt() {
        return removalDt;
    }

    public void setRemovalDt(LocalDate removalDt) {
        this.removalDt = removalDt;
    }

    @Basic
    @javax.persistence.Column(name = "AGY_RSPC", nullable = false)
    public Short getAgyRspc() {
        return agyRspc;
    }

    public void setAgyRspc(Short agyRspc) {
        this.agyRspc = agyRspc;
    }

    @Basic
    @javax.persistence.Column(name = "ASGN_SW_CD", nullable = false, length = 9)
    public String getAsgnSwCd() {
        return asgnSwCd;
    }

    public void setAsgnSwCd(String asgnSwCd) {
        this.asgnSwCd = asgnSwCd;
    }

    @Basic
    @javax.persistence.Column(name = "ELIG_WK_CD", nullable = false, length = 9)
    public String getEligWkCd() {
        return eligWkCd;
    }

    public void setEligWkCd(String eligWkCd) {
        this.eligWkCd = eligWkCd;
    }

    @Basic
    @javax.persistence.Column(name = "CHL_RGT_CD", nullable = false, length = 2)
    public String getChlRgtCd() {
        return chlRgtCd;
    }

    public void setChlRgtCd(String chlRgtCd) {
        this.chlRgtCd = chlRgtCd;
    }

    @Basic
    @javax.persistence.Column(name = "DETNORD_DT", nullable = true)
    public LocalDate getDetnordDt() {
        return detnordDt;
    }

    public void setDetnordDt(LocalDate detnordDt) {
        this.detnordDt = detnordDt;
    }

    @Basic
    @javax.persistence.Column(name = "DSP_ORD_DT", nullable = true)
    public LocalDate getDspOrdDt() {
        return dspOrdDt;
    }

    public void setDspOrdDt(LocalDate dspOrdDt) {
        this.dspOrdDt = dspOrdDt;
    }

    @Basic
    @javax.persistence.Column(name = "PLEPS_ENDT", nullable = true)
    public LocalDate getPlepsEndt() {
        return plepsEndt;
    }

    public void setPlepsEndt(LocalDate plepsEndt) {
        this.plepsEndt = plepsEndt;
    }

    @Basic
    @javax.persistence.Column(name = "NFC_PLCT_B", nullable = false, length = 1)
    public String getNfcPlctB() {
        return nfcPlctB;
    }

    public void setNfcPlctB(String nfcPlctB) {
        this.nfcPlctB = nfcPlctB;
    }

    @Basic
    @javax.persistence.Column(name = "OUT_CST_DT", nullable = true)
    public LocalDate getOutCstDt() {
        return outCstDt;
    }

    public void setOutCstDt(LocalDate outCstDt) {
        this.outCstDt = outCstDt;
    }

    @Basic
    @javax.persistence.Column(name = "OUT_CST_TM", nullable = true)
    public Time getOutCstTm() {
        return outCstTm;
    }

    public void setOutCstTm(Time outCstTm) {
        this.outCstTm = outCstTm;
    }

    @Basic
    @javax.persistence.Column(name = "PETN_FILDT", nullable = true)
    public LocalDate getPetnFildt() {
        return petnFildt;
    }

    public void setPetnFildt(LocalDate petnFildt) {
        this.petnFildt = petnFildt;
    }

    @Basic
    @javax.persistence.Column(name = "FCISRVWT_B", nullable = false, length = 1)
    public String getFcisrvwtB() {
        return fcisrvwtB;
    }

    public void setFcisrvwtB(String fcisrvwtB) {
        this.fcisrvwtB = fcisrvwtB;
    }

    @Basic
    @javax.persistence.Column(name = "FCISHRGT_B", nullable = false, length = 1)
    public String getFcishrgtB() {
        return fcishrgtB;
    }

    public void setFcishrgtB(String fcishrgtB) {
        this.fcishrgtB = fcishrgtB;
    }

    @Basic
    @javax.persistence.Column(name = "PRVT_SVC", nullable = false)
    public Short getPrvtSvc() {
        return prvtSvc;
    }

    public void setPrvtSvc(Short prvtSvc) {
        this.prvtSvc = prvtSvc;
    }

    @Basic
    @javax.persistence.Column(name = "RLS_RSNC", nullable = false)
    public Short getRlsRsnc() {
        return rlsRsnc;
    }

    public void setRlsRsnc(Short rlsRsnc) {
        this.rlsRsnc = rlsRsnc;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_RSNC", nullable = false)
    public Short getRmvRsnc() {
        return rmvRsnc;
    }

    public void setRmvRsnc(Short rmvRsnc) {
        this.rmvRsnc = rmvRsnc;
    }

    @Basic
    @javax.persistence.Column(name = "REMOVAL_TM", nullable = false)
    public Time getRemovalTm() {
        return removalTm;
    }

    public void setRemovalTm(Time removalTm) {
        this.removalTm = removalTm;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_BY_CD", nullable = true, length = 1)
    public String getRmvByCd() {
        return rmvByCd;
    }

    public void setRmvByCd(String rmvByCd) {
        this.rmvByCd = rmvByCd;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_FRM_NM", nullable = false, length = 35)
    public String getRmvFrmNm() {
        return rmvFrmNm;
    }

    public void setRmvFrmNm(String rmvFrmNm) {
        this.rmvFrmNm = rmvFrmNm;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_FRM1C", nullable = false)
    public Short getRmvFrm1C() {
        return rmvFrm1C;
    }

    public void setRmvFrm1C(Short rmvFrm1C) {
        this.rmvFrm1C = rmvFrm1C;
    }

    @Basic
    @javax.persistence.Column(name = "TMP_CSTIND", nullable = false, length = 1)
    public String getTmpCstind() {
        return tmpCstind;
    }

    public void setTmpCstind(String tmpCstind) {
        this.tmpCstind = tmpCstind;
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
    @javax.persistence.Column(name = "FKCLIENT_T", nullable = false, length = 10)
    public String getFkclientT() {
        return fkclientT;
    }

    public void setFkclientT(String fkclientT) {
        this.fkclientT = fkclientT;
    }

    @Id
    @javax.persistence.Column(name = "THIRD_ID", nullable = false, length = 10)
    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    @Basic
    @javax.persistence.Column(name = "COMNT_DSC", nullable = false, length = 254)
    public String getComntDsc() {
        return comntDsc;
    }

    public void setComntDsc(String comntDsc) {
        this.comntDsc = comntDsc;
    }

    @Basic
    @javax.persistence.Column(name = "END_ENT_DT", nullable = true)
    public LocalDate getEndEntDt() {
        return endEntDt;
    }

    public void setEndEntDt(LocalDate endEntDt) {
        this.endEntDt = endEntDt;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_ENT_DT", nullable = false)
    public LocalDate getRmvEntDt() {
        return rmvEntDt;
    }

    public void setRmvEntDt(LocalDate rmvEntDt) {
        this.rmvEntDt = rmvEntDt;
    }

    @Basic
    @javax.persistence.Column(name = "RMVCR1_ID", nullable = true, length = 10)
    public String getRmvcr1Id() {
        return rmvcr1Id;
    }

    public void setRmvcr1Id(String rmvcr1Id) {
        this.rmvcr1Id = rmvcr1Id;
    }

    @Basic
    @javax.persistence.Column(name = "RMVCR1_CD", nullable = true, length = 1)
    public String getRmvcr1Cd() {
        return rmvcr1Cd;
    }

    public void setRmvcr1Cd(String rmvcr1Cd) {
        this.rmvcr1Cd = rmvcr1Cd;
    }

    @Basic
    @javax.persistence.Column(name = "RMVCR2_ID", nullable = true, length = 10)
    public String getRmvcr2Id() {
        return rmvcr2Id;
    }

    public void setRmvcr2Id(String rmvcr2Id) {
        this.rmvcr2Id = rmvcr2Id;
    }

    @Basic
    @javax.persistence.Column(name = "RMVCR2_CD", nullable = true, length = 1)
    public String getRmvcr2Cd() {
        return rmvcr2Cd;
    }

    public void setRmvcr2Cd(String rmvcr2Cd) {
        this.rmvcr2Cd = rmvcr2Cd;
    }

    @Basic
    @javax.persistence.Column(name = "RMV_FRM2C", nullable = false)
    public Short getRmvFrm2C() {
        return rmvFrm2C;
    }

    public void setRmvFrm2C(Short rmvFrm2C) {
        this.rmvFrm2C = rmvFrm2C;
    }

    @Basic
    @javax.persistence.Column(name = "TERM_RS_CD", nullable = false, length = 1)
    public String getTermRsCd() {
        return termRsCd;
    }

    public void setTermRsCd(String termRsCd) {
        this.termRsCd = termRsCd;
    }

    @Basic
    @javax.persistence.Column(name = "TERM_DSC", nullable = false, length = 210)
    public String getTermDsc() {
        return termDsc;
    }

    public void setTermDsc(String termDsc) {
        this.termDsc = termDsc;
    }

    @Basic
    @javax.persistence.Column(name = "TERM_TY_C", nullable = false)
    public Short getTermTyC() {
        return termTyC;
    }

    public void setTermTyC(Short termTyC) {
        this.termTyC = termTyC;
    }

    @Basic
    @javax.persistence.Column(name = "FMLYSTR_CD", nullable = false, length = 1)
    public String getFmlystrCd() {
        return fmlystrCd;
    }

    public void setFmlystrCd(String fmlystrCd) {
        this.fmlystrCd = fmlystrCd;
    }

    @Basic
    @javax.persistence.Column(name = "BIRTHYR1", nullable = false, length = 4)
    public String getBirthyr1() {
        return birthyr1;
    }

    public void setBirthyr1(String birthyr1) {
        this.birthyr1 = birthyr1;
    }

    @Basic
    @javax.persistence.Column(name = "BIRTHYR2", nullable = false, length = 4)
    public String getBirthyr2() {
        return birthyr2;
    }

    public void setBirthyr2(String birthyr2) {
        this.birthyr2 = birthyr2;
    }

    @Basic
    @javax.persistence.Column(name = "RSFSURB_NM", nullable = true, length = 40)
    public String getRsfsurbNm() {
        return rsfsurbNm;
    }

    public void setRsfsurbNm(String rsfsurbNm) {
        this.rsfsurbNm = rsfsurbNm;
    }

    @Basic
    @javax.persistence.Column(name = "GVR_ENTC", nullable = true)
    public Short getGvrEntc() {
        return gvrEntc;
    }

    public void setGvrEntc(Short gvrEntc) {
        this.gvrEntc = gvrEntc;
    }

    @Basic
    @javax.persistence.Column(name = "PLC24HR_CD", nullable = true, length = 1)
    public String getPlc24HrCd() {
        return plc24HrCd;
    }

    public void setPlc24HrCd(String plc24HrCd) {
        this.plc24HrCd = plc24HrCd;
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
        return getFkclientT();
    }
}
