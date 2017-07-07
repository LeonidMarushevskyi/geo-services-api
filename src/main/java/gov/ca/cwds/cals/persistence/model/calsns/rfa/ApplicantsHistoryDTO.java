package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author CWDS CALS API Team
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicantsHistoryDTO extends BaseDTO implements Request, Response {

  @ApiModelProperty("List of Former Spouses and Domestic Partners")
  private List<FormerSpouseDTO> formerSpouses = new ArrayList<>();

  @ApiModelProperty("List of Adult Children")
  private List<AdultChildDTO> adultChildren = new ArrayList<>();

  public List<FormerSpouseDTO> getFormerSpouses() {
    return formerSpouses;
  }

  public void setFormerSpouses(
      List<FormerSpouseDTO> formerSpouses) {
    this.formerSpouses = formerSpouses;
  }

  public List<AdultChildDTO> getAdultChildren() {
    return adultChildren;
  }

  public void setAdultChildren(
      List<AdultChildDTO> adultChildren) {
    this.adultChildren = adultChildren;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicantsHistoryDTO)) {
      return false;
    }
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
