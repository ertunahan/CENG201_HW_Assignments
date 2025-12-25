package src;

public class PatientList {

    private class Node {
        Patient patient_Data;
        Node next;             // pointer to the next node

        Node(Patient p) {
            this.patient_Data = p;
            this.next = null;
        }
    }

    private Node head;   // start of the list

    public void addPatient(Patient p) {
        Node nodeToAdd = new Node(p);

        // If the list is empty, this becomes the first node
        if (head == null) {
            head = nodeToAdd;
            return;
        }

        // Otherwise, walk to the end of the list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // attach new node at the end
        temp.next = nodeToAdd;
    }

    // Removes a patient by id
    public void removePatient(int id) {
        if (head == null) {
            System.out.println("Patient list is empty");
            return;
        }

        // First node matches
        if (head.patient_Data.id == id) {
            head = head.next;
            System.out.println(id + ". id is deleted");
            return;
        }

        Node current = head;

        // Keep going until we either hit the end or find the id
        while (current.next != null && current.next.patient_Data.id != id) {
            current = current.next;
        }

        // If we reached the end, nothing was found
        if (current.next == null) {
            System.out.println("Patient not found");
        } else {
            current.next = current.next.next;
            System.out.println(id + ". id is deleted");
        }
    }

    // Finds and returns a patient by id
    public Patient findPatient(int id) {
        Node runner = head;

        while (runner != null) {
            if (runner.patient_Data.id == id) {
                return runner.patient_Data;
            }
            runner = runner.next;
        }

        return null;
    }

    // Prints all patients in the list
    public void printList() {
        if (head == null) {
            System.out.println("Patient list is empty");
            return;
        }

        Node current = head;

        // Printing patients data
        while (current != null) {
            System.out.println(current.patient_Data);
            current = current.next;
        }
    }
}