package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Address entity.
 */

public class AddressDTO extends BaseDTO {

    private static final long serialVersionUID = 1921798483033435568L;
    
    private Long id;

    @RemoveTrailingSpaces
    @JsonProperty("street_address")
    @NotNull
    @Size(max = 100)
    @ApiModelProperty(required = true, readOnly = true, value = "Street Address", example = "609 WOODSMAN DR")
    private String streetAddress;

    @RemoveTrailingSpaces
    @JsonProperty("city")
    @NotNull
    @Size(max = 50)
    @ApiModelProperty(required = true, readOnly = true, value = "City", example = "BAKERSFIELD")
    private String city;

    @RemoveTrailingSpaces
    @JsonProperty("state")
    @NotNull
    @Size(min = 2, max = 2)
    @ApiModelProperty(required = true, readOnly = true, value = "State", example = "CA")
    private String state;

    @RemoveTrailingSpaces
    @JsonProperty("zip_code")
    @NotNull
    @Size(min = 5, max = 5)
    @ApiModelProperty(required = true, readOnly = true, value = "Zipcode", example = "93306")
    private String zipCode;

    @RemoveTrailingSpaces
    @JsonProperty("zip_suffix_code")
    @Size(min = 4, max = 4)
    private String zipSuffixCode;

    private BigDecimal longitude;

    private BigDecimal lattitude;

    private Boolean deliverable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getZipSuffixCode() {
        return zipSuffixCode;
    }

    public void setZipSuffixCode(String zipSuffixCode) {
        this.zipSuffixCode = zipSuffixCode;
    }
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    public BigDecimal getLattitude() {
        return lattitude;
    }

    public void setLattitude(BigDecimal lattitude) {
        this.lattitude = lattitude;
    }
    public Boolean getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Boolean deliverable) {
        this.deliverable = deliverable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AddressDTO addressDTO = (AddressDTO) o;

        return Objects.equals(id, addressDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
