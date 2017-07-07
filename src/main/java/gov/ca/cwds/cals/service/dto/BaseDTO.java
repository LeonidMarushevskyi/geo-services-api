package gov.ca.cwds.cals.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @author CWDS CALS API Team
 */

@JsonIgnoreProperties({"messages"})
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -2099354387049882669L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
