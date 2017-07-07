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
public abstract class BaseClient implements IClient, PersistentObject {
    private static final long serialVersionUID = -1570433180700848830L;

    private String identifier;
    private String adptnStcd;
    private String alnRegNo;
    private LocalDate birthDt;
    private String brFacNm;
    private Short bStateC;
    private Short bCntryC;
    private String chldCltB;
    private String comFstNm;
    private String comLstNm;
    private String comMidNm;
    private String confEfind;
    private LocalDate confActdt;
    private LocalDate creatnDt;
    private LocalDate deathDt;
    private String dthRnTxt;
    private String drvLicNo;
    private Short dStateC;
    private String genderCd;
    private Short iCntryC;
    private Short imgtStc;
    private String incapcCd;
    private String litrateCd;
    private String marHistB;
    private Short mrtlStc;
    private String miltStacd;
    private String nmprfxDsc;
    private Short nameTpc;
    private String outwrtInd;
    private Short pEthnctyc;
    private Short pLangTpc;
    private Short rlgnTpc;
    private Short sLangTc;
    private String senstvInd;
    private String sntvHlind;
    private String ssNo;
    private String ssnChgCd;
    private String sufxTldsc;
    private String unemplyCd;
    private String lstUpdId;
    private Timestamp lstUpdTs;
    private String commntDsc;
    private String estDobCd;
    private String bpVerInd;
    private String hispCd;
    private String currcaInd;
    private String curregInd;
    private String cothDesc;
    private String prevcaInd;
    private String preregInd;
    private String pothDesc;
    private String hcareInd;
    private String limitInd;
    private String birthCity;
    private String healthTxt;
    private LocalDate mtermDt;
    private LocalDate ftermDt;
    private String zippyInd;
    private String deathPlc;
    private String trMbvrtB;
    private String trbaCltB;
    private String soc158Ind;
    private String dthDtInd;
    private String emailAddr;
    private String adjdelInd;
    private String ethUdCd;
    private String hispUdCd;
    private String socplcCd;
    private String clIndxNo;

    @Id
    @javax.persistence.Column(name = "IDENTIFIER", nullable = false, length = 10)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @javax.persistence.Column(name = "ADPTN_STCD", nullable = false, length = 1)
    public String getAdptnStcd() {
        return adptnStcd;
    }

    public void setAdptnStcd(String adptnStcd) {
        this.adptnStcd = adptnStcd;
    }

    @Basic
    @javax.persistence.Column(name = "ALN_REG_NO", nullable = false, length = 12)
    public String getAlnRegNo() {
        return alnRegNo;
    }

    public void setAlnRegNo(String alnRegNo) {
        this.alnRegNo = alnRegNo;
    }

    @Basic
    @javax.persistence.Column(name = "BIRTH_DT", nullable = true)
    public LocalDate getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(LocalDate birthDt) {
        this.birthDt = birthDt;
    }

    @Basic
    @javax.persistence.Column(name = "BR_FAC_NM", nullable = false, length = 35)
    public String getBrFacNm() {
        return brFacNm;
    }

    public void setBrFacNm(String brFacNm) {
        this.brFacNm = brFacNm;
    }

    @Basic
    @javax.persistence.Column(name = "B_STATE_C", nullable = false)
    public Short getbStateC() {
        return bStateC;
    }

    public void setbStateC(Short bStateC) {
        this.bStateC = bStateC;
    }

    @Basic
    @javax.persistence.Column(name = "B_CNTRY_C", nullable = false)
    public Short getbCntryC() {
        return bCntryC;
    }

    public void setbCntryC(Short bCntryC) {
        this.bCntryC = bCntryC;
    }

    @Basic
    @javax.persistence.Column(name = "CHLD_CLT_B", nullable = false, length = 1)
    public String getChldCltB() {
        return chldCltB;
    }

    public void setChldCltB(String chldCltB) {
        this.chldCltB = chldCltB;
    }

    @Basic
    @javax.persistence.Column(name = "COM_FST_NM", nullable = false, length = 20)
    public String getComFstNm() {
        return comFstNm;
    }

    public void setComFstNm(String comFstNm) {
        this.comFstNm = comFstNm;
    }

    @Basic
    @javax.persistence.Column(name = "COM_LST_NM", nullable = false, length = 25)
    public String getComLstNm() {
        return comLstNm;
    }

    public void setComLstNm(String comLstNm) {
        this.comLstNm = comLstNm;
    }

    @Basic
    @javax.persistence.Column(name = "COM_MID_NM", nullable = false, length = 20)
    public String getComMidNm() {
        return comMidNm;
    }

    public void setComMidNm(String comMidNm) {
        this.comMidNm = comMidNm;
    }

