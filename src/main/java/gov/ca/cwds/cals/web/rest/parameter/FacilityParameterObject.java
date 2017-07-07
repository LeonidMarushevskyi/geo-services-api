package gov.ca.cwds.cals.web.rest.parameter;

import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */
public class FacilityParameterObject implements Serializable {
    public static final long serialVersionUID = 42L;

    private Boolean expanded = Boolean.FALSE;
    private String facilityId;
    private Integer licenseNumber;
    private String unitOfWork;

    public FacilityParameterObject(String unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public FacilityParameterObject(String facilityId, String unitOfWork) {
        this.facilityId = facilityId;
        this.unitOfWork = unitOfWork;
    }

    public FacilityParameterObject(Integer licenseNumber, String unitOfWork) {
        this.licenseNumber = licenseNumber;
        this.unitOfWork = unitOfWork;
    }

    public Boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public String getUnitOfWork() {
        return unitOfWork;
    }
}
