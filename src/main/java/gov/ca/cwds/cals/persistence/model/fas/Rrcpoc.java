package gov.ca.cwds.cals.persistence.model.fas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

import static gov.ca.cwds.cals.persistence.model.fas.Rrcpoc.NQ_FIND_BY_FACILITY_NUMBER;
import static gov.ca.cwds.cals.persistence.model.fas.Rrcpoc.NQ_FIND_BY_FACILITY_NUMBER_AND_INSPECTION_ID;

/**
 * @author CWDS CALS API Team
 */

@NamedQuery(
        name = NQ_FIND_BY_FACILITY_NUMBER,
        query = "SELECT pocs FROM Rrcpoc pocs WHERE pocs.facilityNumberText = :facilityNumberText"
)
@NamedQuery(
        name = NQ_FIND_BY_FACILITY_NUMBER_AND_INSPECTION_ID,
        query = "SELECT pocs FROM Rrcpoc pocs WHERE pocs.facilityNumberText = :facilityNumberText " +
                "AND pocs.createDateTime = :inspectionId"
)
@Entity
@Table(name = "rrcpoc", schema = "fas")
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class Rrcpoc implements PersistentObject {

    private static final long serialVersionUID = -6022589439025838467L;

    public static final String NQ_FIND_BY_FACILITY_NUMBER = "Rrcpoc.findByFacilityNumber";
    public static final String NQ_FIND_BY_FACILITY_NUMBER_AND_INSPECTION_ID =
            "Rrcpoc.findByFacilityNumberAndInspectionId";

    private String facilityNumberText;
    private String pocComments3;
    private LocalDateTime pocDatecleared3;
    private String cpocSectionviolated3;
    private LocalDateTime cpocPocDate3;
    private String pocCommentsCont3Cont;
    private String pocComments2;
    private LocalDateTime pocDatecleared2;
    private String cpocSectionviolated2;
    private LocalDateTime cpocPocDate2;
    private String pocCommentsCont1;
    private String pocComments1;
    private LocalDateTime pocDatecleared1;
    private String cpocSectionviolated1;
    private LocalDateTime cpocPocDate1;
    private String pocCommentsCont;
    private String pocComments;
    private LocalDateTime pocDatecleared;
    private String cpocSectionviolated;
    private LocalDateTime cpocPocDate;
    private String createDateTime;

    @Basic
    @Column(name = "facility_number_text")
    public String getFacilityNumberText() {
        return facilityNumberText;
    }

    public void setFacilityNumberText(String facilityNumberText) {
        this.facilityNumberText = facilityNumberText;
    }

    @Basic
    @Column(name = "poc_comments_3")
    public String getPocComments3() {
        return pocComments3;
    }

    public void setPocComments3(String pocComments3) {
        this.pocComments3 = pocComments3;
    }

    @Basic
    @Column(name = "poc_datecleared_3")
    public LocalDateTime getPocDatecleared3() {
        return pocDatecleared3;
    }

    public void setPocDatecleared3(LocalDateTime pocDatecleared3) {
        this.pocDatecleared3 = pocDatecleared3;
    }

    @Basic
    @Column(name = "cpoc_sectionviolated_3")
    public String getCpocSectionviolated3() {
        return cpocSectionviolated3;
    }

    public void setCpocSectionviolated3(String cpocSectionviolated3) {
        this.cpocSectionviolated3 = cpocSectionviolated3;
    }

    @Basic
    @Column(name = "cpoc_poc_date_3")
    public LocalDateTime getCpocPocDate3() {
        return cpocPocDate3;
    }

    public void setCpocPocDate3(LocalDateTime cpocPocDate3) {
        this.cpocPocDate3 = cpocPocDate3;
    }

    @Basic
    @Column(name = "poc_comments_cont_3_cont")
    public String getPocCommentsCont3Cont() {
        return pocCommentsCont3Cont;
    }

    public void setPocCommentsCont3Cont(String pocCommentsCont3Cont) {
        this.pocCommentsCont3Cont = pocCommentsCont3Cont;
    }

    @Basic
    @Column(name = "poc_comments_2")
    public String getPocComments2() {
        return pocComments2;
    }

    public void setPocComments2(String pocComments2) {
        this.pocComments2 = pocComments2;
    }

    @Basic
    @Column(name = "poc_datecleared_2")
    public LocalDateTime getPocDatecleared2() {
        return pocDatecleared2;
    }

    public void setPocDatecleared2(LocalDateTime pocDatecleared2) {
        this.pocDatecleared2 = pocDatecleared2;
    }

    @Basic
    @Column(name = "cpoc_sectionviolated_2")
    public String getCpocSectionviolated2() {
        return cpocSectionviolated2;
    }

    public void setCpocSectionviolated2(String cpocSectionviolated2) {
        this.cpocSectionviolated2 = cpocSectionviolated2;
    }

    @Basic
    @Column(name = "cpoc_poc_date_2")
    public LocalDateTime getCpocPocDate2() {
        return cpocPocDate2;
    }

    public void setCpocPocDate2(LocalDateTime cpocPocDate2) {
        this.cpocPocDate2 = cpocPocDate2;
    }

    @Basic
    @Column(name = "poc_comments_cont_1")
    public String getPocCommentsCont1() {
        return pocCommentsCont1;
    }

    public void setPocCommentsCont1(String pocCommentsCont1) {
        this.pocCommentsCont1 = pocCommentsCont1;
    }

    @Basic
    @Column(name = "poc_comments_1")
    public String getPocComments1() {
        return pocComments1;
    }

    public void setPocComments1(String pocComments1) {
        this.pocComments1 = pocComments1;
    }

    @Basic
    @Column(name = "poc_datecleared_1")
    public LocalDateTime getPocDatecleared1() {
        return pocDatecleared1;
    }

    public void setPocDatecleared1(LocalDateTime pocDatecleared1) {
        this.pocDatecleared1 = pocDatecleared1;
    }

    @Basic
    @Column(name = "cpoc_sectionviolated_1")
    public String getCpocSectionviolated1() {
        return cpocSectionviolated1;
    }

    public void setCpocSectionviolated1(String cpocSectionviolated1) {
        this.cpocSectionviolated1 = cpocSectionviolated1;
    }

    @Basic
    @Column(name = "cpoc_poc_date_1")
    public LocalDateTime getCpocPocDate1() {
        return cpocPocDate1;
    }

    public void setCpocPocDate1(LocalDateTime cpocPocDate1) {
        this.cpocPocDate1 = cpocPocDate1;
    }

    @Basic
    @Column(name = "poc_comments_cont")
    public String getPocCommentsCont() {
        return pocCommentsCont;
    }

    public void setPocCommentsCont(String pocCommentsCont) {
        this.pocCommentsCont = pocCommentsCont;
    }

    @Basic
    @Column(name = "poc_comments")
    public String getPocComments() {
        return pocComments;
    }

    public void setPocComments(String pocComments) {
        this.pocComments = pocComments;
    }

    @Basic
    @Column(name = "poc_datecleared")
    public LocalDateTime getPocDatecleared() {
        return pocDatecleared;
    }

    public void setPocDatecleared(LocalDateTime pocDatecleared) {
        this.pocDatecleared = pocDatecleared;
    }

    @Basic
    @Column(name = "cpoc_sectionviolated")
    public String getCpocSectionviolated() {
        return cpocSectionviolated;
    }

    public void setCpocSectionviolated(String cpocSectionviolated) {
        this.cpocSectionviolated = cpocSectionviolated;
    }

    @Basic
    @Column(name = "cpoc_poc_date")
    public LocalDateTime getCpocPocDate() {
        return cpocPocDate;
    }

    public void setCpocPocDate(LocalDateTime cpocPocDate) {
        this.cpocPocDate = cpocPocDate;
    }

    @Id
    @Column(name = "create_date_time")
    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
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
        return createDateTime;
    }
}
