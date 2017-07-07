package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.StateType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@SuppressWarnings("squid:S3437") // Dates should be serialized
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DisclosureDTO extends BaseDTO {

  private static final long serialVersionUID = 7790426381836182669L;

  @ApiModelProperty(example = "Offence description")
  private String offense;

  @ApiModelProperty(example = "Sacramento")
  private String offenseCity;

  private StateType offenseState;

  @ApiModelProperty(example = "2014-12-26")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate offenseDate;

  @ApiModelProperty(example = "More details about offence")
  private String offenseDetails;

  @ApiModelProperty(example = "Anna Peterson")
  private String signature;

  @ApiModelProperty(example = "2017-07-02")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private LocalDate applicationDate;

  public String getOffense() {
    return offense;
  }

  public void setOffense(String offense) {
    this.offense = offense;
  }

  public String getOffenseCity() {
    return offenseCity;
  }

  public void setOffenseCity(String offenseCity) {
    this.offenseCity = offenseCity;
  }

  public StateType getOffenseState() {
    return offenseState;
  }

  public void setOffenseState(
      StateType offenseState) {
    this.offenseState = offenseState;
  }

  public LocalDate getOffenseDate() {
    return offenseDate;
  }

  public void setOffenseDate(LocalDate offenseDate) {
    this.offenseDate = offenseDate;
  }

  public String getOffenseDetails() {
    return offenseDetails;
  }

  public void setOffenseDetails(String offenseDetails) {
    this.offenseDetails = offenseDetails;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(LocalDate applicationDate) {
    this.applicationDate = applicationDate;
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
