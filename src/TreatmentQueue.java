package src;

public class TreatmentQueue {

    private class Node {
        TreatmentRequest data;
        Node next;

        Node(TreatmentRequest data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // front of queue (next to dequeue)
    private Node tail; // end of queue (where we append)
    private int size;

    public TreatmentQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Enqueue: append, then sort entire list using merge sort to enforce priority ordering
    public void enqueue(TreatmentRequest request) {
        Node node = new Node(request);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        head = mergeSort(head);
        // recompute tail
        Node cur = head;
        tail = null;
        while (cur != null) {
            if (cur.next == null) tail = cur;
            cur = cur.next;
        }
    }

    public TreatmentRequest dequeue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        TreatmentRequest removed = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    // Merge sort implementation for linked list
    private Node mergeSort(Node node) {
        if (node == null || node.next == null) return node;
        Node mid = getMiddle(node);
        Node second = mid.next;
        mid.next = null;
        Node left = mergeSort(node);
        Node right = mergeSort(second);
        return sortedMerge(left, right);
    }

    private Node getMiddle(Node node) {
        if (node == null) return node;
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        if (compareRequests(a.data, b.data) <= 0) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

    // comparator: priority true before false; among priorities higher severity first; among normals earlier arrival first; final tiebreaker arrivalTime
    private int compareRequests(TreatmentRequest r1, TreatmentRequest r2) {
        if (r1.priority != r2.priority) {
            return r1.priority ? -1 : 1;
        }
        if (r1.priority) { // both priority: severity desc
            if (r1.getSeverity() != r2.getSeverity()) {
                return Integer.compare(r2.getSeverity(), r1.getSeverity());
            }
        } else { // both normal: arrival ascending
            if (r1.arrivalTime != r2.arrivalTime) {
                return Long.compare(r1.arrivalTime, r2.arrivalTime);
            }
        }
        return Long.compare(r1.arrivalTime, r2.arrivalTime);
    }
} 