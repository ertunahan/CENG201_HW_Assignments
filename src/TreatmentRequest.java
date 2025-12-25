package src;

public class TreatmentRequest {
    int patientId;
    long arrivalTime;
    boolean priority;
    int severity; // 1-10, 0 if unknown

    public TreatmentRequest(int patientId, boolean priority) { //id and priority comes from outside
        //but arrivaltime assigns by system
        this.patientId = patientId;
        this.priority = priority;
        this.arrivalTime = System.currentTimeMillis(); //milisaniye
        this.severity = 0;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() { //this returns id, priorty, severity and time for printing
        return "Patient ID: " + patientId +
                ", Priority: " + priority +
                ", Severity: " + severity +
                ", Arrival Time: " + arrivalTime;
    }
} 
