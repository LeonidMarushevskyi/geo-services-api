package gov.ca.cwds.cals.persistence.model.cms;

import gov.ca.cwds.data.persistence.PersistentObject;
import java.io.Serializable;
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
@SuppressWarnings({"squid:S00104", "squid:S3437"}) // Entity can't be splited , LocalDate is serializable
public abstract class BasePlacementHome implements IBasePlacementHome, PersistentObject {

    private static final long serialVersionUID = 8516376534560115438L;

    private FacilityType facilityType;
    private County county;
    private gov.ca.cwds.cals.persistence.model.cms.State stateCode;
    private gov.ca.cwds.cals.persistence.model.cms.State payeeStateCode;
    private gov.ca.cwds.cals.persistence.model.cms.LicenseStatus licenseStatus;
    private String identifier;
    private String licenseNo;
    private Short ageFrmNo;
    private Short ageToNo;
    private String atCapInd;
    private String bckPersnm;
    private Integer bckExtNo;
    private Long bckTelNo;
    private LocalDate certfPndt;
    private String chlcrPlcd;
    private String cityNm;
    private Short clSrvdc;
    private String confEfind;
    private Short curOcpNo;
    private String emrShltcd;
    private Long faxNo;
    private String frgAdrtB;
    private String gndrAcpcd;
    private String geoRgntcd;
    private String inhmVstcd;
    private Short maxCapNo;
    private String laVndrId;
    private LocalDate licAplDt;
    private Short licCapNo;
    private LocalDate licEfctdt;
    private LocalDate licExpDt;
    private LocalDate licStatdt;
    private Short licBsnc;
    private String licnseeNm;
    private String licensrCd;
    private String facltyNm;
    private String oprtdByid;
    private String oprtdBycd;
    private String pCityNm;
    private String pyeFstnm;
    private String pyeLstnm;
    private String pyeMidnm;
    private String pstreetNm;
    private String pstreetNo;
    private Integer pZipNo;
    private String prmCnctnm;
    private Integer prmExtNo;
    private String prmSubsid;
    private String prmSubsnm;
    private Long prmTelNo;
    private String pvdTrnscd;
    private String pubTrnscd;
    private String streetNm;
    private String streetNo;
    private Integer zipNo;
    private String lstUpdId;
    private Timestamp lstUpdTs;
    private String addrDsc;
    private String spcharDsc;
    private String ctyprfDsc;
    private String edPvrDsc;
    private String envFctdsc;
    private String hazrdsDsc;
    private String lisPrfdsc;
    private String petsDsc;
    private String rlgActdsc;
    private Short pyZipSfx;
    private Short zipSfxNo;
    private Short apStatTp;
    private String certCmplt;
    private String laPCtynm;
    private String laPFstnm;
    private String laPLstnm;
    private String laPMidnm;
    private Short lpStateC;
    private String laPStnm;
    private String laPStno;
    private Integer laPZipno;
    private Short laPZpsfx;
    private String laPBsnss;
    private LocalDate apStatDt;
    private Long laPPhNo;
    private Integer laPPhEx;
    private String adhmonly;
    private Integer pyeExtNo;
    private Long pyeTelNo;
    private String arcassInd;
    private String comfacInd;
    private String trnhsgInd;
    private String trnhsgFac;
    private String newlicNo;
    private String newlicUpd;
    private String oldfacId;
    private String emCntB;
    private LocalDate endDt;
    private Short phEndc;
    private String endComdsc;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "PLC_FCLC", referencedColumnName = "SYS_ID")
    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "GVR_ENTC", referencedColumnName = "SYS_ID")
    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "F_STATE_C", referencedColumnName = "SYS_ID")
    public gov.ca.cwds.cals.persistence.model.cms.State getStateCode() {
        return stateCode;
    }

    public void setStateCode(gov.ca.cwds.cals.persistence.model.cms.State stateCode) {
        this.stateCode = stateCode;
    }

