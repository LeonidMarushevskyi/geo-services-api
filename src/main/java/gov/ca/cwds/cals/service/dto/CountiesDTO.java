package gov.ca.cwds.cals.service.dto;

import gov.ca.cwds.rest.api.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */
public class CountiesDTO extends BaseDTO implements Response {

    private static final long serialVersionUID = 6849073315397309087L;

    private List<CountyDTO> counties = new ArrayList<>();

    public List<CountyDTO> getCounties() {
        return counties;
    }

    public void setCounties(List<CountyDTO> counties) {
        this.counties = new ArrayList<>(counties);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof CountiesDTO)) {
            return false;
        }

        CountiesDTO that = (CountiesDTO) o;

        return counties.equals(that.counties);
    }

    @Override
    public int hashCode() {
        return counties.hashCode();
    }
}
