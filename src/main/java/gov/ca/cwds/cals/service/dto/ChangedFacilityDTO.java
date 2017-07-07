package gov.ca.cwds.cals.service.dto;

import gov.ca.cwds.cals.ChangedDTO;
import gov.ca.cwds.cals.RecordChangeOperation;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * @author CWDS TPT-2
 */
public class ChangedFacilityDTO implements ChangedDTO, Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  private FacilityDTO facilityDTO;

  @NotNull
  private RecordChangeOperation recordChangeOperation;

  public ChangedFacilityDTO(FacilityDTO facilityDTO, RecordChangeOperation recordChangeOperation) {
    this.facilityDTO = facilityDTO;
    this.recordChangeOperation = recordChangeOperation;
  }

  @Override
  public RecordChangeOperation getRecordChangeOperation() {
    return recordChangeOperation;
  }

  @Override
  public FacilityDTO getDTO() {
    return facilityDTO;
  }

  @Override
  public String getId() {
    return facilityDTO.getId();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangedFacilityDTO that = (ChangedFacilityDTO) o;
    return recordChangeOperation == that.recordChangeOperation && Objects
        .equals(facilityDTO, that.facilityDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facilityDTO, recordChangeOperation);
  }
}
