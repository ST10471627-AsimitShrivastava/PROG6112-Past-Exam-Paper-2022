
package com.mycompany.hospitalinspections;

public class HospitalInspection {

    private String hospitalName;
    private String hospitalLocation;
    private int yearsSinceInspection;

    // I store the details of one hospital inspection.
    public HospitalInspection(String hospitalName,
            String hospitalLocation, int yearsSinceInspection) {

        this.hospitalName = hospitalName;
        this.hospitalLocation = hospitalLocation;
        this.yearsSinceInspection = yearsSinceInspection;
    }

    // I return the hospital name.
    public String getHospitalName() {
        return hospitalName;
    }

    // I return the hospital location.
    public String getHospitalLocation() {
        return hospitalLocation;
    }

    // I return the years since the last inspection.
    public int getYearsSinceInspection() {
        return yearsSinceInspection;
    }
}
