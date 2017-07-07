package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author CWDS TPT-2
 */
public class ExpandedFacilityDTO extends FacilityDTO {
  @JsonProperty("children")
  private List<FacilityChildDTO> children = new ArrayList<>();

  public List<FacilityChildDTO> getChildren() {
    return children;
  }

  public void setChildren(
      List<FacilityChildDTO> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ExpandedFacilityDTO that = (ExpandedFacilityDTO) o;
    return Objects.equals(children, that.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), children);
  }
}
