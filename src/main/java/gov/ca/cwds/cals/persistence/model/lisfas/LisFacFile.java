package gov.ca.cwds.cals.persistence.model.lisfas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "lis_fac_file")
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class LisFacFile implements PersistentObject {

    private static final long serialVersionUID = 863872921154264534L;

    private Integer facNbr;
    private Integer isnLisFacFile;
    private String facName;
    private String facDoEvalCode;
    private LisDoFile facDoNbr;
    private County facCoNbr;
    private Integer facFmRegionNbr;
    private Integer facCfirsIdNbr;
    private String facStreetSearch;
    private FacilityType facType;
    private FacilityStatusType facStatus;
    private VisitReasonType facLastVisitReason;
    private String facResStreetAddr;
    private String facResCity;
    private String facResState;
    private String facResZipCode;
    private String facMailStreetAddr;
    private String facMailCity;
    private String facMailState;
    private String facMailZipCode;
    private String facLicenseeName;
    private String facLicenseeType;
    private String facLicComments;
    private LocalDate facLicEffDate;
    private LocalDate facLicExpirDate;
    private LocalDate facLicFirstDate;
    private LocalDate facLicLastChangeDate;
    private String facLicMailStreetAddr;
    private String facLicMailCity;
    private String facLicMailState;
    private String facLicMailZipCode;
    private String facAdmin;
    private Integer facCapacity;
    private Integer facClientServed;
    private LocalDate facClosedDate;
    private LocalDate facOrigApplRecDate;
    private String facPhoneNbr;
    private LocalDate facAnnual10MoDeferDate;
    private LocalDate facAnnual22MoDeferDate;
    private String facAnnual10MoVisitAppr;
    private String facAnnual22MoVisitAppr;
    private LocalDate facAnnual10MoVisitDate;
    private LocalDate facAnnual22MoVisitDate;
    private LocalDate facLastVisitDate;
    private LocalDate facMidYrDeferDate;
    private String facMidYrVisitAppr;
    private LocalDate facMidYrVisitDate;
    private LocalDate facPostLicDeferDate;
    private String facPostLicVisitAppr;
    private LocalDate facPostLicVisitDate;
    private LocalDate facRenewalDeferDate;
    private String facRenewalVisitAppr;
    private LocalDate facRenewalVisitDate;
    private LocalDate facLastFireClearDate;
    private String facSfmIdNbr;
    private Integer facAmb117Nbr;
    private Integer facAmb1864Nbr;
    private Integer facAmb65PlusNbr;
    private Integer facNonamb117Nbr;
    private Integer facNonamb1864Nbr;
    private Integer facNonamb65PlusNbr;
    private LocalDate facUnlicOrigInputDate;
    private LocalDate facClosedProcessDate;
    private LocalDate facCapIncRecDate;
    private Integer facRegionNbr;
    private LocalDate facLastDeferVisitDate;
    private VisitReasonType facLastDeferVisitReason;
    private Integer facAnnualVisitYear;
    private LocalDate facLastUpdDate;
    private LocalDate facCapIncClosedDate;
    private String facActionCode;
    private LocalDate facIncCapEffDate;
    private String facLicComments2;
    private LocalDate facClientServedApprDate;
    private String facLegalActionIndicator;
    private String facAggStatus;
    private Integer facPrimaryNbr;
    private LocalDate facBillingDate;
    private String facDualId;
    private String facDualNbr;
    private String facFcrbPrgmNbr;
    private String facGhIndicator;
    private String facComplaint;
    private String facDeficiency;
    private Integer facNbrNew;
    private String facEmailAddress;
    private LocalDate facPreLicVisitDate;
    private String facPlacementReady;
    private LocalDate facPlacementDate;
    private String facRequiredVisit;
    private Integer facPin;
    private Integer facOldFfaNbr;
    private LocalDate facInactiveNoticeDate;
    private LocalDate facInactiveStartDate;
    private LocalDate facSodMatchDate;
    private String facAddrKey;
    private String facLocIndicator;
    private String facType999CaciIndicator;
    private Integer facBilingual;
    private Integer facRegionDo;
    private Integer facRegionCo;

    @Id
    @Column(name = "fac_nbr", nullable = false)
    public Integer getFacNbr() {
        return facNbr;
    }

    public void setFacNbr(Integer facNbr) {
        this.facNbr = facNbr;
    }

    @Basic
    @Column(name = "isn_lis_fac_file", nullable = false)
    public Integer getIsnLisFacFile() {
        return isnLisFacFile;
    }

    public void setIsnLisFacFile(Integer isnLisFacFile) {
        this.isnLisFacFile = isnLisFacFile;
    }

    @Basic
    @Column(name = "fac_name", nullable = true, length = 50)
    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    @Basic
    @Column(name = "fac_do_eval_code", nullable = true, length = 4)
    public String getFacDoEvalCode() {
        return facDoEvalCode;
    }

    public void setFacDoEvalCode(String facDoEvalCode) {
        this.facDoEvalCode = facDoEvalCode;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_do_nbr", referencedColumnName = "do_nbr")
    public LisDoFile getFacDoNbr() {
        return facDoNbr;
    }

    public void setFacDoNbr(LisDoFile facDoNbr) {
        this.facDoNbr = facDoNbr;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_co_nbr", referencedColumnName = "tbl_co_nbr")
    public County getFacCoNbr() {
        return facCoNbr;
    }

    public void setFacCoNbr(County facCoNbr) {
        this.facCoNbr = facCoNbr;
    }

    @Basic
    @Column(name = "fac_fm_region_nbr", nullable = true)
    public Integer getFacFmRegionNbr() {
        return facFmRegionNbr;
    }

    public void setFacFmRegionNbr(Integer facFmRegionNbr) {
        this.facFmRegionNbr = facFmRegionNbr;
    }

    @Basic
    @Column(name = "fac_cfirs_id_nbr", nullable = true)
    public Integer getFacCfirsIdNbr() {
        return facCfirsIdNbr;
    }

    public void setFacCfirsIdNbr(Integer facCfirsIdNbr) {
        this.facCfirsIdNbr = facCfirsIdNbr;
    }

    @Basic
    @Column(name = "fac_street_search", nullable = true, length = 20)
    public String getFacStreetSearch() {
        return facStreetSearch;
    }

    public void setFacStreetSearch(String facStreetSearch) {
        this.facStreetSearch = facStreetSearch;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_type", referencedColumnName = "tbl_fac_type_code")
    public FacilityType getFacType() {
        return facType;
    }

    public void setFacType(FacilityType facType) {
        this.facType = facType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_status", referencedColumnName = "tbl_fac_status_code")
    public FacilityStatusType getFacStatus() {
        return facStatus;
    }

    public void setFacStatus(FacilityStatusType facStatus) {
        this.facStatus = facStatus;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_last_visit_reason", referencedColumnName = "tbl_visit_reason_code")
    public VisitReasonType getFacLastVisitReason() {
        return facLastVisitReason;
    }

    public void setFacLastVisitReason(VisitReasonType facLastVisitReason) {
        this.facLastVisitReason = facLastVisitReason;
    }

    @Basic
    @Column(name = "fac_res_street_addr", nullable = true, length = 30)
    public String getFacResStreetAddr() {
        return facResStreetAddr;
    }

    public void setFacResStreetAddr(String facResStreetAddr) {
        this.facResStreetAddr = facResStreetAddr;
    }

    @Basic
    @Column(name = "fac_res_city", nullable = true, length = 20)
    public String getFacResCity() {
        return facResCity;
    }

    public void setFacResCity(String facResCity) {
        this.facResCity = facResCity;
    }

    @Basic
    @Column(name = "fac_res_state", nullable = true, length = 2)
    public String getFacResState() {
        return facResState;
    }

    public void setFacResState(String facResState) {
        this.facResState = facResState;
    }

    @Basic
    @Column(name = "fac_res_zip_code", nullable = true, length = 9)
    public String getFacResZipCode() {
        return facResZipCode;
    }

    public void setFacResZipCode(String facResZipCode) {
        this.facResZipCode = facResZipCode;
    }

    @Basic
    @Column(name = "fac_mail_street_addr", nullable = true, length = 30)
    public String getFacMailStreetAddr() {
        return facMailStreetAddr;
    }

    public void setFacMailStreetAddr(String facMailStreetAddr) {
        this.facMailStreetAddr = facMailStreetAddr;
    }

    @Basic
    @Column(name = "fac_mail_city", nullable = true, length = 20)
    public String getFacMailCity() {
        return facMailCity;
    }

    public void setFacMailCity(String facMailCity) {
        this.facMailCity = facMailCity;
    }

    @Basic
    @Column(name = "fac_mail_state", nullable = true, length = 2)
    public String getFacMailState() {
        return facMailState;
    }

    public void setFacMailState(String facMailState) {
        this.facMailState = facMailState;
    }

    @Basic
    @Column(name = "fac_mail_zip_code", nullable = true, length = 9)
    public String getFacMailZipCode() {
        return facMailZipCode;
    }

    public void setFacMailZipCode(String facMailZipCode) {
        this.facMailZipCode = facMailZipCode;
    }

    @Basic
    @Column(name = "fac_licensee_name", nullable = true, length = 50)
    public String getFacLicenseeName() {
        return facLicenseeName;
    }

    public void setFacLicenseeName(String facLicenseeName) {
        this.facLicenseeName = facLicenseeName;
    }

    @Basic
    @Column(name = "fac_licensee_type", nullable = true, length = -1)
    public String getFacLicenseeType() {
        return facLicenseeType;
    }

    public void setFacLicenseeType(String facLicenseeType) {
        this.facLicenseeType = facLicenseeType;
    }

    @Basic
    @Column(name = "fac_lic_comments", nullable = true, length = 210)
    public String getFacLicComments() {
        return facLicComments;
    }

    public void setFacLicComments(String facLicComments) {
        this.facLicComments = facLicComments;
    }

    @Basic
    @Column(name = "fac_lic_eff_date", nullable = true)
    public LocalDate getFacLicEffDate() {
        return facLicEffDate;
    }

    public void setFacLicEffDate(LocalDate facLicEffDate) {
        this.facLicEffDate = facLicEffDate;
    }

    @Basic
    @Column(name = "fac_lic_expir_date", nullable = true)
    public LocalDate getFacLicExpirDate() {
        return facLicExpirDate;
    }

    public void setFacLicExpirDate(LocalDate facLicExpirDate) {
        this.facLicExpirDate = facLicExpirDate;
    }

    @Basic
    @Column(name = "fac_lic_first_date", nullable = true)
    public LocalDate getFacLicFirstDate() {
        return facLicFirstDate;
    }

    public void setFacLicFirstDate(LocalDate facLicFirstDate) {
        this.facLicFirstDate = facLicFirstDate;
    }

    @Basic
    @Column(name = "fac_lic_last_change_date", nullable = true)
    public LocalDate getFacLicLastChangeDate() {
        return facLicLastChangeDate;
    }

    public void setFacLicLastChangeDate(LocalDate facLicLastChangeDate) {
        this.facLicLastChangeDate = facLicLastChangeDate;
    }

    @Basic
    @Column(name = "fac_lic_mail_street_addr", nullable = true, length = 30)
    public String getFacLicMailStreetAddr() {
        return facLicMailStreetAddr;
    }

    public void setFacLicMailStreetAddr(String facLicMailStreetAddr) {
        this.facLicMailStreetAddr = facLicMailStreetAddr;
    }

    @Basic
    @Column(name = "fac_lic_mail_city", nullable = true, length = 20)
    public String getFacLicMailCity() {
        return facLicMailCity;
    }

    public void setFacLicMailCity(String facLicMailCity) {
        this.facLicMailCity = facLicMailCity;
    }

    @Basic
    @Column(name = "fac_lic_mail_state", nullable = true, length = 2)
    public String getFacLicMailState() {
        return facLicMailState;
    }

    public void setFacLicMailState(String facLicMailState) {
        this.facLicMailState = facLicMailState;
    }

    @Basic
    @Column(name = "fac_lic_mail_zip_code", nullable = true, length = 9)
    public String getFacLicMailZipCode() {
        return facLicMailZipCode;
    }

    public void setFacLicMailZipCode(String facLicMailZipCode) {
        this.facLicMailZipCode = facLicMailZipCode;
    }

    @Basic
    @Column(name = "fac_admin", nullable = true, length = 26)
    public String getFacAdmin() {
        return facAdmin;
    }

    public void setFacAdmin(String facAdmin) {
        this.facAdmin = facAdmin;
    }

    @Basic
    @Column(name = "fac_capacity", nullable = true)
    public Integer getFacCapacity() {
        return facCapacity;
    }

    public void setFacCapacity(Integer facCapacity) {
        this.facCapacity = facCapacity;
    }

    @Basic
    @Column(name = "fac_client_served", nullable = true)
    public Integer getFacClientServed() {
        return facClientServed;
    }

    public void setFacClientServed(Integer facClientServed) {
        this.facClientServed = facClientServed;
    }

    @Basic
    @Column(name = "fac_closed_date", nullable = true)
    public LocalDate getFacClosedDate() {
        return facClosedDate;
    }

    public void setFacClosedDate(LocalDate facClosedDate) {
        this.facClosedDate = facClosedDate;
    }

    @Basic
    @Column(name = "fac_orig_appl_rec_date", nullable = true)
    public LocalDate getFacOrigApplRecDate() {
        return facOrigApplRecDate;
    }

    public void setFacOrigApplRecDate(LocalDate facOrigApplRecDate) {
        this.facOrigApplRecDate = facOrigApplRecDate;
    }

    @Basic
    @Column(name = "fac_phone_nbr", nullable = true, length = 10)
    public String getFacPhoneNbr() {
        return facPhoneNbr;
    }

    public void setFacPhoneNbr(String facPhoneNbr) {
        this.facPhoneNbr = facPhoneNbr;
    }

    @Basic
    @Column(name = "fac_annual_10_mo_defer_date", nullable = true)
    public LocalDate getFacAnnual10MoDeferDate() {
        return facAnnual10MoDeferDate;
    }

    public void setFacAnnual10MoDeferDate(LocalDate facAnnual10MoDeferDate) {
        this.facAnnual10MoDeferDate = facAnnual10MoDeferDate;
    }

    @Basic
    @Column(name = "fac_annual_22_mo_defer_date", nullable = true)
    public LocalDate getFacAnnual22MoDeferDate() {
        return facAnnual22MoDeferDate;
    }

    public void setFacAnnual22MoDeferDate(LocalDate facAnnual22MoDeferDate) {
        this.facAnnual22MoDeferDate = facAnnual22MoDeferDate;
    }

    @Basic
    @Column(name = "fac_annual_10_mo_visit_appr", nullable = true, length = 3)
    public String getFacAnnual10MoVisitAppr() {
        return facAnnual10MoVisitAppr;
    }

    public void setFacAnnual10MoVisitAppr(String facAnnual10MoVisitAppr) {
        this.facAnnual10MoVisitAppr = facAnnual10MoVisitAppr;
    }

    @Basic
    @Column(name = "fac_annual_22_mo_visit_appr", nullable = true, length = 3)
    public String getFacAnnual22MoVisitAppr() {
        return facAnnual22MoVisitAppr;
    }

    public void setFacAnnual22MoVisitAppr(String facAnnual22MoVisitAppr) {
        this.facAnnual22MoVisitAppr = facAnnual22MoVisitAppr;
    }

    @Basic
    @Column(name = "fac_annual_10_mo_visit_date", nullable = true)
    public LocalDate getFacAnnual10MoVisitDate() {
        return facAnnual10MoVisitDate;
    }

    public void setFacAnnual10MoVisitDate(LocalDate facAnnual10MoVisitDate) {
        this.facAnnual10MoVisitDate = facAnnual10MoVisitDate;
    }

    @Basic
    @Column(name = "fac_annual_22_mo_visit_date", nullable = true)
    public LocalDate getFacAnnual22MoVisitDate() {
        return facAnnual22MoVisitDate;
    }

    public void setFacAnnual22MoVisitDate(LocalDate facAnnual22MoVisitDate) {
        this.facAnnual22MoVisitDate = facAnnual22MoVisitDate;
    }

    @Basic
    @Column(name = "fac_last_visit_date", nullable = true)
    public LocalDate getFacLastVisitDate() {
        return facLastVisitDate;
    }

    public void setFacLastVisitDate(LocalDate facLastVisitDate) {
        this.facLastVisitDate = facLastVisitDate;
    }

    @Basic
    @Column(name = "fac_mid_yr_defer_date", nullable = true)
    public LocalDate getFacMidYrDeferDate() {
        return facMidYrDeferDate;
    }

    public void setFacMidYrDeferDate(LocalDate facMidYrDeferDate) {
        this.facMidYrDeferDate = facMidYrDeferDate;
    }

    @Basic
    @Column(name = "fac_mid_yr_visit_appr", nullable = true, length = 3)
    public String getFacMidYrVisitAppr() {
        return facMidYrVisitAppr;
    }

    public void setFacMidYrVisitAppr(String facMidYrVisitAppr) {
        this.facMidYrVisitAppr = facMidYrVisitAppr;
    }

    @Basic
    @Column(name = "fac_mid_yr_visit_date", nullable = true)
    public LocalDate getFacMidYrVisitDate() {
        return facMidYrVisitDate;
    }

    public void setFacMidYrVisitDate(LocalDate facMidYrVisitDate) {
        this.facMidYrVisitDate = facMidYrVisitDate;
    }

    @Basic
    @Column(name = "fac_post_lic_defer_date", nullable = true)
    public LocalDate getFacPostLicDeferDate() {
        return facPostLicDeferDate;
    }

    public void setFacPostLicDeferDate(LocalDate facPostLicDeferDate) {
        this.facPostLicDeferDate = facPostLicDeferDate;
    }

    @Basic
    @Column(name = "fac_post_lic_visit_appr", nullable = true, length = 3)
    public String getFacPostLicVisitAppr() {
        return facPostLicVisitAppr;
    }

    public void setFacPostLicVisitAppr(String facPostLicVisitAppr) {
        this.facPostLicVisitAppr = facPostLicVisitAppr;
    }

    @Basic
    @Column(name = "fac_post_lic_visit_date", nullable = true)
    public LocalDate getFacPostLicVisitDate() {
        return facPostLicVisitDate;
    }

    public void setFacPostLicVisitDate(LocalDate facPostLicVisitDate) {
        this.facPostLicVisitDate = facPostLicVisitDate;
    }

    @Basic
    @Column(name = "fac_renewal_defer_date", nullable = true)
    public LocalDate getFacRenewalDeferDate() {
        return facRenewalDeferDate;
    }

    public void setFacRenewalDeferDate(LocalDate facRenewalDeferDate) {
        this.facRenewalDeferDate = facRenewalDeferDate;
    }

    @Basic
    @Column(name = "fac_renewal_visit_appr", nullable = true, length = 3)
    public String getFacRenewalVisitAppr() {
        return facRenewalVisitAppr;
    }

    public void setFacRenewalVisitAppr(String facRenewalVisitAppr) {
        this.facRenewalVisitAppr = facRenewalVisitAppr;
    }

    @Basic
    @Column(name = "fac_renewal_visit_date", nullable = true)
    public LocalDate getFacRenewalVisitDate() {
        return facRenewalVisitDate;
    }

    public void setFacRenewalVisitDate(LocalDate facRenewalVisitDate) {
        this.facRenewalVisitDate = facRenewalVisitDate;
    }

    @Basic
    @Column(name = "fac_last_fire_clear_date", nullable = true)
    public LocalDate getFacLastFireClearDate() {
        return facLastFireClearDate;
    }

    public void setFacLastFireClearDate(LocalDate facLastFireClearDate) {
        this.facLastFireClearDate = facLastFireClearDate;
    }

    @Basic
    @Column(name = "fac_sfm_id_nbr", nullable = true, length = 17)
    public String getFacSfmIdNbr() {
        return facSfmIdNbr;
    }

    public void setFacSfmIdNbr(String facSfmIdNbr) {
        this.facSfmIdNbr = facSfmIdNbr;
    }

    @Basic
    @Column(name = "fac_amb_1_17_nbr", nullable = true)
    public Integer getFacAmb117Nbr() {
        return facAmb117Nbr;
    }

    public void setFacAmb117Nbr(Integer facAmb117Nbr) {
        this.facAmb117Nbr = facAmb117Nbr;
    }

    @Basic
    @Column(name = "fac_amb_18_64_nbr", nullable = true)
    public Integer getFacAmb1864Nbr() {
        return facAmb1864Nbr;
    }

    public void setFacAmb1864Nbr(Integer facAmb1864Nbr) {
        this.facAmb1864Nbr = facAmb1864Nbr;
    }

    @Basic
    @Column(name = "fac_amb_65_plus_nbr", nullable = true)
    public Integer getFacAmb65PlusNbr() {
        return facAmb65PlusNbr;
    }

    public void setFacAmb65PlusNbr(Integer facAmb65PlusNbr) {
        this.facAmb65PlusNbr = facAmb65PlusNbr;
    }

    @Basic
    @Column(name = "fac_nonamb_1_17_nbr", nullable = true)
    public Integer getFacNonamb117Nbr() {
        return facNonamb117Nbr;
    }

    public void setFacNonamb117Nbr(Integer facNonamb117Nbr) {
        this.facNonamb117Nbr = facNonamb117Nbr;
    }

    @Basic
    @Column(name = "fac_nonamb_18_64_nbr", nullable = true)
    public Integer getFacNonamb1864Nbr() {
        return facNonamb1864Nbr;
    }

    public void setFacNonamb1864Nbr(Integer facNonamb1864Nbr) {
        this.facNonamb1864Nbr = facNonamb1864Nbr;
    }

    @Basic
    @Column(name = "fac_nonamb_65_plus_nbr", nullable = true)
    public Integer getFacNonamb65PlusNbr() {
        return facNonamb65PlusNbr;
    }

    public void setFacNonamb65PlusNbr(Integer facNonamb65PlusNbr) {
        this.facNonamb65PlusNbr = facNonamb65PlusNbr;
    }

    @Basic
    @Column(name = "fac_unlic_orig_input_date", nullable = true)
    public LocalDate getFacUnlicOrigInputDate() {
        return facUnlicOrigInputDate;
    }

    public void setFacUnlicOrigInputDate(LocalDate facUnlicOrigInputDate) {
        this.facUnlicOrigInputDate = facUnlicOrigInputDate;
    }

    @Basic
    @Column(name = "fac_closed_process_date", nullable = true)
    public LocalDate getFacClosedProcessDate() {
        return facClosedProcessDate;
    }

    public void setFacClosedProcessDate(LocalDate facClosedProcessDate) {
        this.facClosedProcessDate = facClosedProcessDate;
    }

    @Basic
    @Column(name = "fac_cap_inc_rec_date", nullable = true)
    public LocalDate getFacCapIncRecDate() {
        return facCapIncRecDate;
    }

    public void setFacCapIncRecDate(LocalDate facCapIncRecDate) {
        this.facCapIncRecDate = facCapIncRecDate;
    }

    @Basic
    @Column(name = "fac_region_nbr", nullable = true)
    public Integer getFacRegionNbr() {
        return facRegionNbr;
    }

    public void setFacRegionNbr(Integer facRegionNbr) {
        this.facRegionNbr = facRegionNbr;
    }

    @Basic
    @Column(name = "fac_last_defer_visit_date", nullable = true)
    public LocalDate getFacLastDeferVisitDate() {
        return facLastDeferVisitDate;
    }

    public void setFacLastDeferVisitDate(LocalDate facLastDeferVisitDate) {
        this.facLastDeferVisitDate = facLastDeferVisitDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fac_last_defer_visit_reason", referencedColumnName = "tbl_visit_reason_code")
    public VisitReasonType getFacLastDeferVisitReason() {
        return facLastDeferVisitReason;
    }

    public void setFacLastDeferVisitReason(VisitReasonType facLastDeferVisitReason) {
        this.facLastDeferVisitReason = facLastDeferVisitReason;
    }

    @Basic
    @Column(name = "fac_annual_visit_year", nullable = true)
    public Integer getFacAnnualVisitYear() {
        return facAnnualVisitYear;
    }

    public void setFacAnnualVisitYear(Integer facAnnualVisitYear) {
        this.facAnnualVisitYear = facAnnualVisitYear;
    }

    @Basic
    @Column(name = "fac_last_upd_date", nullable = true)
    public LocalDate getFacLastUpdDate() {
        return facLastUpdDate;
    }

    public void setFacLastUpdDate(LocalDate facLastUpdDate) {
        this.facLastUpdDate = facLastUpdDate;
    }

    @Basic
    @Column(name = "fac_cap_inc_closed_date", nullable = true)
    public LocalDate getFacCapIncClosedDate() {
        return facCapIncClosedDate;
    }

    public void setFacCapIncClosedDate(LocalDate facCapIncClosedDate) {
        this.facCapIncClosedDate = facCapIncClosedDate;
    }

    @Basic
    @Column(name = "fac_action_code", nullable = true, length = -1)
    public String getFacActionCode() {
        return facActionCode;
    }

    public void setFacActionCode(String facActionCode) {
        this.facActionCode = facActionCode;
    }

    @Basic
    @Column(name = "fac_inc_cap_eff_date", nullable = true)
    public LocalDate getFacIncCapEffDate() {
        return facIncCapEffDate;
    }

    public void setFacIncCapEffDate(LocalDate facIncCapEffDate) {
        this.facIncCapEffDate = facIncCapEffDate;
    }

    @Basic
    @Column(name = "fac_lic_comments_2", nullable = true, length = 210)
    public String getFacLicComments2() {
        return facLicComments2;
    }

    public void setFacLicComments2(String facLicComments2) {
        this.facLicComments2 = facLicComments2;
    }

    @Basic
    @Column(name = "fac_client_served_appr_date", nullable = true)
    public LocalDate getFacClientServedApprDate() {
        return facClientServedApprDate;
    }

    public void setFacClientServedApprDate(LocalDate facClientServedApprDate) {
        this.facClientServedApprDate = facClientServedApprDate;
    }

    @Basic
    @Column(name = "fac_legal_action_indicator", nullable = true, length = -1)
    public String getFacLegalActionIndicator() {
        return facLegalActionIndicator;
    }

    public void setFacLegalActionIndicator(String facLegalActionIndicator) {
        this.facLegalActionIndicator = facLegalActionIndicator;
    }

    @Basic
    @Column(name = "fac_agg_status", nullable = true, length = -1)
    public String getFacAggStatus() {
        return facAggStatus;
    }

    public void setFacAggStatus(String facAggStatus) {
        this.facAggStatus = facAggStatus;
    }

    @Basic
    @Column(name = "fac_primary_nbr", nullable = true)
    public Integer getFacPrimaryNbr() {
        return facPrimaryNbr;
    }

    public void setFacPrimaryNbr(Integer facPrimaryNbr) {
        this.facPrimaryNbr = facPrimaryNbr;
    }

    @Basic
    @Column(name = "fac_billing_date", nullable = true)
    public LocalDate getFacBillingDate() {
        return facBillingDate;
    }

    public void setFacBillingDate(LocalDate facBillingDate) {
        this.facBillingDate = facBillingDate;
    }

    @Basic
    @Column(name = "fac_dual_id", nullable = true, length = -1)
    public String getFacDualId() {
        return facDualId;
    }

    public void setFacDualId(String facDualId) {
        this.facDualId = facDualId;
    }

    @Basic
    @Column(name = "fac_dual_nbr", nullable = true, length = 9)
    public String getFacDualNbr() {
        return facDualNbr;
    }

    public void setFacDualNbr(String facDualNbr) {
        this.facDualNbr = facDualNbr;
    }

    @Basic
    @Column(name = "fac_fcrb_prgm_nbr", nullable = true, length = 8)
    public String getFacFcrbPrgmNbr() {
        return facFcrbPrgmNbr;
    }

    public void setFacFcrbPrgmNbr(String facFcrbPrgmNbr) {
        this.facFcrbPrgmNbr = facFcrbPrgmNbr;
    }

    @Basic
    @Column(name = "fac_gh_indicator", nullable = true, length = -1)
    public String getFacGhIndicator() {
        return facGhIndicator;
    }

    public void setFacGhIndicator(String facGhIndicator) {
        this.facGhIndicator = facGhIndicator;
    }

    @Basic
    @Column(name = "fac_complaint", nullable = true, length = -1)
    public String getFacComplaint() {
        return facComplaint;
    }

    public void setFacComplaint(String facComplaint) {
        this.facComplaint = facComplaint;
    }

    @Basic
    @Column(name = "fac_deficiency", nullable = true, length = -1)
    public String getFacDeficiency() {
        return facDeficiency;
    }

    public void setFacDeficiency(String facDeficiency) {
        this.facDeficiency = facDeficiency;
    }

    @Basic
    @Column(name = "fac_nbr_new", nullable = true)
    public Integer getFacNbrNew() {
        return facNbrNew;
    }

    public void setFacNbrNew(Integer facNbrNew) {
        this.facNbrNew = facNbrNew;
    }

    @Basic
    @Column(name = "fac_email_address", nullable = true, length = 40)
    public String getFacEmailAddress() {
        return facEmailAddress;
    }

    public void setFacEmailAddress(String facEmailAddress) {
        this.facEmailAddress = facEmailAddress;
    }

    @Basic
    @Column(name = "fac_pre_lic_visit_date", nullable = true)
    public LocalDate getFacPreLicVisitDate() {
        return facPreLicVisitDate;
    }

    public void setFacPreLicVisitDate(LocalDate facPreLicVisitDate) {
        this.facPreLicVisitDate = facPreLicVisitDate;
    }

    @Basic
    @Column(name = "fac_placement_ready", nullable = true, length = -1)
    public String getFacPlacementReady() {
        return facPlacementReady;
    }

    public void setFacPlacementReady(String facPlacementReady) {
        this.facPlacementReady = facPlacementReady;
    }

    @Basic
    @Column(name = "fac_placement_date", nullable = true)
    public LocalDate getFacPlacementDate() {
        return facPlacementDate;
    }

    public void setFacPlacementDate(LocalDate facPlacementDate) {
        this.facPlacementDate = facPlacementDate;
    }

    @Basic
    @Column(name = "fac_required_visit", nullable = true, length = -1)
    public String getFacRequiredVisit() {
        return facRequiredVisit;
    }

    public void setFacRequiredVisit(String facRequiredVisit) {
        this.facRequiredVisit = facRequiredVisit;
    }

    @Basic
    @Column(name = "fac_pin", nullable = true)
    public Integer getFacPin() {
        return facPin;
    }

    public void setFacPin(Integer facPin) {
        this.facPin = facPin;
    }

    @Basic
    @Column(name = "fac_old_ffa_nbr", nullable = true)
    public Integer getFacOldFfaNbr() {
        return facOldFfaNbr;
    }

    public void setFacOldFfaNbr(Integer facOldFfaNbr) {
        this.facOldFfaNbr = facOldFfaNbr;
    }

    @Basic
    @Column(name = "fac_inactive_notice_date", nullable = true)
    public LocalDate getFacInactiveNoticeDate() {
        return facInactiveNoticeDate;
    }

    public void setFacInactiveNoticeDate(LocalDate facInactiveNoticeDate) {
        this.facInactiveNoticeDate = facInactiveNoticeDate;
    }

    @Basic
    @Column(name = "fac_inactive_start_date", nullable = true)
    public LocalDate getFacInactiveStartDate() {
        return facInactiveStartDate;
    }

    public void setFacInactiveStartDate(LocalDate facInactiveStartDate) {
        this.facInactiveStartDate = facInactiveStartDate;
    }

    @Basic
    @Column(name = "fac_sod_match_date", nullable = true)
    public LocalDate getFacSodMatchDate() {
        return facSodMatchDate;
    }

    public void setFacSodMatchDate(LocalDate facSodMatchDate) {
        this.facSodMatchDate = facSodMatchDate;
    }

    @Basic
    @Column(name = "fac_addr_key", nullable = true, length = 19)
    public String getFacAddrKey() {
        return facAddrKey;
    }

    public void setFacAddrKey(String facAddrKey) {
        this.facAddrKey = facAddrKey;
    }

    @Basic
    @Column(name = "fac_loc_indicator", nullable = true, length = -1)
    public String getFacLocIndicator() {
        return facLocIndicator;
    }

    public void setFacLocIndicator(String facLocIndicator) {
        this.facLocIndicator = facLocIndicator;
    }

    @Basic
    @Column(name = "fac_type999_caci_indicator", nullable = true, length = -1)
    public String getFacType999CaciIndicator() {
        return facType999CaciIndicator;
    }

    public void setFacType999CaciIndicator(String facType999CaciIndicator) {
        this.facType999CaciIndicator = facType999CaciIndicator;
    }

    @Basic
    @Column(name = "fac_bilingual", nullable = true)
    public Integer getFacBilingual() {
        return facBilingual;
    }

    public void setFacBilingual(Integer facBilingual) {
        this.facBilingual = facBilingual;
    }

    @Basic
    @Column(name = "fac_region_do", nullable = false)
    public Integer getFacRegionDo() {
        return facRegionDo;
    }

    public void setFacRegionDo(Integer facRegionDo) {
        this.facRegionDo = facRegionDo;
    }

    @Basic
    @Column(name = "fac_region_co", nullable = false)
    public Integer getFacRegionCo() {
        return facRegionCo;
    }

    public void setFacRegionCo(Integer facRegionCo) {
        this.facRegionCo = facRegionCo;
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
        return getIsnLisFacFile();
    }
}