/*
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_STATE_C", referencedColumnName = "SYS_ID", nullable = false)
*/
    @Transient
    public gov.ca.cwds.cals.persistence.model.cms.State getPayeeStateCode() {
        return payeeStateCode;
    }

    public void setPayeeStateCode(gov.ca.cwds.cals.persistence.model.cms.State payeeStateCode) {
        this.payeeStateCode = payeeStateCode;
    }

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "LIC_STC", referencedColumnName = "SYS_ID", nullable = false)
    public gov.ca.cwds.cals.persistence.model.cms.LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(gov.ca.cwds.cals.persistence.model.cms.LicenseStatus licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    @Id
    @javax.persistence.Column(name = "IDENTIFIER", nullable = false, length = 10)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @javax.persistence.Column(name = "LICENSE_NO", nullable = true, length = 9)
    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    @Basic
    @javax.persistence.Column(name = "AGE_FRM_NO", nullable = false)
    public Short getAgeFrmNo() {
        return ageFrmNo;
    }

    public void setAgeFrmNo(Short ageFrmNo) {
        this.ageFrmNo = ageFrmNo;
    }

    @Basic
    @javax.persistence.Column(name = "AGE_TO_NO", nullable = false)
    public Short getAgeToNo() {
        return ageToNo;
    }

    public void setAgeToNo(Short ageToNo) {
        this.ageToNo = ageToNo;
    }

    @Basic
    @javax.persistence.Column(name = "AT_CAP_IND", nullable = false, length = 1)
    public String getAtCapInd() {
        return atCapInd;
    }

    public void setAtCapInd(String atCapInd) {
        this.atCapInd = atCapInd;
    }

    @Basic
    @javax.persistence.Column(name = "BCK_PERSNM", nullable = false, length = 35)
    public String getBckPersnm() {
        return bckPersnm;
    }

    public void setBckPersnm(String bckPersnm) {
        this.bckPersnm = bckPersnm;
    }

    @Basic
    @javax.persistence.Column(name = "BCK_EXT_NO", nullable = false)
    public Integer getBckExtNo() {
        return bckExtNo;
    }

    public void setBckExtNo(Integer bckExtNo) {
        this.bckExtNo = bckExtNo;
    }

    @Basic
    @javax.persistence.Column(name = "BCK_TEL_NO", nullable = false, precision = 0)
    public Long getBckTelNo() {
        return bckTelNo;
    }

    public void setBckTelNo(Long bckTelNo) {
        this.bckTelNo = bckTelNo;
    }

    @Basic
    @javax.persistence.Column(name = "CERTF_PNDT", nullable = true)
    public LocalDate getCertfPndt() {
        return certfPndt;
    }

    public void setCertfPndt(LocalDate certfPndt) {
        this.certfPndt = certfPndt;
    }

    @Basic
    @javax.persistence.Column(name = "CHLCR_PLCD", nullable = false, length = 1)
    public String getChlcrPlcd() {
        return chlcrPlcd;
    }

    public void setChlcrPlcd(String chlcrPlcd) {
        this.chlcrPlcd = chlcrPlcd;
    }

    @Basic
    @javax.persistence.Column(name = "CITY_NM", nullable = false, length = 20)
    public String getCityNm() {
        return cityNm;
    }

    public void setCityNm(String cityNm) {
        this.cityNm = cityNm;
    }

    @Basic
    @javax.persistence.Column(name = "CL_SRVDC", nullable = false)
    public Short getClSrvdc() {
        return clSrvdc;
    }

    public void setClSrvdc(Short clSrvdc) {
        this.clSrvdc = clSrvdc;
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
    @javax.persistence.Column(name = "CUR_OCP_NO", nullable = false)
    public Short getCurOcpNo() {
        return curOcpNo;
    }

    public void setCurOcpNo(Short curOcpNo) {
        this.curOcpNo = curOcpNo;
    }

    @Basic
    @javax.persistence.Column(name = "EMR_SHLTCD", nullable = false, length = 1)
    public String getEmrShltcd() {
        return emrShltcd;
    }

    public void setEmrShltcd(String emrShltcd) {
        this.emrShltcd = emrShltcd;
    }

    @Basic
    @javax.persistence.Column(name = "FAX_NO", nullable = false, precision = 0)
    public Long getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(Long faxNo) {
        this.faxNo = faxNo;
    }

    @Basic
    @javax.persistence.Column(name = "FRG_ADRT_B", nullable = false, length = 1)
    public String getFrgAdrtB() {
        return frgAdrtB;
    }

    public void setFrgAdrtB(String frgAdrtB) {
        this.frgAdrtB = frgAdrtB;
    }

    @Basic
    @javax.persistence.Column(name = "GNDR_ACPCD", nullable = false, length = 1)
    public String getGndrAcpcd() {
        return gndrAcpcd;
    }

    public void setGndrAcpcd(String gndrAcpcd) {
        this.gndrAcpcd = gndrAcpcd;
    }

    @Basic
    @javax.persistence.Column(name = "GEO_RGNTCD", nullable = false, length = 2)
    public String getGeoRgntcd() {
        return geoRgntcd;
    }

    public void setGeoRgntcd(String geoRgntcd) {
        this.geoRgntcd = geoRgntcd;
    }

    @Basic
    @javax.persistence.Column(name = "INHM_VSTCD", nullable = false, length = 1)
    public String getInhmVstcd() {
        return inhmVstcd;
    }

    public void setInhmVstcd(String inhmVstcd) {
        this.inhmVstcd = inhmVstcd;
    }

    @Basic
    @javax.persistence.Column(name = "MAX_CAP_NO", nullable = false)
    public Short getMaxCapNo() {
        return maxCapNo;
    }

    public void setMaxCapNo(Short maxCapNo) {
        this.maxCapNo = maxCapNo;
    }

    @Basic
    @javax.persistence.Column(name = "LA_VNDR_ID", nullable = false, length = 6)
    public String getLaVndrId() {
        return laVndrId;
    }

    public void setLaVndrId(String laVndrId) {
        this.laVndrId = laVndrId;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_APL_DT", nullable = true)
    public LocalDate getLicAplDt() {
        return licAplDt;
    }

    public void setLicAplDt(LocalDate licAplDt) {
        this.licAplDt = licAplDt;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_CAP_NO", nullable = false)
    public Short getLicCapNo() {
        return licCapNo;
    }

    public void setLicCapNo(Short licCapNo) {
        this.licCapNo = licCapNo;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_EFCTDT", nullable = true)
    public LocalDate getLicEfctdt() {
        return licEfctdt;
    }

    public void setLicEfctdt(LocalDate licEfctdt) {
        this.licEfctdt = licEfctdt;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_EXP_DT", nullable = true)
    public LocalDate getLicExpDt() {
        return licExpDt;
    }

    public void setLicExpDt(LocalDate licExpDt) {
        this.licExpDt = licExpDt;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_STATDT", nullable = true)
    public LocalDate getLicStatdt() {
        return licStatdt;
    }

    public void setLicStatdt(LocalDate licStatdt) {
        this.licStatdt = licStatdt;
    }

    @Basic
    @javax.persistence.Column(name = "LIC_BSNC", nullable = false)
    public Short getLicBsnc() {
        return licBsnc;
    }

    public void setLicBsnc(Short licBsnc) {
        this.licBsnc = licBsnc;
    }

    @Basic
    @javax.persistence.Column(name = "LICNSEE_NM", nullable = false, length = 50)
    public String getLicnseeNm() {
        return licnseeNm;
    }

    public void setLicnseeNm(String licnseeNm) {
        this.licnseeNm = licnseeNm;
    }

    @Basic
    @javax.persistence.Column(name = "LICENSR_CD", nullable = false, length = 2)
    public String getLicensrCd() {
        return licensrCd;
    }

    public void setLicensrCd(String licensrCd) {
        this.licensrCd = licensrCd;
    }

    @Basic
    @javax.persistence.Column(name = "FACLTY_NM", nullable = false, length = 50)
    public String getFacltyNm() {
        return facltyNm;
    }

    public void setFacltyNm(String facltyNm) {
        this.facltyNm = facltyNm;
    }

    @Basic
    @javax.persistence.Column(name = "OPRTD_BYID", nullable = true, length = 10)
    public String getOprtdByid() {
        return oprtdByid;
    }

    public void setOprtdByid(String oprtdByid) {
        this.oprtdByid = oprtdByid;
    }

    @Basic
    @javax.persistence.Column(name = "OPRTD_BYCD", nullable = true, length = 1)
    public String getOprtdBycd() {
        return oprtdBycd;
    }

    public void setOprtdBycd(String oprtdBycd) {
        this.oprtdBycd = oprtdBycd;
    }

    @Basic
    @javax.persistence.Column(name = "P_CITY_NM", nullable = false, length = 20)
    public String getpCityNm() {
        return pCityNm;
    }

    public void setpCityNm(String pCityNm) {
        this.pCityNm = pCityNm;
    }

    @Basic
    @javax.persistence.Column(name = "PYE_FSTNM", nullable = false, length = 20)
    public String getPyeFstnm() {
        return pyeFstnm;
    }

    public void setPyeFstnm(String pyeFstnm) {
        this.pyeFstnm = pyeFstnm;
    }

    @Basic
    @javax.persistence.Column(name = "PYE_LSTNM", nullable = false, length = 25)
    public String getPyeLstnm() {
        return pyeLstnm;
    }

    public void setPyeLstnm(String pyeLstnm) {
        this.pyeLstnm = pyeLstnm;
    }

    @Basic
    @javax.persistence.Column(name = "PYE_MIDNM", nullable = false, length = 1)
    public String getPyeMidnm() {
        return pyeMidnm;
    }

    public void setPyeMidnm(String pyeMidnm) {
        this.pyeMidnm = pyeMidnm;
    }

    @Basic
    @javax.persistence.Column(name = "PSTREET_NM", nullable = false, length = 40)
    public String getPstreetNm() {
        return pstreetNm;
    }

    public void setPstreetNm(String pstreetNm) {
        this.pstreetNm = pstreetNm;
    }

    @Basic
    @javax.persistence.Column(name = "PSTREET_NO", nullable = false, length = 10)
    public String getPstreetNo() {
        return pstreetNo;
    }

    public void setPstreetNo(String pstreetNo) {
        this.pstreetNo = pstreetNo;
    }

    @Basic
    @javax.persistence.Column(name = "P_ZIP_NO", nullable = false)
    public Integer getpZipNo() {
        return pZipNo;
    }

    public void setpZipNo(Integer pZipNo) {
        this.pZipNo = pZipNo;
    }

    @Basic
    @javax.persistence.Column(name = "PRM_CNCTNM", nullable = false, length = 35)
    public String getPrmCnctnm() {
        return prmCnctnm;
    }

    public void setPrmCnctnm(String prmCnctnm) {
        this.prmCnctnm = prmCnctnm;
    }

    @Basic
    @javax.persistence.Column(name = "PRM_EXT_NO", nullable = false)
    public Integer getPrmExtNo() {
        return prmExtNo;
    }

    public void setPrmExtNo(Integer prmExtNo) {
        this.prmExtNo = prmExtNo;
    }

    @Basic
    @javax.persistence.Column(name = "PRM_SUBSID", nullable = true, length = 10)
    public String getPrmSubsid() {
        return prmSubsid;
    }

    public void setPrmSubsid(String prmSubsid) {
        this.prmSubsid = prmSubsid;
    }

    @Basic
    @javax.persistence.Column(name = "PRM_SUBSNM", nullable = false, length = 54)
    public String getPrmSubsnm() {
        return prmSubsnm;
    }

    public void setPrmSubsnm(String prmSubsnm) {
        this.prmSubsnm = prmSubsnm;
    }

    @Basic
    @javax.persistence.Column(name = "PRM_TEL_NO", nullable = false, precision = 0)
    public Long getPrmTelNo() {
        return prmTelNo;
    }

    public void setPrmTelNo(Long prmTelNo) {
        this.prmTelNo = prmTelNo;
    }

    @Basic
    @javax.persistence.Column(name = "PVD_TRNSCD", nullable = false, length = 1)
    public String getPvdTrnscd() {
        return pvdTrnscd;
    }

    public void setPvdTrnscd(String pvdTrnscd) {
        this.pvdTrnscd = pvdTrnscd;
    }

    @Basic
    @javax.persistence.Column(name = "PUB_TRNSCD", nullable = false, length = 1)
    public String getPubTrnscd() {
        return pubTrnscd;
    }

    public void setPubTrnscd(String pubTrnscd) {
        this.pubTrnscd = pubTrnscd;
    }

    @Basic
    @javax.persistence.Column(name = "STREET_NM", nullable = false, length = 40)
    public String getStreetNm() {
        return streetNm;
    }

    public void setStreetNm(String streetNm) {
        this.streetNm = streetNm;
    }

    @Basic
    @javax.persistence.Column(name = "STREET_NO", nullable = false, length = 10)
    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    @Basic
    @javax.persistence.Column(name = "ZIP_NO", nullable = false)
    public Integer getZipNo() {
        return zipNo;
    }

    public void setZipNo(Integer zipNo) {
        this.zipNo = zipNo;
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
    @javax.persistence.Column(name = "ADDR_DSC", nullable = false, length = 120)
    public String getAddrDsc() {
        return addrDsc;
    }

    public void setAddrDsc(String addrDsc) {
        this.addrDsc = addrDsc;
    }

    @Basic
    @javax.persistence.Column(name = "SPCHAR_DSC", nullable = false, length = 120)
    public String getSpcharDsc() {
        return spcharDsc;
    }

    public void setSpcharDsc(String spcharDsc) {
        this.spcharDsc = spcharDsc;
    }

    @Basic
    @javax.persistence.Column(name = "CTYPRF_DSC", nullable = false, length = 240)
    public String getCtyprfDsc() {
        return ctyprfDsc;
    }

    public void setCtyprfDsc(String ctyprfDsc) {
        this.ctyprfDsc = ctyprfDsc;
    }

    @Basic
    @javax.persistence.Column(name = "ED_PVR_DSC", nullable = false, length = 120)
    public String getEdPvrDsc() {
        return edPvrDsc;
    }

    public void setEdPvrDsc(String edPvrDsc) {
        this.edPvrDsc = edPvrDsc;
    }

    @Basic
    @javax.persistence.Column(name = "ENV_FCTDSC", nullable = false, length = 60)
    public String getEnvFctdsc() {
        return envFctdsc;
    }

    public void setEnvFctdsc(String envFctdsc) {
        this.envFctdsc = envFctdsc;
    }

    @Basic
    @javax.persistence.Column(name = "HAZRDS_DSC", nullable = false, length = 120)
    public String getHazrdsDsc() {
        return hazrdsDsc;
    }

    public void setHazrdsDsc(String hazrdsDsc) {
        this.hazrdsDsc = hazrdsDsc;
    }

    @Basic
    @javax.persistence.Column(name = "LIS_PRFDSC", nullable = false, length = 210)
    public String getLisPrfdsc() {
        return lisPrfdsc;
    }

    public void setLisPrfdsc(String lisPrfdsc) {
        this.lisPrfdsc = lisPrfdsc;
    }

    @Basic
    @javax.persistence.Column(name = "PETS_DSC", nullable = false, length = 60)
    public String getPetsDsc() {
        return petsDsc;
    }

    public void setPetsDsc(String petsDsc) {
        this.petsDsc = petsDsc;
    }

    @Basic
    @javax.persistence.Column(name = "RLG_ACTDSC", nullable = false, length = 60)
    public String getRlgActdsc() {
        return rlgActdsc;
    }

    public void setRlgActdsc(String rlgActdsc) {
        this.rlgActdsc = rlgActdsc;
    }

    @Basic
    @javax.persistence.Column(name = "PY_ZIP_SFX", nullable = false)
    public Short getPyZipSfx() {
        return pyZipSfx;
    }

    public void setPyZipSfx(Short pyZipSfx) {
        this.pyZipSfx = pyZipSfx;
    }

    @Basic
    @javax.persistence.Column(name = "ZIP_SFX_NO", nullable = false)
    public Short getZipSfxNo() {
        return zipSfxNo;
    }

    public void setZipSfxNo(Short zipSfxNo) {
        this.zipSfxNo = zipSfxNo;
    }

    @Basic
    @javax.persistence.Column(name = "AP_STAT_TP", nullable = false)
    public Short getApStatTp() {
        return apStatTp;
    }

    public void setApStatTp(Short apStatTp) {
        this.apStatTp = apStatTp;
    }

    @Basic
    @javax.persistence.Column(name = "CERT_CMPLT", nullable = false, length = 1)
    public String getCertCmplt() {
        return certCmplt;
    }

    public void setCertCmplt(String certCmplt) {
        this.certCmplt = certCmplt;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_CTYNM", nullable = false, length = 20)
    public String getLaPCtynm() {
        return laPCtynm;
    }

    public void setLaPCtynm(String laPCtynm) {
        this.laPCtynm = laPCtynm;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_FSTNM", nullable = false, length = 20)
    public String getLaPFstnm() {
        return laPFstnm;
    }

    public void setLaPFstnm(String laPFstnm) {
        this.laPFstnm = laPFstnm;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_LSTNM", nullable = false, length = 25)
    public String getLaPLstnm() {
        return laPLstnm;
    }

    public void setLaPLstnm(String laPLstnm) {
        this.laPLstnm = laPLstnm;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_MIDNM", nullable = false, length = 1)
    public String getLaPMidnm() {
        return laPMidnm;
    }

    public void setLaPMidnm(String laPMidnm) {
        this.laPMidnm = laPMidnm;
    }

    @Basic
    @javax.persistence.Column(name = "LP_STATE_C", nullable = false)
    public Short getLpStateC() {
        return lpStateC;
    }

    public void setLpStateC(Short lpStateC) {
        this.lpStateC = lpStateC;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_STNM", nullable = false, length = 40)
    public String getLaPStnm() {
        return laPStnm;
    }

    public void setLaPStnm(String laPStnm) {
        this.laPStnm = laPStnm;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_STNO", nullable = false, length = 10)
    public String getLaPStno() {
        return laPStno;
    }

    public void setLaPStno(String laPStno) {
        this.laPStno = laPStno;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_ZIPNO", nullable = false)
    public Integer getLaPZipno() {
        return laPZipno;
    }

    public void setLaPZipno(Integer laPZipno) {
        this.laPZipno = laPZipno;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_ZPSFX", nullable = false)
    public Short getLaPZpsfx() {
        return laPZpsfx;
    }

    public void setLaPZpsfx(Short laPZpsfx) {
        this.laPZpsfx = laPZpsfx;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_BSNSS", nullable = false, length = 30)
    public String getLaPBsnss() {
        return laPBsnss;
    }

    public void setLaPBsnss(String laPBsnss) {
        this.laPBsnss = laPBsnss;
    }

    @Basic
    @javax.persistence.Column(name = "AP_STAT_DT", nullable = true)
    public LocalDate getApStatDt() {
        return apStatDt;
    }

    public void setApStatDt(LocalDate apStatDt) {
        this.apStatDt = apStatDt;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_PH_NO", nullable = false, precision = 0)
    public Long getLaPPhNo() {
        return laPPhNo;
    }

    public void setLaPPhNo(Long laPPhNo) {
        this.laPPhNo = laPPhNo;
    }

    @Basic
    @javax.persistence.Column(name = "LA_P_PH_EX", nullable = false)
    public Integer getLaPPhEx() {
        return laPPhEx;
    }

    public void setLaPPhEx(Integer laPPhEx) {
        this.laPPhEx = laPPhEx;
    }

    @Basic
    @javax.persistence.Column(name = "ADHMONLY", nullable = false, length = 1)
    public String getAdhmonly() {
        return adhmonly;
    }

    public void setAdhmonly(String adhmonly) {
        this.adhmonly = adhmonly;
    }

    @Basic
    @javax.persistence.Column(name = "PYE_EXT_NO", nullable = false)
    public Integer getPyeExtNo() {
        return pyeExtNo;
    }

    public void setPyeExtNo(Integer pyeExtNo) {
        this.pyeExtNo = pyeExtNo;
    }

    @Basic
    @javax.persistence.Column(name = "PYE_TEL_NO", nullable = false, precision = 0)
    public Long getPyeTelNo() {
        return pyeTelNo;
    }

    public void setPyeTelNo(Long pyeTelNo) {
        this.pyeTelNo = pyeTelNo;
    }

    @Basic
    @javax.persistence.Column(name = "ARCASS_IND", nullable = false, length = 1)
    public String getArcassInd() {
        return arcassInd;
    }

    public void setArcassInd(String arcassInd) {
        this.arcassInd = arcassInd;
    }

    @Basic
    @javax.persistence.Column(name = "COMFAC_IND", nullable = false, length = 1)
    public String getComfacInd() {
        return comfacInd;
    }

    public void setComfacInd(String comfacInd) {
        this.comfacInd = comfacInd;
    }

    @Basic
    @javax.persistence.Column(name = "TRNHSG_IND", nullable = false, length = 1)
    public String getTrnhsgInd() {
        return trnhsgInd;
    }

    public void setTrnhsgInd(String trnhsgInd) {
        this.trnhsgInd = trnhsgInd;
    }

    @Basic
    @javax.persistence.Column(name = "TRNHSG_FAC", nullable = false, length = 1)
    public String getTrnhsgFac() {
        return trnhsgFac;
    }

    public void setTrnhsgFac(String trnhsgFac) {
        this.trnhsgFac = trnhsgFac;
    }

    @Basic
    @javax.persistence.Column(name = "NEWLIC_NO", nullable = true, length = 9)
    public String getNewlicNo() {
        return newlicNo;
    }

    public void setNewlicNo(String newlicNo) {
        this.newlicNo = newlicNo;
    }

    @Basic
    @javax.persistence.Column(name = "NEWLIC_UPD", nullable = false, length = 1)
    public String getNewlicUpd() {
        return newlicUpd;
    }

    public void setNewlicUpd(String newlicUpd) {
        this.newlicUpd = newlicUpd;
    }

    @Basic
    @javax.persistence.Column(name = "OLDFAC_ID", nullable = true, length = 10)
    public String getOldfacId() {
        return oldfacId;
    }

    public void setOldfacId(String oldfacId) {
        this.oldfacId = oldfacId;
    }

    @Basic
    @javax.persistence.Column(name = "EM_CNT_B", nullable = false, length = 1)
    public String getEmCntB() {
        return emCntB;
    }

    public void setEmCntB(String emCntB) {
        this.emCntB = emCntB;
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
    @javax.persistence.Column(name = "PH_ENDC", nullable = true)
    public Short getPhEndc() {
        return phEndc;
    }

    public void setPhEndc(Short phEndc) {
        this.phEndc = phEndc;
    }

    @Basic
    @javax.persistence.Column(name = "END_COMDSC", nullable = true, length = 254)
    public String getEndComdsc() {
        return endComdsc;
    }

    public void setEndComdsc(String endComdsc) {
        this.endComdsc = endComdsc;
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
