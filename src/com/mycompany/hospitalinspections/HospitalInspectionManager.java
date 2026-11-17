
package com.mycompany.hospitalinspections;

public class HospitalInspectionManager {

    // I create an array that can store five hospital inspections.
    private final HospitalInspection[] inspections =
            new HospitalInspection[5];

    private int inspectionCount = 0;

    // I save an inspection if there is space in the array.
    public boolean addInspection(HospitalInspection inspection) {

        // I check that the inspection is not empty and the array is not full.
        if (inspection == null || inspectionCount >= inspections.length) {
            return false;
        }

        // I save the inspection in the next available position.
        inspections[inspectionCount] = inspection;

        // I increase the number of saved inspections.
        inspectionCount++;

        return true;
    }

    // I return the number of inspections saved.
    public int getInspectionCount() {
        return inspectionCount;
    }

    // I return an inspection from the array.
    public HospitalInspection getInspection(int index) {

        // I check that the array position is valid.
        if (index < 0 || index >= inspectionCount) {
            throw new IndexOutOfBoundsException(
                    "Invalid inspection position.");
        }

        return inspections[index];
    }

    // I return a copy of the saved inspections.
    public HospitalInspection[] getAllInspections() {

        HospitalInspection[] savedInspections =
                new HospitalInspection[inspectionCount];

        // I copy each saved inspection into the new array.
        for (int i = 0; i < inspectionCount; i++) {
            savedInspections[i] = inspections[i];
        }

        return savedInspections;
    }
}
