package educative.merge;

import problems.MergeLists;

import java.util.List;

public class MergeSortList {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        LinkedListNode mergedList = null;
        for (LinkedList list : lists) {
            mergedList = mergeTwoLists(mergedList, list.head);
        }
        // Replace this placeholder return statement with your code
        return mergedList;
    }

    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    class LinkedListNode {
        public int data;
        public LinkedListNode next;
        // LinkedListNode() will be used to make a LinkedListNode type object.
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        public LinkedListNode head;
        // LinkedList() will be used to make a LinkedList type object.
        public LinkedList() {
            this.head = null;
        }
        // insert_node_at_head method will insert a LinkedListNode at head
        // of a linked list.
        public void insertNodeAtHead(LinkedListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }
        // create_linked_list method will create the linked list using the
        // given integer array with the help of InsertAthead method.
        public void createLinkedList(List<Integer> lst) {
            for (int i = lst.size() - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst.get(i));
                insertNodeAtHead(newNode);
            }
        }
    }
}
