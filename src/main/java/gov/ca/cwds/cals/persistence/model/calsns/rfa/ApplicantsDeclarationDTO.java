package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S3437") // Dates should be serialized
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicantsDeclarationDTO extends BaseDTO implements Request, Response {

  private static final long serialVersionUID = 6463110475391563958L;


  @ApiModelProperty(value = "List of applicant's signatures")
  private List<ApplicantSignature> applicantSignatures;

  public List<ApplicantSignature> getApplicantSignatures() {
    return applicantSignatures;
  }

  public void setApplicantSignatures(
      List<ApplicantSignature> applicantSignatures) {
    this.applicantSignatures = applicantSignatures;
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }


  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class ApplicantSignature extends BaseDTO {

    private static final long serialVersionUID = -5249478870281720452L;

    @ApiModelProperty(value = "Applicant Id")
    private Long applicantId;

    @ApiModelProperty(value = "City of signature")
    private String signatureCity;

    @ApiModelProperty(value = "County of signature")
    private CountyType signatureCounty;

    @ApiModelProperty(value = "Date of signature", example = "2015-03-25")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate signatureDate;

    public Long getApplicantId() {
      return applicantId;
    }

    public void setApplicantId(Long applicantId) {
      this.applicantId = applicantId;
    }

    public String getSignatureCity() {
      return signatureCity;
    }

    public void setSignatureCity(String signatureCity) {
      this.signatureCity = signatureCity;
    }

    public CountyType getSignatureCounty() {
      return signatureCounty;
    }

    public void setSignatureCounty(
        CountyType signatureCounty) {
      this.signatureCounty = signatureCounty;
    }

    public LocalDate getSignatureDate() {
      return signatureDate;
    }

    public void setSignatureDate(LocalDate signatureDate) {
      this.signatureDate = signatureDate;
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

}
