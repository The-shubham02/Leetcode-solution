class MyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {

        Node temp = head;

        for(int i = 0; i < index; i++) {

            if(temp == null) {
                return -1;
            }

            temp = temp.next;
        }

        if(temp == null) {
            return -1;
        }

        return temp.data;
    }

    public void addAtHead(int val) {

        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;
    }

    public void addAtTail(int val) {

        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {

        if(index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;

        for(int i = 0; i < index - 1; i++) {

            if(temp == null) {
                return;
            }

            temp = temp.next;
        }

        if(temp == null) {
            return;
        }

        Node newNode = new Node(val);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int index) {

        if(head == null) {
            return;
        }

        if(index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        for(int i = 0; i < index - 1; i++) {

            if(temp.next == null) {
                return;
            }

            temp = temp.next;
        }

        if(temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }
}