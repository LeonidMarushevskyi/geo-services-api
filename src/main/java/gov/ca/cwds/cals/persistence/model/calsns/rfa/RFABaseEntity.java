package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;
import static gov.ca.cwds.rest.api.domain.DomainObject.TIME_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ca.cwds.cals.service.dto.BaseDTO;
import gov.ca.cwds.data.persistence.PersistentObject;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S3437") // Dates should be serialized
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RFABaseEntity extends BaseDTO implements PersistentObject {

  private static final long serialVersionUID = -1765556534051721429L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "create_user_id", length = 50, nullable = false)
  private String createUserId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
  @ApiModelProperty(
      required = false,
      readOnly = true,
      value = "yyyy-MM-dd HH:mm:ss",
      example = "2000-01-01 15:11:46"
  )
  @Column(name = "create_datetime")
  private LocalDateTime createDateTime;

  @Column(name = "update_user_id", length = 50, nullable = false)
  private String updateUserId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
  @ApiModelProperty(
      required = true,
      readOnly = false,
      value = "yyyy-MM-dd HH:mm:ss",
      example = "2000-01-01 15:11:46"
  )
  @Column(name = "update_datetime")
  private LocalDateTime updateDateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  public LocalDateTime getCreateDateTime() {
    return createDateTime;
  }

  public void setCreateDateTime(LocalDateTime createDateTime) {
    this.createDateTime = createDateTime;
  }

  public String getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(String updateUserId) {
    this.updateUserId = updateUserId;
  }

  public LocalDateTime getUpdateDateTime() {
    return updateDateTime;
  }

  public void setUpdateDateTime(LocalDateTime updateDateTime) {
    this.updateDateTime = updateDateTime;
  }

  @Override
  @JsonIgnore
  public Serializable getPrimaryKey() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RFABaseEntity base = (RFABaseEntity) o;
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
