package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.CountyType;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RFA1cFormDTO extends RFAExternalEntityDTO {

  private static final long serialVersionUID = 6758484594804680344L;

  private CountyType applicationCounty;

  @ApiModelProperty(example = "true")
  private boolean childIdentified;

  @ApiModelProperty(example = "true")
  private boolean childInHome;

  private List<IdentifiedChildDTO> identifiedChildren = new ArrayList<>();

  public List<IdentifiedChildDTO> getIdentifiedChildren() {
    return identifiedChildren;
  }

  public void setIdentifiedChildren(
      List<IdentifiedChildDTO> identifiedChildren) {
    this.identifiedChildren = identifiedChildren;
  }

  public boolean isChildIdentified() {
    return childIdentified;
  }

  public void setChildIdentified(boolean childIdentified) {
    this.childIdentified = childIdentified;
  }

  public boolean isChildInHome() {
    return childInHome;
  }

  public void setChildInHome(boolean childInHome) {
    this.childInHome = childInHome;
  }

  public CountyType getApplicationCounty() {
    return applicationCounty;
  }

  public void setApplicationCounty(
      CountyType applicationCounty) {
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
