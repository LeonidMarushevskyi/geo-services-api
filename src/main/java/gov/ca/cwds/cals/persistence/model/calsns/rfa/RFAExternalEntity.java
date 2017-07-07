package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * @author CWDS CALS API Team
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RFAExternalEntity<T extends RFAExternalEntityDTO> extends
    RFABaseEntity {

  public static final String PARAM_FORM_ID = "formId";
  public static final String PARAM_ENTITY_ID = "entityId";

  @Column(name = "application_id")
  private Long formId;

  public Long getFormId() {
    return formId;
  }

  public void setFormId(Long formId) {
    this.formId = formId;
  }

  public abstract T getEntityDTO();

  public abstract void setEntityDTO(T entityDTO);

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RFAExternalEntity base = (RFAExternalEntity) o;
    if (base.getId() == null || getId() == null) {
      return false;
    }
    return Objects.equals(getId(), base.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
