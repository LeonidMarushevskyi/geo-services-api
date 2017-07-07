package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.persistence.model.calsns.dictionaries.AgeGroupType;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ChildDesiredDTO extends BaseDTO implements Request, Response {

  private static final long serialVersionUID = -580792892550002723L;

  @ApiModelProperty(value = "Has a child been identified?", example = "false")
  private boolean childIdentified;

  @ApiModelProperty(value = "Is the child currently in your home?", example = "false")
  private boolean childInHome;

  @ApiModelProperty(value = "Preferred Age(s)")
  private List<AgeGroupType> preferredAges = new ArrayList<>();

  @ApiModelProperty(value = "Preferred Sibling(Group Of)")
  private List<AgeGroupType> preferredSiblingGroups = new ArrayList<>();

  public boolean isChildInHome() {
    return childInHome;
  }

  public void setChildInHome(boolean childInHome) {
    this.childInHome = childInHome;
  }

  public boolean isChildIdentified() {
    return childIdentified;
  }

  public void setChildIdentified(boolean childIdentified) {
    this.childIdentified = childIdentified;
  }

  public List<AgeGroupType> getPreferredAges() {
    return preferredAges;
  }

  public void setPreferredAges(
      List<AgeGroupType> preferredAges) {
    this.preferredAges = preferredAges;
  }

  public List<AgeGroupType> getPreferredSiblingGroups() {
    return preferredSiblingGroups;
  }

  public void setPreferredSiblingGroups(
      List<AgeGroupType> preferredSiblingGroups) {
    this.preferredSiblingGroups = preferredSiblingGroups;
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
