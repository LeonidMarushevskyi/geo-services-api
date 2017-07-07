package gov.ca.cwds.cals.service.dto;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;
import static org.glassfish.jersey.linking.InjectLink.Style.RELATIVE_PATH;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.Constants;
import gov.ca.cwds.cals.Identifiable;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.api.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.glassfish.jersey.linking.InjectLink;

/**
 * {@link DomainObject} representing a facility.
 *
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class FacilityDTO extends BaseDTO implements Request, Response, Identifiable<String> {

  private static final long serialVersionUID = 2L;

  @JsonProperty("href")
  @InjectLink(value = Constants.API.FACILITIES + "/${instance.id}", style = RELATIVE_PATH)
  @ApiModelProperty(required = true, readOnly = false, value = "Link to current resource", example =
      Constants.API.FACILITIES + "/193600010")
  private URI href;

  @RemoveTrailingSpaces
  @JsonProperty("id")
  @NotNull
  @ApiModelProperty(required = true, readOnly = false, value = "Facility ID", example = "193600010")
  private String id;

  @JsonProperty("type")
  @NotNull
  @ApiModelProperty(required = true, readOnly = false, value = "Facility Type")
  private FacilityTypeDTO type;

  @RemoveTrailingSpaces
  @JsonProperty("name")
  @NotNull
  @Size(max = 50)
  @ApiModelProperty(required = true, readOnly = false, value = "Facility Name", example = "LITTLE ROADRUNNERS INFANT CARE")
  private String name;

  @RemoveTrailingSpaces
  @JsonProperty("licensee_name")
  @NotNull
  @Size(max = 50)
  @ApiModelProperty(required = false, readOnly = false, value = "Licensee Name", example = "BROWN, KIMBERLY")
  private String licenseeName;

  @RemoveTrailingSpaces
  @JsonProperty("license_type")
  @ApiModelProperty(required = false, readOnly = false, value = "Licensee Type", example = "A")
  private String licenseeType;

  @JsonProperty("assigned_worker")
  @ApiModelProperty(required = false, readOnly = false, value = "Assigned Worker")
  private DictionaryDTO assignedWorker;

  @JsonProperty("district_office")
  @ApiModelProperty(required = false, readOnly = false, value = "District Office", example = "MISSION VALLEY")
  private DistrictOfficeDTO districtOffice;

  @RemoveTrailingSpaces
  @JsonProperty("license_number")
  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "License Number", example = "193600161")
  private String licenseNumber;

  @JsonProperty("status")
  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "Facility Status")
  private DictionaryDTO status;

  @JsonProperty("capacity")
  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "Capacity", example = "10")
  private Integer capacity;

  @JsonProperty("license_effective_date")
  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
  @ApiModelProperty(required = false, readOnly = false, value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate licenseEffectiveDate;

  @JsonProperty("original_application_recieved_date")
  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
  @ApiModelProperty(required = false, readOnly = false, value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate originalApplicationRecievedDate;

  @JsonProperty("last_visit_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
  @ApiModelProperty(required = false, readOnly = false, value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate lastVisitDate;

  @JsonProperty("last_deferred_visit_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
  @ApiModelProperty(required = false, readOnly = false, value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate lastDeferredVisitDate;

  @RemoveTrailingSpaces
  @JsonProperty("email_address")
  @Size(max = 50)
  @ApiModelProperty(required = false, readOnly = false, value = "Email Address", example = "name@mail.com")
  private String emailAddress;

  @JsonProperty("last_visit_reason")
  @ApiModelProperty(required = false, readOnly = false, value = "Last Visit Reason")
  private DictionaryDTO lastVisitReason;

  @JsonProperty("last_deferred_visit_reason")
  @ApiModelProperty(required = false, readOnly = false, value = "Last Deferred Visit Reason")
  private DictionaryDTO lastDeferredVisitReason;

  @JsonProperty("county")
  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "County")
  private CountyDTO county;

  @JsonProperty("complains")
  @NotNull
  @ApiModelProperty(required = true, readOnly = true, value = "Complains hyperlink", example =
      Constants.API.FACILITIES + "/193600010/" + Constants.API.COMPLAINTS)
  private HyperlinkDTO complains;

  @JsonProperty("inspections")
  @NotNull
  @ApiModelProperty(required = true, readOnly = true, value = "Inspections hyperlink", example =
      Constants.API.FACILITIES + "/193600010/" + Constants.API.INSPECTIONS)
  private HyperlinkDTO inspections;

  @JsonProperty("phones")
  @ApiModelProperty(required = true, readOnly = true, value = "Facility Phones")
  private ArrayList<PhoneDTO> phone;

  @JsonProperty("addresses")
  @ApiModelProperty(required = true, readOnly = true, value = "Facility Addresses")
  private ArrayList<FacilityAddressDTO> address;

  @JsonProperty("visits")
  @ApiModelProperty(required = true, readOnly = true, value = "Facility Visits")
  private List<FacilityVisitDTO> visits;

  @JsonProperty("annual_visit_year")
  @ApiModelProperty(required = true, readOnly = true, value = "18")
  private Integer annualVisitYear;

  @JsonProperty("prelicensing_visit_date")
  @ApiModelProperty(required = true, readOnly = true, value = "2000-01-01")
  private LocalDate prelicensingVisitDate;

  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FacilityTypeDTO getType() {
    return type;
  }

  public void setType(FacilityTypeDTO type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLicenseeName() {
    return licenseeName;
  }

  public void setLicenseeName(String licenseeName) {
    this.licenseeName = licenseeName;
  }

  public String getLicenseeType() {
    return licenseeType;
  }

  public void setLicenseeType(String licenseeType) {
    this.licenseeType = licenseeType;
  }

  public DictionaryDTO getAssignedWorker() {
    return assignedWorker;
  }

  public void setAssignedWorker(DictionaryDTO assignedWorker) {
    this.assignedWorker = assignedWorker;
  }

  public DistrictOfficeDTO getDistrictOffice() {
    return districtOffice;
  }

  public void setDistrictOffice(DistrictOfficeDTO districtOffice) {
    this.districtOffice = districtOffice;
  }

  public DictionaryDTO getStatus() {
    return status;
  }

  public void setStatus(DictionaryDTO status) {
    this.status = status;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public LocalDate getLicenseEffectiveDate() {
    return licenseEffectiveDate;
  }

  public void setLicenseEffectiveDate(LocalDate licenseEffectiveDate) {
    this.licenseEffectiveDate = licenseEffectiveDate;
  }

  public LocalDate getOriginalApplicationRecievedDate() {
    return originalApplicationRecievedDate;
  }

  public void setOriginalApplicationRecievedDate(LocalDate originalApplicationRecievedDate) {
    this.originalApplicationRecievedDate = originalApplicationRecievedDate;
  }

  public LocalDate getLastVisitDate() {
    return lastVisitDate;
  }

  public void setLastVisitDate(LocalDate lastVisitDate) {
    this.lastVisitDate = lastVisitDate;
  }

  public LocalDate getLastDeferredVisitDate() {
    return lastDeferredVisitDate;
  }

  public void setLastDeferredVisitDate(LocalDate lastDeferredVisitDate) {
    this.lastDeferredVisitDate = lastDeferredVisitDate;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public DictionaryDTO getLastVisitReason() {
    return lastVisitReason;
  }

  public void setLastVisitReason(DictionaryDTO lastVisitReason) {
    this.lastVisitReason = lastVisitReason;
  }

  public DictionaryDTO getLastDeferredVisitReason() {
    return lastDeferredVisitReason;
  }

  public void setLastDeferredVisitReason(DictionaryDTO lastDeferredVisitReason) {
    this.lastDeferredVisitReason = lastDeferredVisitReason;
  }

  public CountyDTO getCounty() {
    return county;
  }

  public void setCounty(CountyDTO county) {
    this.county = county;
  }

  public HyperlinkDTO getComplains() {
    return complains;
  }

  public void setComplains(HyperlinkDTO complains) {
    this.complains = complains;
  }

  public HyperlinkDTO getInspections() {
    return inspections;
  }

  public void setInspections(HyperlinkDTO inspections) {
    this.inspections = inspections;
  }

  public List<FacilityAddressDTO> getAddress() {
    return address;
  }

  public void setAddress(List<FacilityAddressDTO> address) {
    this.address = new ArrayList<>(address);
  }

  public List<FacilityVisitDTO> getVisits() {
    return visits;
  }

  public void setVisits(List<FacilityVisitDTO> visits) {
    this.visits = visits;
  }

  public Integer getAnnualVisitYear() {
    return annualVisitYear;
  }

  public void setAnnualVisitYear(Integer annualVisitYear) {
    this.annualVisitYear = annualVisitYear;
  }

  public LocalDate getPrelicensingVisitDate() {
    return prelicensingVisitDate;
  }

  public void setPrelicensingVisitDate(LocalDate prelicensingVisitDate) {
    this.prelicensingVisitDate = prelicensingVisitDate;
  }

  public List<PhoneDTO> getPhone() {
    return phone;
  }

  public void setPhone(List<PhoneDTO> phone) {
    this.phone = new ArrayList<>(phone);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FacilityDTO facilityDTO = (FacilityDTO) o;

    return Objects.equals(id, facilityDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
