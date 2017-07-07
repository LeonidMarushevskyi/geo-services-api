package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonPropertyOrder({"id", "is_initial_application", "is_other_type", "other_type_description",
    "application_county"})
public class ApplicationDTO extends BaseDTO implements Request, Response {

  private static final long serialVersionUID = 3691906983136791415L;

  @JsonProperty("is_initial_application")
  @ApiModelProperty(value = "Is Initial Application Id", example = "false")
  private boolean initialApplication;

  @JsonProperty("is_other_type")
  @ApiModelProperty(value = "Is Other Type", example = "false")
  private boolean otherType;

  @ApiModelProperty(value = "Other Type Description", example = "Description")
  private String otherTypeDescription;

  @ApiModelProperty(value = "County Type")
  private CountyType applicationCounty;

  public boolean isInitialApplication() {
    return initialApplication;
  }

  public void setInitialApplication(boolean initialApplication) {
    this.initialApplication = initialApplication;
  }

  public boolean isOtherType() {
    return otherType;
  }

  public void setOtherType(boolean otherType) {
    this.otherType = otherType;
  }

  public String getOtherTypeDescription() {
    return otherTypeDescription;
  }

  public void setOtherTypeDescription(String otherTypeDescription) {
    this.otherTypeDescription = otherTypeDescription;
  }

  public CountyType getApplicationCounty() {
    return applicationCounty;
  }

  public void setApplicationCounty(CountyType applicationCounty) {
    this.applicationCounty = applicationCounty;
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