    @Basic
    @javax.persistence.Column(name = "CONF_EFIND", nullable = false, length = 1)
    public String getConfEfind() {
        return confEfind;
    }

    public void setConfEfind(String confEfind) {
        this.confEfind = confEfind;
    }

    @Basic
    @javax.persistence.Column(name = "CONF_ACTDT", nullable = true)
    public LocalDate getConfActdt() {
        return confActdt;
    }

    public void setConfActdt(LocalDate confActdt) {
        this.confActdt = confActdt;
    }

    @Basic
    @javax.persistence.Column(name = "CREATN_DT", nullable = false)
    public LocalDate getCreatnDt() {
        return creatnDt;
    }

    public void setCreatnDt(LocalDate creatnDt) {
        this.creatnDt = creatnDt;
    }

    @Basic
    @javax.persistence.Column(name = "DEATH_DT", nullable = true)
    public LocalDate getDeathDt() {
        return deathDt;
    }

    public void setDeathDt(LocalDate deathDt) {
        this.deathDt = deathDt;
    }

    @Basic
    @javax.persistence.Column(name = "DTH_RN_TXT", nullable = true, length = 10)
    public String getDthRnTxt() {
        return dthRnTxt;
    }

    public void setDthRnTxt(String dthRnTxt) {
        this.dthRnTxt = dthRnTxt;
    }

    @Basic
    @javax.persistence.Column(name = "DRV_LIC_NO", nullable = false, length = 20)
    public String getDrvLicNo() {
        return drvLicNo;
    }

    public void setDrvLicNo(String drvLicNo) {
        this.drvLicNo = drvLicNo;
    }

    @Basic
    @javax.persistence.Column(name = "D_STATE_C", nullable = false)
    public Short getdStateC() {
        return dStateC;
    }

    public void setdStateC(Short dStateC) {
        this.dStateC = dStateC;
    }

