package gov.ca.cwds.cals.service.mapper;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TrailingSpacesRemovalPostMappingProcessorTest {

    @Test
    public void trailingSpacesRemovalTest() {
        DeepObject insideCollectionDeepObject = new DeepObject();
        insideCollectionDeepObject.setString("insideCollectionDeepObject    ");
        Set<DeepObject> deepObjectList = Collections.singleton(insideCollectionDeepObject);

        DeepObject deepObject = new DeepObject();
        deepObject.setString("deepObject     ");
        deepObject.setDeepObjectsList(deepObjectList);
        RootObject rootObject = new RootObject();
        rootObject.setDeepObject(deepObject);
        rootObject.setInteger(1);
        rootObject.setNullString(null);
        rootObject.setRootString("rootString     ");
        new TrailingSpacesRemovalPostMappingProcessor().apply(rootObject);
        assertEquals("deepObject", deepObject.getString());
        assertEquals("rootString", rootObject.getRootString());
        assertEquals("insideCollectionDeepObject", insideCollectionDeepObject.getString());
    }

    public static class DeepObject {

        private Set<DeepObject> deepObjectsList;

        @RemoveTrailingSpaces
        private String string;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public Set<DeepObject> getDeepObjectsList() {
            return deepObjectsList;
        }

        public void setDeepObjectsList(Set<DeepObject> deepObjectsList) {
            this.deepObjectsList = deepObjectsList;
        }

    }

    public static class RootObject {

        private DeepObject deepObject;

        //Wrong annotation (not String field type)
        @RemoveTrailingSpaces
        private Integer integer;

        private String nullString;

        @RemoveTrailingSpaces
        private String rootString;

        public DeepObject getDeepObject() {
            return deepObject;
        }

        public void setDeepObject(DeepObject deepObject) {
            this.deepObject = deepObject;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public String getNullString() {
            return nullString;
        }

        public void setNullString(String nullString) {
            this.nullString = nullString;
        }

        public String getRootString() {
            return rootString;
        }

        public void setRootString(String rootString) {
            this.rootString = rootString;
        }

    }

}