package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/** @author CWDS CALS API Team */
public class AllegationDTO extends BaseDTO {

  private static final long serialVersionUID = 846994544015933635L;

  @JsonProperty("complaint_code")
  private String complaintCode;

  @JsonProperty("allegation")
  private String allegation;

  @JsonProperty("resolution_code_sub")
  private String resolutionCodeSub;

  @JsonProperty("resolution_code_insub")
  private String resolutionCodeInsub;

  @JsonProperty("resolution_code_unsub")
  private String resolutionCodeUnsub;

  public String getComplaintCode() {
    return complaintCode;
  }

  public void setComplaintCode(String complaintCode) {
    this.complaintCode = complaintCode;
  }

  public String getAllegation() {
    return allegation;
  }

  public void setAllegation(String allegation) {
    this.allegation = allegation;
  }

  public String getResolutionCodeSub() {
    return resolutionCodeSub;
  }

  public void setResolutionCodeSub(String resolutionCodeSub) {
    this.resolutionCodeSub = resolutionCodeSub;
  }

  public String getResolutionCodeInsub() {
    return resolutionCodeInsub;
  }

  public void setResolutionCodeInsub(String resolutionCodeInsub) {
    this.resolutionCodeInsub = resolutionCodeInsub;
  }

  public String getResolutionCodeUnsub() {
    return resolutionCodeUnsub;
  }

  public void setResolutionCodeUnsub(String resolutionCodeUnsub) {
    this.resolutionCodeUnsub = resolutionCodeUnsub;
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
