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
    name = RFA1cForm.NAMED_QUERY_FIND_ALL_BY_FORM,
    query = "FROM RFA1cForm f WHERE f.formId = :" + PARAM_FORM_ID
)
@NamedQuery(
    name = RFA1cForm.NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMC_ID,
    query =
        "FROM RFA1cForm f WHERE f.formId = :"
            + PARAM_FORM_ID
            + " AND f.id = :"
            + PARAM_ENTITY_ID
)
@Entity
@Table(name = "rfa_1c")
public class RFA1cForm extends RFAExternalEntity<RFA1cFormDTO> implements PersistentObject {

  private static final long serialVersionUID = -1359830497679298650L;

  public static final String NAMED_QUERY_FIND_ALL_BY_FORM =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cForm.find.all.forFormId";
  public static final String NAMED_QUERY_FIND_BY_FORMA_ID_AND_FORMC_ID =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cForm.find.by.id";


  @Type(type = "RFA1cFormJsonType")
  private RFA1cFormDTO application;

  @Override
  public RFA1cFormDTO getEntityDTO() {
    return getApplication();
  }

  @Override
  public void setEntityDTO(RFA1cFormDTO formDTO) {
    setApplication(formDTO);
  }

  public RFA1cFormDTO getApplication() {
    return application;
  }

  public void setApplication(RFA1cFormDTO application) {
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
