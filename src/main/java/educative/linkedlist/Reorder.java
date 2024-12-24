package educative.linkedlist;

public class Reorder {
    public static LinkedListNode reorderList(LinkedListNode head) {

        // Replace this placeholder return statement with your code
        LinkedListNode slow = head, fast = head, prev = head;
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        LinkedListNode list2 = reverse(slow);
        LinkedListNode list1 = head;
        while (list1 != null && list2 != null) {
            LinkedListNode temp1 = list1.next;
            LinkedListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1 != null ? temp1 : temp2;
            list1 = temp1;
            list2 = temp2;
        }

        return head;
    }

    public static LinkedListNode reverse(LinkedListNode head) {

        // Replace this placeholder return statement with your code
        LinkedListNode prev = null, next = null, current = head;
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
//        LinkedList obj1 = new LinkedList();
//        int[] inputList = {1, 1, 2, 2, 3, -1, 10, 12};
//        obj1.createLinkedList(inputList);
//        System.out.print("1.\tOriginal list: ");
//        PrintList.printListWithForwardArrow(obj1.head);
//        reorderList(obj1.head);
//        System.out.print("\tAfter folding: ");
//        PrintList.printListWithForwardArrow(obj1.head);

        LinkedList obj2 = new LinkedList();
        int[] inputList1 = {10, 20, -22, 21, -12};
        obj2.createLinkedList(inputList1);
        System.out.print("2.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj2.head);
        reorderList(obj2.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj2.head);

        LinkedList obj3 = new LinkedList();
        int[] inputList2 = {1, 1, 1};
        obj3.createLinkedList(inputList2);
        System.out.print("3.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj3.head);
        reorderList(obj3.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj3.head);

        LinkedList obj4 = new LinkedList();
        int[] inputList3 = {-2, -5, -6, 0, -1, -4};
        obj4.createLinkedList(inputList3);
        System.out.print("4.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj4.head);
        reorderList(obj4.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj4.head);

        LinkedList obj5 = new LinkedList();
        int[] inputList4 = {3, 1, 5, 7, -4, -2, -1, -6};
        obj5.createLinkedList(inputList4);
        System.out.print("5.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj5.head);
        reorderList(obj5.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj5.head);
    }
}
