package src;

import java.util.HashMap;

public class HospitalSystem {
    PatientList patient_List = new PatientList();
    TreatmentQueue treatmentQueue = new TreatmentQueue();
    DischargeStack dischargeStack = new DischargeStack();
    HashMap<Integer, Patient> patientMap = new HashMap<>(); 


    // Adds a patient to all the places
    public void addPatient(Patient newPatient) {
        patient_List.addPatient(newPatient);
        patientMap.put(newPatient.id, newPatient);
    }


    // Adds a treatment request into the priority queue
    public void addTreatmentRequest(TreatmentRequest request) {
        // set severity from patientMap if available so priority sorting can use it
        Patient p = patientMap.get(request.patientId);
        if (p != null) {
            request.setSeverity(p.severity);
        }
        treatmentQueue.enqueue(request);
    }


    // Manually mark a patient for discharge
    public void addDischarge(int patientId) {
        dischargeStack.push(new DischargeRecord(patientId));
    }


    // Process the next treatment in line
    public void processTreatment() {
        TreatmentRequest nextUp = treatmentQueue.dequeue();
        if (nextUp == null) {
            return;
        }
        dischargeStack.push(new DischargeRecord(nextUp.patientId));
    }


    // output for checking system state
    public void printSystemState() {
        System.out.println("\nPatients:\n");
        patient_List.printList();
        System.out.println("\nTreatment Queue:\n");
        treatmentQueue.printQueue();
        System.out.println("\nDischarge Stack:\n");
        dischargeStack.printStack();
    }
}