package educative.linkedlist;

public class ReverseLinkedList {
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
}
