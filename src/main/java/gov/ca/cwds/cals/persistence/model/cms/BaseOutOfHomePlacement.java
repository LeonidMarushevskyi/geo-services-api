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
public abstract class BaseOutOfHomePlacement implements IBaseOutOfHomePlacement, PersistentObject {

  private static final long serialVersionUID = 8899107757146812646L;

  private String identifier;
  private String fkplcHmT;
  private LocalDate agrEffDt;
  private String aprvlNo;
  private Short apvStc;
  private LocalDate chdpRfDt;
  private String chdpRqind;
  private String dfprntInd;
  private String soc158Doc;
  private String afdcPrdoc;
  private String agnfpAdoc;
  private String agnghAdoc;
  private String emrgPlind;
  private LocalDate endDt;
  private String exmpHmind;
  private String ghmPlcind;
  private LocalDate intNtcDt;
  private Short payeetpc;
  private String pndLicind;
  private Short plcgRnc;
  private String programNo;
  private Short scpRltc;
  private String extApvno;
  private Short xtApvStc;
  private LocalDate startDt;
  private LocalDate payeeEndt;
  private String subpFstnm;
  private String subpLstnm;
  private String subpMidnm;
  private LocalDate pyeStrtdt;
  private String youakmCd;
  private String lstUpdId;
  private Timestamp lstUpdTs;
  private String fkplcEpst;
  private String fkplcEps0;
  private String plRtnldsc;
  private String remvlDsc;
  private String scproxind;
  private LocalDate hepDt;
  private Short sbplrsnc;
  private String sibplcTxt;
  private String scproxTxt;
  private String grddepInd;
  private String schPplCd;
  private String sibtghrCd;
  private String tdcnslInd;
  private LocalDate tdagrDt;
  private String cpwnmdInd;
  private Short cpwnmdCnt;

  @Id
  @javax.persistence.Column(name = "IDENTIFIER", nullable = false, length = 10)
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Id
  @javax.persistence.Column(name = "fkplc_hm_t", nullable = false, length = 10)
  public String getFkplcHmT() {
    return fkplcHmT;
  }

  public void setFkplcHmT(String fkplcHmT) {
    this.fkplcHmT = fkplcHmT;
  }

  @Basic
  @javax.persistence.Column(name = "AGR_EFF_DT", nullable = true)
  public LocalDate getAgrEffDt() {
    return agrEffDt;
  }

  public void setAgrEffDt(LocalDate agrEffDt) {
    this.agrEffDt = agrEffDt;
  }

  @Basic
  @javax.persistence.Column(name = "APRVL_NO", nullable = true, length = 10)
  public String getAprvlNo() {
    return aprvlNo;
  }

  public void setAprvlNo(String aprvlNo) {
    this.aprvlNo = aprvlNo;
  }

  @Basic
  @javax.persistence.Column(name = "APV_STC", nullable = false)
  public Short getApvStc() {
    return apvStc;
  }

  public void setApvStc(Short apvStc) {
    this.apvStc = apvStc;
  }

  @Basic
  @javax.persistence.Column(name = "CHDP_RF_DT", nullable = true)
  public LocalDate getChdpRfDt() {
    return chdpRfDt;
  }

  public void setChdpRfDt(LocalDate chdpRfDt) {
    this.chdpRfDt = chdpRfDt;
  }

  @Basic
  @javax.persistence.Column(name = "CHDP_RQIND", nullable = false, length = 1)
  public String getChdpRqind() {
    return chdpRqind;
  }

  public void setChdpRqind(String chdpRqind) {
    this.chdpRqind = chdpRqind;
  }

  @Basic
  @javax.persistence.Column(name = "DFPRNT_IND", nullable = false, length = 1)
  public String getDfprntInd() {
    return dfprntInd;
  }

  public void setDfprntInd(String dfprntInd) {
    this.dfprntInd = dfprntInd;
  }

  @Basic
  @javax.persistence.Column(name = "SOC158_DOC", nullable = true, length = 10)
  public String getSoc158Doc() {
    return soc158Doc;
  }

  public void setSoc158Doc(String soc158Doc) {
    this.soc158Doc = soc158Doc;
  }

  @Basic
  @javax.persistence.Column(name = "AFDC_PRDOC", nullable = true, length = 10)
  public String getAfdcPrdoc() {
    return afdcPrdoc;
  }

  public void setAfdcPrdoc(String afdcPrdoc) {
    this.afdcPrdoc = afdcPrdoc;
  }

  @Basic
  @javax.persistence.Column(name = "AGNFP_ADOC", nullable = true, length = 10)
  public String getAgnfpAdoc() {
    return agnfpAdoc;
  }

  public void setAgnfpAdoc(String agnfpAdoc) {
    this.agnfpAdoc = agnfpAdoc;
  }