    @Basic
    @javax.persistence.Column(name = "GENDER_CD", nullable = false, length = 1)
    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
    }

    @Basic
    @javax.persistence.Column(name = "I_CNTRY_C", nullable = false)
    public Short getiCntryC() {
        return iCntryC;
    }

    public void setiCntryC(Short iCntryC) {
        this.iCntryC = iCntryC;
    }

    @Basic
    @javax.persistence.Column(name = "IMGT_STC", nullable = false)
    public Short getImgtStc() {
        return imgtStc;
    }

    public void setImgtStc(Short imgtStc) {
        this.imgtStc = imgtStc;
    }

    @Basic
    @javax.persistence.Column(name = "INCAPC_CD", nullable = false, length = 2)
    public String getIncapcCd() {
        return incapcCd;
    }

    public void setIncapcCd(String incapcCd) {
        this.incapcCd = incapcCd;
    }

    @Basic
    @javax.persistence.Column(name = "LITRATE_CD", nullable = false, length = 1)
    public String getLitrateCd() {
        return litrateCd;
    }

    public void setLitrateCd(String litrateCd) {
        this.litrateCd = litrateCd;
    }

    @Basic
    @javax.persistence.Column(name = "MAR_HIST_B", nullable = false, length = 1)
    public String getMarHistB() {
        return marHistB;
    }

    public void setMarHistB(String marHistB) {
        this.marHistB = marHistB;
    }

    @Basic
    @javax.persistence.Column(name = "MRTL_STC", nullable = false)
    public Short getMrtlStc() {
        return mrtlStc;
    }

    public void setMrtlStc(Short mrtlStc) {
        this.mrtlStc = mrtlStc;
    }

    @Basic
    @javax.persistence.Column(name = "MILT_STACD", nullable = false, length = 1)
    public String getMiltStacd() {
        return miltStacd;
    }

    public void setMiltStacd(String miltStacd) {
        this.miltStacd = miltStacd;
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
    @javax.persistence.Column(name = "NAME_TPC", nullable = false)
    public Short getNameTpc() {
        return nameTpc;
    }

    public void setNameTpc(Short nameTpc) {
        this.nameTpc = nameTpc;
    }

    @Basic
    @javax.persistence.Column(name = "OUTWRT_IND", nullable = false, length = 1)
    public String getOutwrtInd() {
        return outwrtInd;
    }

    public void setOutwrtInd(String outwrtInd) {
        this.outwrtInd = outwrtInd;
    }

    @Basic
    @javax.persistence.Column(name = "P_ETHNCTYC", nullable = false)
    public Short getpEthnctyc() {
        return pEthnctyc;
    }

    public void setpEthnctyc(Short pEthnctyc) {
        this.pEthnctyc = pEthnctyc;
    }

    @Basic
    @javax.persistence.Column(name = "P_LANG_TPC", nullable = false)
    public Short getpLangTpc() {
        return pLangTpc;
    }

    public void setpLangTpc(Short pLangTpc) {
        this.pLangTpc = pLangTpc;
    }

    @Basic
    @javax.persistence.Column(name = "RLGN_TPC", nullable = false)
    public Short getRlgnTpc() {
        return rlgnTpc;
    }

    public void setRlgnTpc(Short rlgnTpc) {
        this.rlgnTpc = rlgnTpc;
    }

    @Basic
    @javax.persistence.Column(name = "S_LANG_TC", nullable = false)
    public Short getsLangTc() {
        return sLangTc;
    }

    public void setsLangTc(Short sLangTc) {
        this.sLangTc = sLangTc;
    }

    @Basic
    @javax.persistence.Column(name = "SENSTV_IND", nullable = false, length = 1)
    public String getSenstvInd() {
        return senstvInd;
    }

    public void setSenstvInd(String senstvInd) {
        this.senstvInd = senstvInd;
    }

    @Basic
    @javax.persistence.Column(name = "SNTV_HLIND", nullable = false, length = 1)
    public String getSntvHlind() {
        return sntvHlind;
    }

    public void setSntvHlind(String sntvHlind) {
        this.sntvHlind = sntvHlind;
    }

    @Basic
    @javax.persistence.Column(name = "SS_NO", nullable = false, length = 9)
    public String getSsNo() {
        return ssNo;
    }

    public void setSsNo(String ssNo) {
        this.ssNo = ssNo;
    }

    @Basic
    @javax.persistence.Column(name = "SSN_CHG_CD", nullable = false, length = 1)
    public String getSsnChgCd() {
        return ssnChgCd;
    }

    public void setSsnChgCd(String ssnChgCd) {
        this.ssnChgCd = ssnChgCd;
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
    @javax.persistence.Column(name = "UNEMPLY_CD", nullable = false, length = 2)
    public String getUnemplyCd() {
        return unemplyCd;
    }

    public void setUnemplyCd(String unemplyCd) {
        this.unemplyCd = unemplyCd;
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
    @javax.persistence.Column(name = "COMMNT_DSC", nullable = false, length = 120)
    public String getCommntDsc() {
        return commntDsc;
    }

    public void setCommntDsc(String commntDsc) {
        this.commntDsc = commntDsc;
    }

    @Basic
    @javax.persistence.Column(name = "EST_DOB_CD", nullable = false, length = 1)
    public String getEstDobCd() {
        return estDobCd;
    }

    public void setEstDobCd(String estDobCd) {
        this.estDobCd = estDobCd;
    }

    @Basic
    @javax.persistence.Column(name = "BP_VER_IND", nullable = false, length = 1)
    public String getBpVerInd() {
        return bpVerInd;
    }

    public void setBpVerInd(String bpVerInd) {
        this.bpVerInd = bpVerInd;
    }

    @Basic
    @javax.persistence.Column(name = "HISP_CD", nullable = false, length = 1)
    public String getHispCd() {
        return hispCd;
    }

    public void setHispCd(String hispCd) {
        this.hispCd = hispCd;
    }

    @Basic
    @javax.persistence.Column(name = "CURRCA_IND", nullable = false, length = 1)
    public String getCurrcaInd() {
        return currcaInd;
    }

    public void setCurrcaInd(String currcaInd) {
        this.currcaInd = currcaInd;
    }

    @Basic
    @javax.persistence.Column(name = "CURREG_IND", nullable = false, length = 1)
    public String getCurregInd() {
        return curregInd;
    }

    public void setCurregInd(String curregInd) {
        this.curregInd = curregInd;
    }

    @Basic
    @javax.persistence.Column(name = "COTH_DESC", nullable = false, length = 25)
    public String getCothDesc() {
        return cothDesc;
    }

    public void setCothDesc(String cothDesc) {
        this.cothDesc = cothDesc;
    }

    @Basic
    @javax.persistence.Column(name = "PREVCA_IND", nullable = false, length = 1)
    public String getPrevcaInd() {
        return prevcaInd;
    }

    public void setPrevcaInd(String prevcaInd) {
        this.prevcaInd = prevcaInd;
    }

    @Basic
    @javax.persistence.Column(name = "PREREG_IND", nullable = false, length = 1)
    public String getPreregInd() {
        return preregInd;
    }

    public void setPreregInd(String preregInd) {
        this.preregInd = preregInd;
    }

    @Basic
    @javax.persistence.Column(name = "POTH_DESC", nullable = false, length = 25)
    public String getPothDesc() {
        return pothDesc;
    }

    public void setPothDesc(String pothDesc) {
        this.pothDesc = pothDesc;
    }

    @Basic
    @javax.persistence.Column(name = "HCARE_IND", nullable = false, length = 1)
    public String getHcareInd() {
        return hcareInd;
    }

    public void setHcareInd(String hcareInd) {
        this.hcareInd = hcareInd;
    }

    @Basic
    @javax.persistence.Column(name = "LIMIT_IND", nullable = false, length = 1)
    public String getLimitInd() {
        return limitInd;
    }

    public void setLimitInd(String limitInd) {
        this.limitInd = limitInd;
    }

    @Basic
    @javax.persistence.Column(name = "BIRTH_CITY", nullable = false, length = 35)
    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    @Basic
    @javax.persistence.Column(name = "HEALTH_TXT", nullable = true, length = 10)
    public String getHealthTxt() {
        return healthTxt;
    }

    public void setHealthTxt(String healthTxt) {
        this.healthTxt = healthTxt;
    }

    @Basic
    @javax.persistence.Column(name = "MTERM_DT", nullable = true)
    public LocalDate getMtermDt() {
        return mtermDt;
    }

    public void setMtermDt(LocalDate mtermDt) {
        this.mtermDt = mtermDt;
    }

    @Basic
    @javax.persistence.Column(name = "FTERM_DT", nullable = true)
    public LocalDate getFtermDt() {
        return ftermDt;
    }

    public void setFtermDt(LocalDate ftermDt) {
        this.ftermDt = ftermDt;
    }

    @Basic
    @javax.persistence.Column(name = "ZIPPY_IND", nullable = false, length = 1)
    public String getZippyInd() {
        return zippyInd;
    }

    public void setZippyInd(String zippyInd) {
        this.zippyInd = zippyInd;
    }

    @Basic
    @javax.persistence.Column(name = "DEATH_PLC", nullable = true, length = 35)
    public String getDeathPlc() {
        return deathPlc;
    }

    public void setDeathPlc(String deathPlc) {
        this.deathPlc = deathPlc;
    }

    @Basic
    @javax.persistence.Column(name = "TR_MBVRT_B", nullable = false, length = 1)
    public String getTrMbvrtB() {
        return trMbvrtB;
    }

    public void setTrMbvrtB(String trMbvrtB) {
        this.trMbvrtB = trMbvrtB;
    }

    @Basic
    @javax.persistence.Column(name = "TRBA_CLT_B", nullable = false, length = 1)
    public String getTrbaCltB() {
        return trbaCltB;
    }

    public void setTrbaCltB(String trbaCltB) {
        this.trbaCltB = trbaCltB;
    }

    @Basic
    @javax.persistence.Column(name = "SOC158_IND", nullable = false, length = 1)
    public String getSoc158Ind() {
        return soc158Ind;
    }

    public void setSoc158Ind(String soc158Ind) {
        this.soc158Ind = soc158Ind;
    }

    @Basic
    @javax.persistence.Column(name = "DTH_DT_IND", nullable = false, length = 1)
    public String getDthDtInd() {
        return dthDtInd;
    }

    public void setDthDtInd(String dthDtInd) {
        this.dthDtInd = dthDtInd;
    }

    @Basic
    @javax.persistence.Column(name = "EMAIL_ADDR", nullable = true, length = 50)
    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    @Basic
    @javax.persistence.Column(name = "ADJDEL_IND", nullable = true, length = 1)
    public String getAdjdelInd() {
        return adjdelInd;
    }

    public void setAdjdelInd(String adjdelInd) {
        this.adjdelInd = adjdelInd;
    }

    @Basic
    @javax.persistence.Column(name = "ETH_UD_CD", nullable = true, length = 1)
    public String getEthUdCd() {
        return ethUdCd;
    }

    public void setEthUdCd(String ethUdCd) {
        this.ethUdCd = ethUdCd;
    }

    @Basic
    @javax.persistence.Column(name = "HISP_UD_CD", nullable = true, length = 1)
    public String getHispUdCd() {
        return hispUdCd;
    }

    public void setHispUdCd(String hispUdCd) {
        this.hispUdCd = hispUdCd;
    }

    @Basic
    @javax.persistence.Column(name = "SOCPLC_CD", nullable = false, length = 1)
    public String getSocplcCd() {
        return socplcCd;
    }

    public void setSocplcCd(String socplcCd) {
        this.socplcCd = socplcCd;
    }

    @Basic
    @javax.persistence.Column(name = "CL_INDX_NO", nullable = true, length = 12)
    public String getClIndxNo() {
        return clIndxNo;
    }

    public void setClIndxNo(String clIndxNo) {
        this.clIndxNo = clIndxNo;
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
