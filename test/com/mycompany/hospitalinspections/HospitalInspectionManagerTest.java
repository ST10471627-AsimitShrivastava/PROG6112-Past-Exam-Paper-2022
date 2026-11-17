
package com.mycompany.hospitalinspections;

import org.junit.Test;
import static org.junit.Assert.*;

public class HospitalInspectionManagerTest {

    // I test that the inspection array starts empty.
    @Test
    public void testInitialInspectionCount() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        assertEquals(0, manager.getInspectionCount());
    }

    // I test that one hospital inspection can be saved.
    @Test
    public void testAddInspection() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        HospitalInspection inspection = new HospitalInspection(
                "St Helens", "West Road", 3
        );

        boolean result = manager.addInspection(inspection);

        assertTrue(result);
        assertEquals(1, manager.getInspectionCount());
    }

    // I test that the saved hospital details are correct.
    @Test
    public void testSavedInspectionDetails() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        HospitalInspection inspection = new HospitalInspection(
                "St Helens", "West Road", 3
        );

        manager.addInspection(inspection);

        HospitalInspection savedInspection =
                manager.getInspection(0);

        assertEquals("St Helens",
                savedInspection.getHospitalName());

        assertEquals("West Road",
                savedInspection.getHospitalLocation());

        assertEquals(3,
                savedInspection.getYearsSinceInspection());
    }

    // I test that the array can store five inspections.
    @Test
    public void testMaximumFiveInspections() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        for (int i = 1; i <= 5; i++) {

            HospitalInspection inspection =
                    new HospitalInspection(
                            "Hospital " + i,
                            "Location " + i,
                            2
                    );

            assertTrue(manager.addInspection(inspection));
        }

        assertEquals(5, manager.getInspectionCount());
    }

    // I test that a sixth inspection cannot be saved.
    @Test
    public void testSixthInspectionRejected() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        for (int i = 1; i <= 5; i++) {

            HospitalInspection inspection =
                    new HospitalInspection(
                            "Hospital " + i,
                            "Location " + i,
                            2
                    );

            manager.addInspection(inspection);
        }

        HospitalInspection sixthInspection =
                new HospitalInspection(
                        "Hospital 6", "Location 6", 4
                );

        boolean result =
                manager.addInspection(sixthInspection);

        assertFalse(result);
        assertEquals(5, manager.getInspectionCount());
    }

    // I test that an empty inspection cannot be saved.
    @Test
    public void testNullInspectionRejected() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        boolean result = manager.addInspection(null);

        assertFalse(result);
        assertEquals(0, manager.getInspectionCount());
    }

    // I test that all saved inspections can be returned.
    @Test
    public void testGetAllInspections() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        manager.addInspection(new HospitalInspection(
                "St Helens", "West Road", 3
        ));

        manager.addInspection(new HospitalInspection(
                "City Hospital", "Main Road", 2
        ));

        HospitalInspection[] inspections =
                manager.getAllInspections();

        assertEquals(2, inspections.length);
        assertEquals("St Helens",
                inspections[0].getHospitalName());
        assertEquals("City Hospital",
                inspections[1].getHospitalName());
    }

    // I test that an invalid inspection position is rejected.
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidInspectionPosition() {

        HospitalInspectionManager manager =
                new HospitalInspectionManager();

        manager.getInspection(0);
    }
}