  @Basic
  @javax.persistence.Column(name = "AGNGH_ADOC", nullable = true, length = 10)
  public String getAgnghAdoc() {
    return agnghAdoc;
  }

  public void setAgnghAdoc(String agnghAdoc) {
    this.agnghAdoc = agnghAdoc;
  }

  @Basic
  @javax.persistence.Column(name = "EMRG_PLIND", nullable = false, length = 1)
  public String getEmrgPlind() {
    return emrgPlind;
  }

  public void setEmrgPlind(String emrgPlind) {
    this.emrgPlind = emrgPlind;
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
  @javax.persistence.Column(name = "EXMP_HMIND", nullable = false, length = 1)
  public String getExmpHmind() {
    return exmpHmind;
  }

  public void setExmpHmind(String exmpHmind) {
    this.exmpHmind = exmpHmind;
  }

  @Basic
  @javax.persistence.Column(name = "GHM_PLCIND", nullable = false, length = 1)
  public String getGhmPlcind() {
    return ghmPlcind;
  }

  public void setGhmPlcind(String ghmPlcind) {
    this.ghmPlcind = ghmPlcind;
  }

  @Basic
  @javax.persistence.Column(name = "INT_NTC_DT", nullable = true)
  public LocalDate getIntNtcDt() {
    return intNtcDt;
  }

  public void setIntNtcDt(LocalDate intNtcDt) {
    this.intNtcDt = intNtcDt;
  }

  @Basic
  @javax.persistence.Column(name = "PAYEETPC", nullable = false)
  public Short getPayeetpc() {
    return payeetpc;
  }

  public void setPayeetpc(Short payeetpc) {
    this.payeetpc = payeetpc;
  }

  @Basic
  @javax.persistence.Column(name = "PND_LICIND", nullable = false, length = 1)
  public String getPndLicind() {
    return pndLicind;
  }

  public void setPndLicind(String pndLicind) {
    this.pndLicind = pndLicind;
  }

  @Basic
  @javax.persistence.Column(name = "PLCG_RNC", nullable = false)
  public Short getPlcgRnc() {
    return plcgRnc;
  }

  public void setPlcgRnc(Short plcgRnc) {
    this.plcgRnc = plcgRnc;
  }

  @Basic
  @javax.persistence.Column(name = "PROGRAM_NO", nullable = false, length = 10)
  public String getProgramNo() {
    return programNo;
  }

  public void setProgramNo(String programNo) {
    this.programNo = programNo;
  }

  @Basic
  @javax.persistence.Column(name = "SCP_RLTC", nullable = false)
  public Short getScpRltc() {
    return scpRltc;
  }

  public void setScpRltc(Short scpRltc) {
    this.scpRltc = scpRltc;
  }

  @Basic
  @javax.persistence.Column(name = "EXT_APVNO", nullable = true, length = 10)
  public String getExtApvno() {
    return extApvno;
  }

  public void setExtApvno(String extApvno) {
    this.extApvno = extApvno;
  }

  @Basic
  @javax.persistence.Column(name = "XT_APV_STC", nullable = false)
  public Short getXtApvStc() {
    return xtApvStc;
  }

  public void setXtApvStc(Short xtApvStc) {
    this.xtApvStc = xtApvStc;
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
  @javax.persistence.Column(name = "PAYEE_ENDT", nullable = true)
  public LocalDate getPayeeEndt() {
    return payeeEndt;
  }

  public void setPayeeEndt(LocalDate payeeEndt) {
    this.payeeEndt = payeeEndt;
  }

  @Basic
  @javax.persistence.Column(name = "SUBP_FSTNM", nullable = false, length = 20)
  public String getSubpFstnm() {
    return subpFstnm;
  }

  public void setSubpFstnm(String subpFstnm) {
    this.subpFstnm = subpFstnm;
  }

  @Basic
  @javax.persistence.Column(name = "SUBP_LSTNM", nullable = false, length = 25)
  public String getSubpLstnm() {
    return subpLstnm;
  }

  public void setSubpLstnm(String subpLstnm) {
    this.subpLstnm = subpLstnm;
  }

  @Basic
  @javax.persistence.Column(name = "SUBP_MIDNM", nullable = false, length = 1)
  public String getSubpMidnm() {
    return subpMidnm;
  }

  public void setSubpMidnm(String subpMidnm) {
    this.subpMidnm = subpMidnm;
  }

  @Basic
  @javax.persistence.Column(name = "PYE_STRTDT", nullable = true)
  public LocalDate getPyeStrtdt() {
    return pyeStrtdt;
  }

  public void setPyeStrtdt(LocalDate pyeStrtdt) {
    this.pyeStrtdt = pyeStrtdt;
  }

  @Basic
  @javax.persistence.Column(name = "YOUAKM_CD", nullable = false, length = 1)
  public String getYouakmCd() {
    return youakmCd;
  }

  public void setYouakmCd(String youakmCd) {
    this.youakmCd = youakmCd;
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
  @javax.persistence.Column(name = "FKPLC_EPST", nullable = false, length = 10)
  public String getFkplcEpst() {
    return fkplcEpst;
  }

  public void setFkplcEpst(String fkplcEpst) {
    this.fkplcEpst = fkplcEpst;
  }

  @Basic
  @javax.persistence.Column(name = "FKPLC_EPS0", nullable = false, length = 10)
  public String getFkplcEps0() {
    return fkplcEps0;
  }

  public void setFkplcEps0(String fkplcEps0) {
    this.fkplcEps0 = fkplcEps0;
  }

  @Basic
  @javax.persistence.Column(name = "PL_RTNLDSC", nullable = false, length = 254)
  public String getPlRtnldsc() {
    return plRtnldsc;
  }

  public void setPlRtnldsc(String plRtnldsc) {
    this.plRtnldsc = plRtnldsc;
  }

  @Basic
  @javax.persistence.Column(name = "REMVL_DSC", nullable = false, length = 210)
  public String getRemvlDsc() {
    return remvlDsc;
  }

  public void setRemvlDsc(String remvlDsc) {
    this.remvlDsc = remvlDsc;
  }

  @Basic
  @javax.persistence.Column(name = "SCPROXIND", nullable = false, length = 1)
  public String getScproxind() {
    return scproxind;
  }

  public void setScproxind(String scproxind) {
    this.scproxind = scproxind;
  }

  @Basic
  @javax.persistence.Column(name = "HEP_DT", nullable = true)
  public LocalDate getHepDt() {
    return hepDt;
  }

  public void setHepDt(LocalDate hepDt) {
    this.hepDt = hepDt;
  }

  @Basic
  @javax.persistence.Column(name = "SBPLRSNC", nullable = false)
  public Short getSbplrsnc() {
    return sbplrsnc;
  }

  public void setSbplrsnc(Short sbplrsnc) {
    this.sbplrsnc = sbplrsnc;
  }

  @Basic
  @javax.persistence.Column(name = "SIBPLC_TXT", nullable = true, length = 10)
  public String getSibplcTxt() {
    return sibplcTxt;
  }

  public void setSibplcTxt(String sibplcTxt) {
    this.sibplcTxt = sibplcTxt;
  }

  @Basic
  @javax.persistence.Column(name = "SCPROX_TXT", nullable = true, length = 10)
  public String getScproxTxt() {
    return scproxTxt;
  }

  public void setScproxTxt(String scproxTxt) {
    this.scproxTxt = scproxTxt;
  }

  @Basic
  @javax.persistence.Column(name = "GRDDEP_IND", nullable = false, length = 1)
  public String getGrddepInd() {
    return grddepInd;
  }

  public void setGrddepInd(String grddepInd) {
    this.grddepInd = grddepInd;
  }

  @Basic
  @javax.persistence.Column(name = "SCH_PPL_CD", nullable = true, length = 2)
  public String getSchPplCd() {
    return schPplCd;
  }

  public void setSchPplCd(String schPplCd) {
    this.schPplCd = schPplCd;
  }

  @Basic
  @javax.persistence.Column(name = "SIBTGHR_CD", nullable = true, length = 2)
  public String getSibtghrCd() {
    return sibtghrCd;
  }

  public void setSibtghrCd(String sibtghrCd) {
    this.sibtghrCd = sibtghrCd;
  }

  @Basic
  @javax.persistence.Column(name = "TDCNSL_IND", nullable = false, length = 1)
  public String getTdcnslInd() {
    return tdcnslInd;
  }

  public void setTdcnslInd(String tdcnslInd) {
    this.tdcnslInd = tdcnslInd;
  }

  @Basic
  @javax.persistence.Column(name = "TDAGR_DT", nullable = true)
  public LocalDate getTdagrDt() {
    return tdagrDt;
  }

  public void setTdagrDt(LocalDate tdagrDt) {
    this.tdagrDt = tdagrDt;
  }

  @Basic
  @javax.persistence.Column(name = "CPWNMD_IND", nullable = false, length = 1)
  public String getCpwnmdInd() {
    return cpwnmdInd;
  }

  public void setCpwnmdInd(String cpwnmdInd) {
    this.cpwnmdInd = cpwnmdInd;
  }

  @Basic
  @javax.persistence.Column(name = "CPWNMD_CNT", nullable = true)
  public Short getCpwnmdCnt() {
    return cpwnmdCnt;
  }

  public void setCpwnmdCnt(Short cpwnmdCnt) {
    this.cpwnmdCnt = cpwnmdCnt;
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
