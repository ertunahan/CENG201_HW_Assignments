package src;

public class DischargeStack {

    private class Node {
        DischargeRecord data;
        Node next;

        Node(DischargeRecord data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public void push(DischargeRecord record) {
        Node newNode = new Node(record);
        newNode.next = top; //newnode.next assigns old node (top)
        top = newNode; //new top node assigns newnode
    }

    public DischargeRecord pop() {
        if (top == null) {  //is stack empty? control
            System.out.println("Stack is empty.");
            return null;  //if it is empty, return null..
        }
        DischargeRecord removed = top.data;  //the data what we want to remove
        top = top.next; //top slid to next
        return removed; //returning removed node..
    }

    public DischargeRecord peek() {
        return (top == null) ? null : top.data;
    }

    public void printStack() {  //printing..
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = top;
        while (current != null) {
            System.out.println(current.data);  //printing discharge record
            current = current.next; //moving to next node
        }
    }
}
