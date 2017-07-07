package gov.ca.cwds.cals.persistence.model.fas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author CWDS CALS API Team
 */

@NamedQuery(
        name = ComplaintReportLic802.FIND_COMPLAINTS_BY_FACILITY_ID,
        query = "SELECT c FROM ComplaintReportLic802 c WHERE c.crp2FacilityNumber = :" +
                ComplaintReportLic802.PARAM_FACILITY_NUMBER
)
@NamedQuery(
        name = ComplaintReportLic802.FIND_COMPLAINTS_BY_FACILITY_ID_AND_COMPLAINT_NUMBER,
        query = "SELECT c FROM ComplaintReportLic802 c WHERE c.crp2FacilityNumber = :" +
                ComplaintReportLic802.PARAM_FACILITY_NUMBER + " AND c.originalunidkey = :" +
                ComplaintReportLic802.PARAM_COMPLAINT_ID
)
@Entity
@Access(AccessType.FIELD)
@Table(name = "complaint_report_lic802", schema = "fas")
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class ComplaintReportLic802 implements PersistentObject {

    public static final String FIND_COMPLAINTS_BY_FACILITY_ID = "findComplaintsByFacilityId";
    public static final String FIND_COMPLAINTS_BY_FACILITY_ID_AND_COMPLAINT_NUMBER = "findComplaintsByFacilityIdAndFacilityNumber";


    public static final String PARAM_FACILITY_NUMBER = "facilityNumber";
    public static final String PARAM_COMPLAINT_ID = "complaintId";

    @Id
    @Column(name = "originalunidkey", length = 256)
    private String originalunidkey;
    @Basic
    @Column(name = "crp2_followup", length = 256)
    private String crp2Followup;
    @Basic
    @Column(name = "crp2_contactsummary", length = 8192)
    private String crp2Contactsummary;
    @Basic
    @Column(name = "crp2_postcomments", length = 8192)
    private String crp2Postcomments;
    @Basic
    @Column(name = "crp2_precomments", length = 8192)
    private String crp2Precomments;
    @Basic
    @Column(name = "cr_receivedby", length = 256)
    private String crReceivedby;
    @Basic
    @Column(name = "cr_status")
    private String crStatus;
    @Basic
    @Column(name = "cr_date")
    private LocalDate crDate;
    @Basic
    @Column(name = "cr_unsub_7", length = 256)
    private String crUnSub7;
    @Basic
    @Column(name = "cr_insub_7", length = 256)
    private String crInSub7;
    @Basic
    @Column(name = "cr_sub_7", length = 256)
    private String crSub7;
    @Basic
    @Column(name = "cr_allegation_7", length = 256)
    private String crAllegation7;
    @Basic
    @Column(name = "cr_code_7", length = 256)
    private String crCode7;
    @Basic
    @Column(name = "cr_unsub_6", length = 256)
    private String crUnSub6;
    @Basic
    @Column(name = "cr_insub_6", length = 256)
    private String crInSub6;
    @Basic
    @Column(name = "cr_sub_6", length = 256)
    private String crSub6;
    @Basic
    @Column(name = "cr_allegation_6", length = 256)
    private String crAllegation6;
    @Basic
    @Column(name = "cr_code_6", length = 256)
    private String crCode6;
    @Basic
    @Column(name = "cr_unsub_5", length = 256)
    private String crUnSub5;
    @Basic
    @Column(name = "cr_insub_5", length = 256)
    private String crInSub5;
    @Basic
    @Column(name = "cr_sub_5", length = 256)
    private String crSub5;
    @Basic
    @Column(name = "cr_allegation_5", length = 256)
    private String crAllegation5;
    @Basic
    @Column(name = "cr_code_5", length = 256)
    private String crCode5;
    @Basic
    @Column(name = "cr_unsub_4", length = 256)
    private String crUnSub4;
    @Basic
    @Column(name = "cr_insub_4", length = 256)
    private String crInSub4;
    @Basic
    @Column(name = "cr_sub_4", length = 256)
    private String crSub4;
    @Basic
    @Column(name = "cr_allegation_4", length = 256)
    private String crAllegation4;
    @Basic
    @Column(name = "cr_code_4", length = 256)
    private String crCode4;
    @Basic
    @Column(name = "cr_unsub_3", length = 256)
    private String crUnSub3;
    @Basic
    @Column(name = "cr_insub_3", length = 256)
    private String crInSub3;
    @Basic
    @Column(name = "cr_sub_3", length = 256)
    private String crSub3;
    @Basic
    @Column(name = "cr_allegation_3", length = 256)
    private String crAllegation3;
    @Basic
    @Column(name = "cr_code_3", length = 256)
    private String crCode3;
    @Basic
    @Column(name = "cr_unsub_2", length = 256)
    private String crUnSub2;
    @Basic
    @Column(name = "cr_insub_2", length = 256)
    private String crInSub2;
    @Basic
    @Column(name = "cr_sub_2", length = 256)
    private String crSub2;
    @Basic
    @Column(name = "cr_allegation_2", length = 256)
    private String crAllegation2;
    @Basic
    @Column(name = "cr_code_2", length = 256)
    private String crCode2;
    @Basic
    @Column(name = "cr_unsub_1", length = 256)
    private String crUnSub1;
    @Basic
    @Column(name = "cr_insub_1", length = 256)
    private String crInSub1;
    @Basic
    @Column(name = "cr_sub_1", length = 256)
    private String crSub1;
    @Basic
    @Column(name = "cr_allegation_1", length = 256)
    private String crAllegation1;
    @Basic
    @Column(name = "cr_code_1", length = 256)
    private String crCode1;
    @Basic
    @Column(name = "cr_unsub", length = 256)
    private String crUnSub;
    @Basic
    @Column(name = "cr_insub", length = 256)
    private String crInSub;
    @Basic
    @Column(name = "cr_sub", length = 256)
    private String crSub;
    @Basic
    @Column(name = "cr_allegation", length = 256)
    private String crAllegation;
    @Basic
    @Column(name = "cr_code", length = 256)
    private String crCode;
    @Basic
    @Column(name = "cr_controlnumber", length = 256)
    private String crControlnumber;
    @Basic
    @Column(name = "cr_prioritynr", length = 256)
    private String crPrioritynr;
    @Basic
    @Column(name = "crp2_facility_number", length = 256)
    private Integer crp2FacilityNumber;
    @Basic
    @Column(name = "lpa_assigned", length = 256)
    private String lpaAssigned;
    @Basic
    @Column(name = "date_signed")
    private LocalDateTime dateSigned;

    public LocalDate getCrDate() {
        return crDate;
    }

    public void setCrDate(LocalDate crDate) {
        this.crDate = crDate;
    }

    public Integer getCrp2FacilityNumber() {
        return crp2FacilityNumber;
    }

    public void setCrp2FacilityNumber(Integer crp2FacilityNumber) {
        this.crp2FacilityNumber = crp2FacilityNumber;
    }

    public String getCrStatus() {
        return crStatus;
    }

    public void setCrStatus(String crStatus) {
        this.crStatus = crStatus;
    }

    public String getOriginalunidkey() {
        return originalunidkey;
    }

    public void setOriginalunidkey(String originalunidkey) {
        this.originalunidkey = originalunidkey;
    }

    public String getCrp2Followup() {
        return crp2Followup;
    }

    public void setCrp2Followup(String crp2Followup) {
        this.crp2Followup = crp2Followup;
    }

    public String getCrp2Contactsummary() {
        return crp2Contactsummary;
    }

    public void setCrp2Contactsummary(String crp2Contactsummary) {
        this.crp2Contactsummary = crp2Contactsummary;
    }

    public String getCrp2Postcomments() {
        return crp2Postcomments;
    }

    public void setCrp2Postcomments(String crp2Postcomments) {
        this.crp2Postcomments = crp2Postcomments;
    }

    public String getCrp2Precomments() {
        return crp2Precomments;
    }

    public void setCrp2Precomments(String crp2Precomments) {
        this.crp2Precomments = crp2Precomments;
    }

    public String getCrReceivedby() {
        return crReceivedby;
    }

    public void setCrReceivedby(String crReceivedby) {
        this.crReceivedby = crReceivedby;
    }

    public String getCrAllegation7() {
        return crAllegation7;
    }

    public void setCrAllegation7(String crAllegation7) {
        this.crAllegation7 = crAllegation7;
    }

    public String getCrCode7() {
        return crCode7;
    }

    public void setCrCode7(String crCode7) {
        this.crCode7 = crCode7;
    }

    public String getCrAllegation6() {
        return crAllegation6;
    }

    public void setCrAllegation6(String crAllegation6) {
        this.crAllegation6 = crAllegation6;
    }

    public String getCrCode6() {
        return crCode6;
    }

    public void setCrCode6(String crCode6) {
        this.crCode6 = crCode6;
    }

    public String getCrAllegation5() {
        return crAllegation5;
    }

    public void setCrAllegation5(String crAllegation5) {
        this.crAllegation5 = crAllegation5;
    }

    public String getCrCode5() {
        return crCode5;
    }

    public void setCrCode5(String crCode5) {
        this.crCode5 = crCode5;
    }

    public String getCrAllegation4() {
        return crAllegation4;
    }

    public void setCrAllegation4(String crAllegation4) {
        this.crAllegation4 = crAllegation4;
    }

    public String getCrCode4() {
        return crCode4;
    }

    public void setCrCode4(String crCode4) {
        this.crCode4 = crCode4;
    }

    public String getCrAllegation3() {
        return crAllegation3;
    }

    public void setCrAllegation3(String crAllegation3) {
        this.crAllegation3 = crAllegation3;
    }

    public String getCrCode3() {
        return crCode3;
    }

    public void setCrCode3(String crCode3) {
        this.crCode3 = crCode3;
    }

    public String getCrAllegation2() {
        return crAllegation2;
    }

    public void setCrAllegation2(String crAllegation2) {
        this.crAllegation2 = crAllegation2;
    }

    public String getCrCode2() {
        return crCode2;
    }

    public void setCrCode2(String crCode2) {
        this.crCode2 = crCode2;
    }

    public String getCrAllegation1() {
        return crAllegation1;
    }

    public void setCrAllegation1(String crAllegation1) {
        this.crAllegation1 = crAllegation1;
    }

    public String getCrCode1() {
        return crCode1;
    }

    public void setCrCode1(String crCode1) {
        this.crCode1 = crCode1;
    }

    public String getCrAllegation() {
        return crAllegation;
    }

    public void setCrAllegation(String crAllegation) {
        this.crAllegation = crAllegation;
    }

    public String getCrCode() {
        return crCode;
    }

    public void setCrCode(String crCode) {
        this.crCode = crCode;
    }

    public String getCrControlnumber() {
        return crControlnumber;
    }

    public void setCrControlnumber(String crControlnumber) {
        this.crControlnumber = crControlnumber;
    }

    public String getCrPrioritynr() {
        return crPrioritynr;
    }

    public void setCrPrioritynr(String crPrioritynr) {
        this.crPrioritynr = crPrioritynr;
    }

    public String getLpaAssigned() {
        return lpaAssigned;
    }

    public void setLpaAssigned(String lpaAssigned) {
        this.lpaAssigned = lpaAssigned;
    }

    public LocalDateTime getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(LocalDateTime dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getCrUnSub7() {
        return crUnSub7;
    }

    public void setCrUnSub7(String crUnSub7) {
        this.crUnSub7 = crUnSub7;
    }

    public String getCrInSub7() {
        return crInSub7;
    }

    public void setCrInSub7(String crInSub7) {
        this.crInSub7 = crInSub7;
    }

    public String getCrSub7() {
        return crSub7;
    }

    public void setCrSub7(String crSub7) {
        this.crSub7 = crSub7;
    }

    public String getCrUnSub6() {
        return crUnSub6;
    }

    public void setCrUnSub6(String crUnSub6) {
        this.crUnSub6 = crUnSub6;
    }

    public String getCrInSub6() {
        return crInSub6;
    }

    public void setCrInSub6(String crInSub6) {
        this.crInSub6 = crInSub6;
    }

    public String getCrSub6() {
        return crSub6;
    }

    public void setCrSub6(String crSub6) {
        this.crSub6 = crSub6;
    }

    public String getCrUnSub5() {
        return crUnSub5;
    }

    public void setCrUnSub5(String crUnSub5) {
        this.crUnSub5 = crUnSub5;
    }

    public String getCrInSub5() {
        return crInSub5;
    }

    public void setCrInSub5(String crInSub5) {
        this.crInSub5 = crInSub5;
    }

    public String getCrSub5() {
        return crSub5;
    }

    public void setCrSub5(String crSub5) {
        this.crSub5 = crSub5;
    }

    public String getCrUnSub4() {
        return crUnSub4;
    }

    public void setCrUnSub4(String crUnSub4) {
        this.crUnSub4 = crUnSub4;
    }

    public String getCrInSub4() {
        return crInSub4;
    }

    public void setCrInSub4(String crInSub4) {
        this.crInSub4 = crInSub4;
    }

    public String getCrSub4() {
        return crSub4;
    }

    public void setCrSub4(String crSub4) {
        this.crSub4 = crSub4;
    }

    public String getCrUnSub3() {
        return crUnSub3;
    }

    public void setCrUnSub3(String crUnSub3) {
        this.crUnSub3 = crUnSub3;
    }

    public String getCrInSub3() {
        return crInSub3;
    }

    public void setCrInSub3(String crInSub3) {
        this.crInSub3 = crInSub3;
    }

    public String getCrSub3() {
        return crSub3;
    }

    public void setCrSub3(String crSub3) {
        this.crSub3 = crSub3;
    }

    public String getCrUnSub2() {
        return crUnSub2;
    }

    public void setCrUnSub2(String crUnSub2) {
        this.crUnSub2 = crUnSub2;
    }

    public String getCrInSub2() {
        return crInSub2;
    }

    public void setCrInSub2(String crInSub2) {
        this.crInSub2 = crInSub2;
    }

    public String getCrSub2() {
        return crSub2;
    }

    public void setCrSub2(String crSub2) {
        this.crSub2 = crSub2;
    }

    public String getCrUnSub1() {
        return crUnSub1;
    }

    public void setCrUnSub1(String crUnSub1) {
        this.crUnSub1 = crUnSub1;
    }

    public String getCrInSub1() {
        return crInSub1;
    }

    public void setCrInSub1(String crInSub1) {
        this.crInSub1 = crInSub1;
    }

    public String getCrSub1() {
        return crSub1;
    }

    public void setCrSub1(String crSub1) {
        this.crSub1 = crSub1;
    }

    public String getCrUnSub() {
        return crUnSub;
    }

    public void setCrUnSub(String crUnSub) {
        this.crUnSub = crUnSub;
    }

    public String getCrInSub() {
        return crInSub;
    }

    public void setCrInSub(String crInSub) {
        this.crInSub = crInSub;
    }

    public String getCrSub() {
        return crSub;
    }

    public void setCrSub(String crSub) {
        this.crSub = crSub;
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
    public Serializable getPrimaryKey() {
        return originalunidkey;
    }
}
