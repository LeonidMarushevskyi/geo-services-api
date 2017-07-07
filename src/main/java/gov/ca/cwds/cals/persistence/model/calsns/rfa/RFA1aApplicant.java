package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant.PARAM_ENTITY_ID;
import static gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant.PARAM_FORM_ID;

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
    name = RFA1aApplicant.NAMED_QUERY_FIND_ALL_BY_FORM,
    query = "FROM RFA1aApplicant a WHERE a.formId = :" + PARAM_FORM_ID
)
@NamedQuery(
    name = RFA1aApplicant.NAMED_QUERY_FIND_BY_FORM_ID_AND_APPLICANT_ID,
    query =
        "FROM RFA1aApplicant a WHERE a.id = :"
            + PARAM_ENTITY_ID
            + " AND a.formId = :"
            + PARAM_FORM_ID
)
@SuppressWarnings("squid:S3437") // Dates should be serialized
@Entity
@Table(name = "rfa_1a_applicant")
public class RFA1aApplicant extends RFAExternalEntity<ApplicantDTO> implements PersistentObject {
  private static final long serialVersionUID = 7581768715451007632L;

  public static final java.lang.String NAMED_QUERY_FIND_ALL_BY_FORM =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant.find.all.forFormId";
  public static final String NAMED_QUERY_FIND_BY_FORM_ID_AND_APPLICANT_ID =
      "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1aApplicant.find.ByFormIdAndApplicantId";

  @Column(name = "applicant")
  @Type(type = "ApplicantJsonType")
  private ApplicantDTO applicant;

  public ApplicantDTO getApplicant() {
    return applicant;
  }

  public void setApplicant(ApplicantDTO applicant) {
    this.applicant = applicant;
  }

  @Override
  public ApplicantDTO getEntityDTO() {
    return getApplicant();
  }

  @Override
  public void setEntityDTO(ApplicantDTO applicant) {
    setApplicant(applicant);
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
