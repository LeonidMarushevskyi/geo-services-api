package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import gov.ca.cwds.rest.validation.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;
import static gov.ca.cwds.rest.api.domain.DomainObject.TIME_FORMAT;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S3437") //LocalDate is serializable
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FacilityDeficiencyDTO extends BaseDTO {
    private static final long serialVersionUID = -3548530142566196513L;

    @RemoveTrailingSpaces
    private String deficiencyType;

    private LocalDateTime pocDate;

    @RemoveTrailingSpaces
    private String facSectionViolated;

    @RemoveTrailingSpaces
    private String deficiency;

    @RemoveTrailingSpaces
    private String correctionPlan;

    private LocalDateTime pocDateCleared;

    @RemoveTrailingSpaces
    private String pocComment;

    public String getDeficiencyType() {
        return deficiencyType;
    }

    public void setDeficiencyType(String deficiencyType) {
        this.deficiencyType = deficiencyType;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
    @Date(format = DATE_FORMAT + " " + TIME_FORMAT)
    public LocalDateTime getPocDate() {
        return pocDate;
    }

    public void setPocDate(LocalDateTime pocDate) {
        this.pocDate = pocDate;
    }

    public String getFacSectionViolated() {
        return facSectionViolated;
    }

    public void setFacSectionViolated(String facSectionViolated) {
        this.facSectionViolated = facSectionViolated;
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency;
    }

    public String getCorrectionPlan() {
        return correctionPlan;
    }

    public void setCorrectionPlan(String correctionPlan) {
        this.correctionPlan = correctionPlan;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
    @Date(format = DATE_FORMAT + " " + TIME_FORMAT)
    public LocalDateTime getPocDateCleared() {
        return pocDateCleared;
    }

    public void setPocDateCleared(LocalDateTime pocDateCleared) {
        this.pocDateCleared = pocDateCleared;
    }

    public String getPocComment() {
        return pocComment;
    }

    public void setPocComment(String pocComment) {
        this.pocComment = pocComment;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
