package gov.ca.cwds.cals.service.mapper;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author CWDS CALS API Team
 */

@Target({FIELD})
@Retention(RUNTIME)
public @interface RemoveTrailingSpaces {}
