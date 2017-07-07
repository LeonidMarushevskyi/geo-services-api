package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.validation.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;
import static gov.ca.cwds.rest.api.domain.DomainObject.TIME_FORMAT;

/**
 * @author CWDS CALS API Team
 */

@SuppressWarnings("squid:S3437")  //LocalDateTime is serializable
public class ComplaintDTO extends BaseDTO implements Response {

    private static final long serialVersionUID = 5198076888434433809L;

    @JsonProperty("id")
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
    @JsonProperty("complaint_date")
    private LocalDate complaintDate;

    @RemoveTrailingSpaces
    @JsonProperty("assigned_worker")
    private String assignedWorker;

    @RemoveTrailingSpaces
    @JsonProperty("control_number")
    private String controlNumber;

    @RemoveTrailingSpaces
    @JsonProperty("priority_level")
    private String priorityLevel;

    @RemoveTrailingSpaces
    @JsonProperty("status")
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
    @JsonProperty("approval_date")
    @Date(format = DATE_FORMAT + " " + TIME_FORMAT, required = false)
    private LocalDateTime approvalDate;

    @JsonProperty("pre_investigation_comments")
    private String preInvestigationComments;

    @JsonProperty("post_investigation_comments")
    private String postInvestigationComments;

    @JsonProperty("contact_summary")
    private String contactSummary;

    @JsonProperty("followup_comments")
    private String followupComments;

    @JsonProperty("allegations")
    private List<AllegationDTO> allegations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(String assignedWorker) {
        this.assignedWorker = assignedWorker;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }


    public String getPreInvestigationComments() {
        return preInvestigationComments;
    }

    public void setPreInvestigationComments(String preInvestigationComments) {
        this.preInvestigationComments = preInvestigationComments;
    }

    public String getPostInvestigationComments() {
        return postInvestigationComments;
    }

    public void setPostInvestigationComments(String postInvestigationComments) {
        this.postInvestigationComments = postInvestigationComments;
    }

    public String getContactSummary() {
        return contactSummary;
    }

    public void setContactSummary(String contactSummary) {
        this.contactSummary = contactSummary;
    }

    public String getFollowupComments() {
        return followupComments;
    }

    public void setFollowupComments(String followupComments) {
        this.followupComments = followupComments;
    }

    public List<AllegationDTO> getAllegations() {
        return allegations;
    }

    public void setAllegations(List<AllegationDTO> allegations) {
        this.allegations = allegations;
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
