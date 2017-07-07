package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

/**
 * A DTO for the FacilityChild entity.
 */
@SuppressWarnings("squid:S3437") //LocalDate is serializable
public class FacilityChildDTO extends BaseDTO implements Request, Response {

    private static final long serialVersionUID = -4616515477832458787L;
    
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
    @JsonProperty("date_of_placement")
    private LocalDate dateOfPlacement;

    @JsonProperty("assigned_worker")
    private PersonDTO assignedWorker;

    @RemoveTrailingSpaces
    @NotNull
    @JsonProperty("county_of_origin")
    private String countyOfOrigin;

    private Long facilityId;

    private PersonDTO person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getDateOfPlacement() {
        return dateOfPlacement;
    }

    public void setDateOfPlacement(LocalDate dateOfPlacement) {
        this.dateOfPlacement = dateOfPlacement;
    }

    public PersonDTO getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(PersonDTO assignedWorker) {
        this.assignedWorker = assignedWorker;
    }

    public String getCountyOfOrigin() {
        return countyOfOrigin;
    }

    public void setCountyOfOrigin(String countyOfOrigin) {
        this.countyOfOrigin = countyOfOrigin;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FacilityChildDTO facilityChildDTO = (FacilityChildDTO) o;

        return Objects.equals(id, facilityChildDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
