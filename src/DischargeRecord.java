package src;

public class DischargeRecord {
    int patientId;
    long dischargeTime;

    public DischargeRecord(int patientId) {
        this.patientId = patientId;
        this.dischargeTime = System.currentTimeMillis(); //discharge time assigns by system
    }

    @Override
    public String toString() { //returning patientid and discharge time..
        return "Patient ID: " + patientId + ", Discharge Time: " + dischargeTime;
    }
}
