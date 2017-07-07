package gov.ca.cwds.cals.persistence.model;

import gov.ca.cwds.cals.RecordChangeOperation;
import gov.ca.cwds.data.persistence.PersistentObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

/**
 * @author CWDS TPT-2
 */
@NamedNativeQuery(
    name = "RecordChange.findChangedFacilityRecordsInCWSCMS",
    query =
        "SELECT PlacementHome.IDENTIFIER AS ID, PlacementHome.IBMSNAP_OPERATION AS IBMSNAP_OPERATION"
            + " FROM {h-schema}PLC_HM_T PlacementHome"
            + " WHERE PlacementHome.LICENSE_NO IS NULL AND PlacementHome.IBMSNAP_LOGMARKER > :dateAfter"
            + " UNION"
            + " SELECT DISTINCT PlacementHome.IDENTIFIER AS ID, 'U' AS IBMSNAP_OPERATION"
            + " FROM {h-schema}CLIENT_T Client"
            + " INNER JOIN {h-schema}PLC_EPST PlacementEpisode ON Client.IDENTIFIER=PlacementEpisode.FKCLIENT_T"
            + " INNER JOIN {h-schema}O_HM_PLT OutOfHomePlacement ON PlacementEpisode.THIRD_ID=OutOfHomePlacement.FKPLC_EPS0"
            + " INNER JOIN {h-schema}PLC_HM_T PlacementHome ON OutOfHomePlacement.FKPLC_HM_T=PlacementHome.IDENTIFIER"
            + " WHERE PlacementHome.LICENSE_NO IS NULL AND ("
            + " Client.IBMSNAP_LOGMARKER > :dateAfter OR"
            + " PlacementEpisode.IBMSNAP_LOGMARKER > :dateAfter OR"
            + " OutOfHomePlacement.IBMSNAP_LOGMARKER > :dateAfter)",
    resultClass = RecordChange.class,
    readOnly = true
)
@NamedNativeQuery(
    name = "RecordChange.findChangedFacilityRecordsInLIS",
    query = "SELECT f.fac_nbr as ID, 'U' AS IBMSNAP_OPERATION"
        + " FROM {h-schema}lis_fac_file f WHERE f.fac_last_upd_date > :dateAfter",
    resultClass = RecordChange.class,
    readOnly = true
)
@Entity
public class RecordChange implements PersistentObject {

  @Id
  @Column(name = "ID")
  private String id;

  @Enumerated(EnumType.STRING)
  @Column(name = "IBMSNAP_OPERATION", updatable = false)
  private RecordChangeOperation recordChangeOperation;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RecordChangeOperation getRecordChangeOperation() {
    return recordChangeOperation;
  }

  public void setRecordChangeOperation(RecordChangeOperation recordChangeOperation) {
    this.recordChangeOperation = recordChangeOperation;
  }

  @Override
  public Serializable getPrimaryKey() {
    return getId();
  }
}
