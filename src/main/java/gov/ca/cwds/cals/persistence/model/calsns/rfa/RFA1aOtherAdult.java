package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild.PARAM_FORM_ID;
import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntity.PARAM_ENTITY_ID;

import gov.ca.cwds.data.persistence.PersistentObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

/**
 * @author CWDS CALS API Team
 */
@NamedQuery(
    name = RFA1aOtherAdult.NAMED_QUERY_FIND_ALL_BY_FORM,
    query = "FROM RFA1aOtherAdult mc WHERE mc.formId = :" + PARAM_FORM_ID
)
@NamedQuery(
    name = RFA1aOtherAdult.NAMED_QUERY_FIND_BY_FORM_ID_AND_CHILD_ID,
    query =
        "FROM RFA1aOtherAdult mc WHERE mc.formId = :"
            + PARAM_FORM_ID
            + " AND mc.id = :"
            + PARAM_ENTITY_ID
)
@Entity
@Table(name = "rfa_1a_other_adult")
public class RFA1aOtherAdult extends RFAExternalEntity<OtherAdultDTO> implements PersistentObject {

  private static final long serialVersionUID = -972723567173544641L;

  public static final String NAMED_QUERY_FIND_ALL_BY_FORM =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aOtherAdult.find.all.forFormId";
  public static final String NAMED_QUERY_FIND_BY_FORM_ID_AND_CHILD_ID =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aOtherAdult.find.by.id";


  @Column(name = "other_adult")
  @Type(type = "OtherAdultJsonType")
  private OtherAdultDTO otherAdult;

  public void setOtherAdult(OtherAdultDTO otherAdult) {
    this.otherAdult = otherAdult;
  }

  public OtherAdultDTO getOtherAdult() {
    return otherAdult;
  }

  @Override
  public OtherAdultDTO getEntityDTO() {
    return getOtherAdult();
  }

  @Override
  public void setEntityDTO(OtherAdultDTO otherAdult) {
    setOtherAdult(otherAdult);
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
