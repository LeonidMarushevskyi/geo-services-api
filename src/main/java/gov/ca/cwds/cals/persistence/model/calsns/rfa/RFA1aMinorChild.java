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
    name = RFA1aMinorChild.NAMED_QUERY_FIND_ALL_BY_FORM,
    query = "FROM RFA1aMinorChild mc WHERE mc.formId = :" + PARAM_FORM_ID
)
@NamedQuery(
    name = RFA1aMinorChild.NAMED_QUERY_FIND_BY_FORM_ID_AND_CHILD_ID,
    query =
        "FROM RFA1aMinorChild mc WHERE mc.formId = :"
            + PARAM_FORM_ID
            + " AND mc.id = :"
            + PARAM_ENTITY_ID
)
@Entity
@Table(name = "rfa_1a_minor_child")
public class RFA1aMinorChild extends RFAExternalEntity<MinorChildDTO> implements PersistentObject {

  private static final long serialVersionUID = -2264013085327411067L;

  public static final java.lang.String NAMED_QUERY_FIND_ALL_BY_FORM =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild.find.all.forFormId";
  public static final String NAMED_QUERY_FIND_BY_FORM_ID_AND_CHILD_ID =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild.find.by.id";

  @Column(name = "minor_child")
  @Type(type = "MinorChildJsonType")
  private MinorChildDTO minorChild;

  public void setMinorChild(MinorChildDTO minorChild) {
    this.minorChild = minorChild;
  }

  public MinorChildDTO getMinorChild() {
    return minorChild;
  }

  @Override
  public MinorChildDTO getEntityDTO() {
    return getMinorChild();
  }

  @Override
  public void setEntityDTO(MinorChildDTO minorChild) {
    setMinorChild(minorChild);
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
