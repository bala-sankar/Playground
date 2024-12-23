package educative.fastandslowpointers;

public class MiddleNode {
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    class LinkedListNode {
        public int data;
        public LinkedListNode next;
        // Constructor will be used to make a LinkedListNode type object
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

