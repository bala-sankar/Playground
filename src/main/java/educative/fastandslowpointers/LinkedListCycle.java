package educative.fastandslowpointers;

public class LinkedListCycle {
    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
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

        // returns the node at the specified position(index) of the linked list
        public LinkedListNode getNode(LinkedListNode head, int pos){
            LinkedListNode ptr = head;
            if (pos != -1){
                int p = 0;

                while (p < pos){
                    ptr = ptr.next;
                    p += 1;
                }

                return ptr;
            }
            return ptr;
        }

        // returns the number of nodes in the linked list
        public int getLength(LinkedListNode head)
        {
            LinkedListNode temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
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


