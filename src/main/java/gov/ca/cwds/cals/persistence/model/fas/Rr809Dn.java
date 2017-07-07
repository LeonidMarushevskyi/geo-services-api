package gov.ca.cwds.cals.persistence.model.fas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

import static gov.ca.cwds.cals.persistence.model.fas.Rr809Dn.NQ_FIND_BY_FACILITY_NUMBER;
import static gov.ca.cwds.cals.persistence.model.fas.Rr809Dn.NQ_FIND_BY_FACILITY_NUMBER_AND_DEFICIENCY_ID;

/**
 * @author CWDS CALS API Team
 */

@NamedQuery(
        name = NQ_FIND_BY_FACILITY_NUMBER,
        query = "FROM Rr809Dn d WHERE d.facilityNumberText = :facilityNumberText"
)

@NamedQuery(
        name = NQ_FIND_BY_FACILITY_NUMBER_AND_DEFICIENCY_ID,
        query = "FROM Rr809Dn d WHERE d.facilityNumberText = :facilityNumberText " +
                "AND d.originalunidkey = :deficiencyId"
)

@Entity
@Table(name = "rr809dn", schema = "fas")
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class Rr809Dn implements PersistentObject {

    private static final long serialVersionUID = 704473363282773670L;

    public static final String NQ_FIND_BY_FACILITY_NUMBER = "Rr809Dn.findByFacilityNumber";
    public static final String NQ_FIND_BY_FACILITY_NUMBER_AND_DEFICIENCY_ID =
            "Rr809Dn.findByFacilityNumberAndInspectionId";

    private String originalunidkey;
    private String correctionPlan3;
    private String deficiency13;
    private String facSectionviolated3;
    private LocalDateTime pocDate3;
    private String deftype4Ab;
    private String correctionPlan3Cont;
    private String deficiency3Cont;
    private String correctionPlan2;
    private String deficiency12;
    private String facSectionviolated2;
    private LocalDateTime pocDate2;
    private String deftype3Ab;
    private String correctionPlan2Cont;
    private String deficiency2Cont;
    private String correctionPlan1;
    private String deficiency11;
    private String facSectionviolated1;
    private LocalDateTime pocDate1;
    private String deftype2Ab;
    private String correctionPlanCont;
    private String deficiency1Cont;
    private String correctionPlan;
    private String deficiency1;
    private String facSectionviolated;
    private LocalDateTime pocDate;
    private String deftype1;
    private String facilityNumberText;
    private LocalDateTime dateSigned;
    private Rrcpoc rrcpoc;


    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "facility_number_text", referencedColumnName = "facility_number_text", insertable = false, updatable = false),
            @JoinColumn(name = "fac_SectionViolated", referencedColumnName = "cpoc_SectionViolated", insertable = false, updatable = false),
            @JoinColumn(name = "POC_Date", referencedColumnName = "cpoc_POC_Date", insertable = false, updatable = false)
    })
    public Rrcpoc getRrcpoc() {
        return rrcpoc;
    }

    public void setRrcpoc(Rrcpoc rrcpoc) {
        this.rrcpoc = rrcpoc;
    }

    @Id
    @Column(name = "originalunidkey")
    public String getOriginalunidkey() {
        return originalunidkey;
    }

    public void setOriginalunidkey(String originalunidkey) {
        this.originalunidkey = originalunidkey;
    }

    @Basic
    @Column(name = "correction_plan_3")
    public String getCorrectionPlan3() {
        return correctionPlan3;
    }

    public void setCorrectionPlan3(String correctionPlan3) {
        this.correctionPlan3 = correctionPlan3;
    }

    @Basic
    @Column(name = "deficiency_1_3")
    public String getDeficiency13() {
        return deficiency13;
    }

    public void setDeficiency13(String deficiency13) {
        this.deficiency13 = deficiency13;
    }

    @Basic
    @Column(name = "fac_sectionviolated_3")
    public String getFacSectionviolated3() {
        return facSectionviolated3;
    }

    public void setFacSectionviolated3(String facSectionviolated3) {
        this.facSectionviolated3 = facSectionviolated3;
    }

    @Basic
    @Column(name = "poc_date_3")
    public LocalDateTime getPocDate3() {
        return pocDate3;
    }

    public void setPocDate3(LocalDateTime pocDate3) {
        this.pocDate3 = pocDate3;
    }

    @Basic
    @Column(name = "deftype4_ab")
    public String getDeftype4Ab() {
        return deftype4Ab;
    }

    public void setDeftype4Ab(String deftype4Ab) {
        this.deftype4Ab = deftype4Ab;
    }

    @Basic
    @Column(name = "correction_plan_3_cont")
    public String getCorrectionPlan3Cont() {
        return correctionPlan3Cont;
    }

    public void setCorrectionPlan3Cont(String correctionPlan3Cont) {
        this.correctionPlan3Cont = correctionPlan3Cont;
    }

    @Basic
    @Column(name = "deficiency_3_cont")
    public String getDeficiency3Cont() {
        return deficiency3Cont;
    }

    public void setDeficiency3Cont(String deficiency3Cont) {
        this.deficiency3Cont = deficiency3Cont;
    }

    @Basic
    @Column(name = "correction_plan_2")
    public String getCorrectionPlan2() {
        return correctionPlan2;
    }

    public void setCorrectionPlan2(String correctionPlan2) {
        this.correctionPlan2 = correctionPlan2;
    }

    @Basic
    @Column(name = "deficiency_1_2")
    public String getDeficiency12() {
        return deficiency12;
    }

    public void setDeficiency12(String deficiency12) {
        this.deficiency12 = deficiency12;
    }

    @Basic
    @Column(name = "fac_sectionviolated_2")
    public String getFacSectionviolated2() {
        return facSectionviolated2;
    }

    public void setFacSectionviolated2(String facSectionviolated2) {
        this.facSectionviolated2 = facSectionviolated2;
    }

    @Basic
    @Column(name = "poc_date_2")
    public LocalDateTime getPocDate2() {
        return pocDate2;
    }

    public void setPocDate2(LocalDateTime pocDate2) {
        this.pocDate2 = pocDate2;
    }

    @Basic
    @Column(name = "deftype3_ab")
    public String getDeftype3Ab() {
        return deftype3Ab;
    }

    public void setDeftype3Ab(String deftype3Ab) {
        this.deftype3Ab = deftype3Ab;
    }

    @Basic
    @Column(name = "correction_plan_2_cont")
    public String getCorrectionPlan2Cont() {
        return correctionPlan2Cont;
    }

    public void setCorrectionPlan2Cont(String correctionPlan2Cont) {
        this.correctionPlan2Cont = correctionPlan2Cont;
    }

    @Basic
    @Column(name = "deficiency_2_cont")
    public String getDeficiency2Cont() {
        return deficiency2Cont;
    }

    public void setDeficiency2Cont(String deficiency2Cont) {
        this.deficiency2Cont = deficiency2Cont;
    }

    @Basic
    @Column(name = "correction_plan_1")
    public String getCorrectionPlan1() {
        return correctionPlan1;
    }

    public void setCorrectionPlan1(String correctionPlan1) {
        this.correctionPlan1 = correctionPlan1;
    }

    @Basic
    @Column(name = "deficiency_1_1")
    public String getDeficiency11() {
        return deficiency11;
    }

    public void setDeficiency11(String deficiency11) {
        this.deficiency11 = deficiency11;
    }

    @Basic
    @Column(name = "fac_sectionviolated_1")
    public String getFacSectionviolated1() {
        return facSectionviolated1;
    }

    public void setFacSectionviolated1(String facSectionviolated1) {
        this.facSectionviolated1 = facSectionviolated1;
    }

    @Basic
    @Column(name = "poc_date_1")
    public LocalDateTime getPocDate1() {
        return pocDate1;
    }

    public void setPocDate1(LocalDateTime pocDate1) {
        this.pocDate1 = pocDate1;
    }

    @Basic
    @Column(name = "deftype2_ab")
    public String getDeftype2Ab() {
        return deftype2Ab;
    }

    public void setDeftype2Ab(String deftype2Ab) {
        this.deftype2Ab = deftype2Ab;
    }

    @Basic
    @Column(name = "correction_plan_cont")
    public String getCorrectionPlanCont() {
        return correctionPlanCont;
    }

    public void setCorrectionPlanCont(String correctionPlanCont) {
        this.correctionPlanCont = correctionPlanCont;
    }

    @Basic
    @Column(name = "deficiency_1_cont")
    public String getDeficiency1Cont() {
        return deficiency1Cont;
    }

    public void setDeficiency1Cont(String deficiency1Cont) {
        this.deficiency1Cont = deficiency1Cont;
    }

    @Basic
    @Column(name = "correction_plan")
    public String getCorrectionPlan() {
        return correctionPlan;
    }

    public void setCorrectionPlan(String correctionPlan) {
        this.correctionPlan = correctionPlan;
    }

    @Basic
    @Column(name = "deficiency_1")
    public String getDeficiency1() {
        return deficiency1;
    }

    public void setDeficiency1(String deficiency1) {
        this.deficiency1 = deficiency1;
    }

    @Basic
    @Column(name = "fac_sectionviolated")
    public String getFacSectionviolated() {
        return facSectionviolated;
    }

    public void setFacSectionviolated(String facSectionviolated) {
        this.facSectionviolated = facSectionviolated;
    }

    @Basic
    @Column(name = "poc_date")
    public LocalDateTime getPocDate() {
        return pocDate;
    }

    public void setPocDate(LocalDateTime pocDate) {
        this.pocDate = pocDate;
    }

    @Basic
    @Column(name = "deftype1")
    public String getDeftype1() {
        return deftype1;
    }

    public void setDeftype1(String deftype1) {
        this.deftype1 = deftype1;
    }

    @Basic
    @Column(name = "facility_number_text")
    public String getFacilityNumberText() {
        return facilityNumberText;
    }

    public void setFacilityNumberText(String facilityNumberText) {
        this.facilityNumberText = facilityNumberText;
    }

    @Basic
    @Column(name = "date_signed")
    public LocalDateTime getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(LocalDateTime dateSigned) {
        this.dateSigned = dateSigned;
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
        return originalunidkey;
    }
}
