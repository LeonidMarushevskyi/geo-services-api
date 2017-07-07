package gov.ca.cwds.cals.service.mapper;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @author CWDS CALS API Team
 */

@Mapper
public class TrailingSpacesRemovalPostMappingProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(TrailingSpacesRemovalPostMappingProcessor.class);

    private static final String WARN_MESSAGE = "Do not apply RemoveTrailingSpaces annotation for non-string field";
    private static final String ERROR_MESSAGE = "Can't remove trailing spaces";

    @AfterMapping
    protected void apply(@MappingTarget Object object) {
        if (object == null || isCollection(object.getClass())) {
            return;
        }

        try {
            doRemoveTrailingSpaces(object);
            List<Field> allFieldsList = FieldUtils.getAllFieldsList(object.getClass());

            for (Field field : allFieldsList) {
                applyForField(object, field);
            }

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(ERROR_MESSAGE, e);
        }
    }

    private void applyForField(Object object, Field field)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (!isSimpleValueType(field.getType()) && !field.getName().startsWith("$")) {
            if (isCollection(field.getType())) {
                applyForCollection(object, field);
            } else {
                apply(PropertyUtils.getProperty(object, field.getName()));
            }
        }
    }

    private boolean isSimpleValueType(Class<?> clazz) {
        return (ClassUtils.isPrimitiveOrWrapper(clazz) ||
                String.class.isAssignableFrom(clazz) ||
                LocalDate.class.isAssignableFrom(clazz) ||
                LocalDateTime.class.isAssignableFrom(clazz)
        );
    }

    private boolean isCollection(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings("unchecked")
    private void applyForCollection(Object object, Field field)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
       Collection collection = (Collection) PropertyUtils.getProperty(object, field.getName());
       if (collection != null) {
           collection.forEach(this::apply);
        }
    }

    private static void doRemoveTrailingSpaces(Object object)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for (Field field : FieldUtils.getFieldsWithAnnotation(object.getClass(), RemoveTrailingSpaces.class)) {
            if (field.getType().isAssignableFrom(String.class)) {
                PropertyUtils.setProperty(object, field.getName(),
                        StringUtils.trim((String) PropertyUtils.getProperty(object, field.getName())));
            } else {
                LOG.warn(WARN_MESSAGE);
            }
        }
    }

}
