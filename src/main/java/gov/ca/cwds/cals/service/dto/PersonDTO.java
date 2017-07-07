package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

/**
 * A DTO for the Person entity.
 */
@SuppressWarnings("squid:S3437")  //LocalDate is serializable
public class PersonDTO extends BaseDTO {

    private static final long serialVersionUID = 3804635989895101545L;
    
    private Long id;

    @RemoveTrailingSpaces
    @NotNull
    @JsonProperty("first_name")
    private String firstName;

    @RemoveTrailingSpaces
    @NotNull
    @JsonProperty("last_name")
    private String lastName;

    @RemoveTrailingSpaces
    private String gender;

    private Integer age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT, required = false)
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @RemoveTrailingSpaces
    private String ssn;

    private Long ethnicityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Long getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Long personEthnicityId) {
        this.ethnicityId = personEthnicityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonDTO personDTO = (PersonDTO) o;

        return Objects.equals(id, personDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
