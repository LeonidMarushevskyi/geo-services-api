package gov.ca.cwds.cals.persistence.dao.fas;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author CWDS CALS API Team
 */
public class InspectionDaoTest {

    @Test
    public void formatFacilityNumber() throws Exception {
        int facNum = 678;
        String expectedFacNumStr = "000000678";
        assertEquals(expectedFacNumStr, InspectionDao.formatFacilityNumber(facNum));
    }

}