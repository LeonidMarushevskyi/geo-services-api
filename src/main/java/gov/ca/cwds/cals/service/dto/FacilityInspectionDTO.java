package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cals.service.mapper.RemoveTrailingSpaces;
import gov.ca.cwds.rest.api.Response;
import gov.ca.cwds.rest.validation.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;
import static gov.ca.cwds.rest.api.domain.DomainObject.TIME_FORMAT;

/**
 * @author CWDS CALS API Team
 */
@SuppressWarnings("squid:S3437")   //LocalDateTime is serializable
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FacilityInspectionDTO extends BaseDTO implements Response {

    private static final long serialVersionUID = 3722343378274527122L;

    @RemoveTrailingSpaces
    private String id;

    @RemoveTrailingSpaces
    private String href;

    private LocalDateTime representativeSignatureDate;

    private List<FacilityDeficiencyDTO> deficiencies = new ArrayList<>(4);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT + " " + TIME_FORMAT)
    @Date(format = DATE_FORMAT + " " + TIME_FORMAT)
    public LocalDateTime getRepresentativeSignatureDate() {
        return representativeSignatureDate;
    }

    public void setRepresentativeSignatureDate(LocalDateTime representativeSignatureDate) {
        this.representativeSignatureDate = representativeSignatureDate;
    }

    public List<FacilityDeficiencyDTO> getDeficiencies() {
        return deficiencies;
    }

    public void setDeficiencies(List<FacilityDeficiencyDTO> deficiencies) {
        this.deficiencies = deficiencies;
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
