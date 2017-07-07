package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aMinorChild.PARAM_FORM_ID;
import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFAExternalEntity.PARAM_ENTITY_ID;

import gov.ca.cwds.data.persistence.PersistentObject;
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
    name = RFA1bForm.NAMED_QUERY_FIND_ALL_BY_FORM,
    query = "FROM RFA1bForm f WHERE f.formId = :" + PARAM_FORM_ID
)
@NamedQuery(
    name = RFA1bForm.NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMB_ID,
    query =
        "FROM RFA1bForm f WHERE f.formId = :"
            + PARAM_FORM_ID
            + " AND f.id = :"
            + PARAM_ENTITY_ID
)
@Entity
@Table(name = "rfa_1b")
public class RFA1bForm extends RFAExternalEntity<RFA1bFormDTO> implements PersistentObject {

  private static final long serialVersionUID = 5302432042081531320L;

  public static final String NAMED_QUERY_FIND_ALL_BY_FORM =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm.find.all.forFormId";
  public static final String NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMB_ID =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bForm.find.by.id";

  @Type(type = "RFA1bFormJsonType")
  private RFA1bFormDTO application;

  @Override
  public RFA1bFormDTO getEntityDTO() {
    return getApplication();
  }

  @Override
  public void setEntityDTO(RFA1bFormDTO formDTO) {
    setApplication(formDTO);
  }

  public RFA1bFormDTO getApplication() {
    return application;
  }

  public void setApplication(RFA1bFormDTO application) {
    this.application = application;
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
