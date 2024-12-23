package educative.twopointers;

public class ReverseLinkedList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode i = head;
        LinkedListNode j = head;
        for (int k = 0; k < n ; k++) {
            if (j == null) {
                return head;
            }
            j = j.next;
        }
        if (j == null) {
            return i.next;
        }
        while(j.next != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        return head;
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Template for the linked list
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
}
