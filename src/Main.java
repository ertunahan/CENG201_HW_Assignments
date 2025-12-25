package src;

public class Main {
    public static void main(String[] args) {

        System.out.println("TASK 1: PATIENT LIST");

        PatientList patientList = new PatientList();
        // i added 5 patients
        patientList.addPatient(new Patient(1, "Tunahan ER", 5, 22));
        patientList.addPatient(new Patient(2, "Ali Ahmet", 8, 33));
        patientList.addPatient(new Patient(3, "Mehmet Yılmaz", 3, 25));
        patientList.addPatient(new Patient(4, "Veli Can", 9, 20));
        patientList.addPatient(new Patient(5, "Ferhat Can", 4, 23));

        System.out.println("\nInitial Patient List:");
        patientList.printList(); //printing patient list..

        // removing a patient with id
        System.out.println("\nRemoving patient with ID = 3");
        patientList.removePatient(3);

        // searching a patient with id
        System.out.println("\nSearching patient with ID = 4");
        Patient foundPatient = patientList.findPatient(4);
        if (foundPatient != null) { //if founded patient isnt empty do this
            System.out.println("Patient Found: " + foundPatient); //printing founded patient
        }
        else {
            System.out.println("Patient not found."); //patient is empty
        }


        System.out.println("\nFinal Patient List:");
        patientList.printList();  // i print final patient list..

        System.out.println("\n\nTASK 2: TREATMENT QUEUE");

        TreatmentQueue treatmentQueue = new TreatmentQueue();

        // add 5 normal treatment requests
        System.out.println("\nAdding 5 Normal Treatment Requests:");
        for (int i = 1; i <= 5; i++) {
            TreatmentRequest request = new TreatmentRequest(i, false);
            treatmentQueue.enqueue(request);
            System.out.println("Added: " + request);

        }

        // i adding 4 priority patients with their severities
        System.out.println("\nAdding 4 Priority Treatment Requests (with severities):");
        TreatmentRequest p1 = new TreatmentRequest(101, true); p1.setSeverity(5); treatmentQueue.enqueue(p1);
        System.out.println("Added: " + p1);
        TreatmentRequest p2 = new TreatmentRequest(102, true); p2.setSeverity(9); treatmentQueue.enqueue(p2);
        System.out.println("Added: " + p2);
        TreatmentRequest p3 = new TreatmentRequest(103, true); p3.setSeverity(7); treatmentQueue.enqueue(p3);
        System.out.println("Added: " + p3);
        TreatmentRequest p4 = new TreatmentRequest(104, true); p4.setSeverity(9); treatmentQueue.enqueue(p4);
        System.out.println("Added: " + p4);


        System.out.println("\nTreatment Queue after adding:");
        treatmentQueue.printQueue(); // printing queue....

        // dequeue 4 requests
        System.out.println("\nProcessing 4 Treatment Requests:");
        for (int i = 0; i < 4; i++) {
            TreatmentRequest processed = treatmentQueue.dequeue();
            if (processed != null) {
                System.out.println("Processed: " + processed); //printing processeds
            }
        }


        System.out.println("\nRemaining Treatment Queue:");
        treatmentQueue.printQueue();  // printing remaining queue

        System.out.println("\n\nTASK 3: DISCHARGE STACK");

        DischargeStack dischargeStack = new DischargeStack();

        // i add 5 discharge records
        System.out.println("\nAdding 5 Discharge Records:");
        for (int i = 1; i <= 5; i++) {
            DischargeRecord record = new DischargeRecord(i);
            dischargeStack.push(record);
            System.out.println("Added: " + record);
        }

        // process 2 records
        System.out.println("\nProcessing 2 Discharge Records:");
        System.out.println("Popped: " + dischargeStack.pop());
        System.out.println("Popped: " + dischargeStack.pop());


        System.out.println("\nRemaining Discharge Stack:");
        dischargeStack.printStack(); // printing remaining stacks

        System.out.println("\n\nTASK 4: INTEGRATED HOSPITAL SYSTEM");

        HospitalSystem system = new HospitalSystem();


        System.out.println("\nAdding 10 Patients:");
        for (int i = 1; i <= 10; i++) { // i add 10 patients here
            Patient p = new Patient(i, "Patient " + i, (i % 10) + 1, 20 + i);
            system.addPatient(p);
            System.out.println("Added: " + p);
        }

        // adding 5 normal treatment requests
        system.addTreatmentRequest(new TreatmentRequest(1, false));
        system.addTreatmentRequest(new TreatmentRequest(2, false));
        system.addTreatmentRequest(new TreatmentRequest(3, false));

        // adding 3 priority treatment requests
        system.addTreatmentRequest(new TreatmentRequest(6, true));
        system.addTreatmentRequest(new TreatmentRequest(7, true));
        system.addTreatmentRequest(new TreatmentRequest(8, true));

        // adding 2 discharge records
        system.addDischarge(9);
        system.addDischarge(10);

        // processing 4 treatment requests
        System.out.println("\nProcessing 4 Treatment Requests:");
        for (int i = 0; i < 4; i++) {
            system.processTreatment();
        }


        System.out.println("\nFINAL SYSTEM STATE:");
        system.printSystemState(); // i printing final system state
    }
}