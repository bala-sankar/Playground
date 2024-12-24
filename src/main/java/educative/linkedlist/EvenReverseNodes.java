package educative.linkedlist;

public class EvenReverseNodes {
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {

        // Replace this placeholder return statement with your code
        LinkedListNode prevStart = null, nextEnd = null, current = head, groupStart = null, groupEnd = null;
        int group = 1;
        while(current != null) {
            groupStart = current;
            int nodeCount = 0;
            for(int i = 0; i < group; i++) {
                if(current == null) {
                    break;
                }
                groupEnd = current;
                current = current.next;
                nodeCount++;
            }
            nextEnd = current;
            if (nodeCount % 2 == 0) {
                groupEnd = reverse(prevStart, groupStart, nextEnd);
            }
            prevStart = groupEnd;
            group++;
        }
        return head;
    }

    public static LinkedListNode reverse(LinkedListNode prevStart, LinkedListNode start, LinkedListNode nextEnd) {
        // Replace this placeholder return statement with your code
        LinkedListNode prev = nextEnd, next = null, current = start;
        while (current != nextEnd) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        prevStart.next = prev;
        return start;
    }

    public static void main(String[] args) {
        // Declaring and creating a linked list
        LinkedList obj1 = new LinkedList();
        int[] inputArray1 = {1, 2, 3, 4};
        int[] inputArray2 = {10, 11, 12, 13, 14};
        int[] inputArray3 = {15};
        int[] inputArray4 = {16, 17};

        LinkedList inputLinkList1 = new LinkedList();
        inputLinkList1.createLinkedList(inputArray1);

        LinkedList inputLinkList2 = new LinkedList();
        inputLinkList2.createLinkedList(inputArray2);

        LinkedList inputLinkList3 = new LinkedList();
        inputLinkList3.createLinkedList(inputArray3);

        LinkedList inputLinkList4 = new LinkedList();
        inputLinkList4.createLinkedList(inputArray4);

        LinkedListNode[] listHeads = {inputLinkList1.head, inputLinkList2.head, inputLinkList3.head, inputLinkList4.head};

        for (int i = 0; i < listHeads.length; i++) {
            System.out.println(i + 1 + ".\tIf we reverse the even length groups of the linked list:");
            PrintList.printListWithForwardArrow(listHeads[i]);
            System.out.println("\n\n\twe will get: \t");
            PrintList.printListWithForwardArrow(reverseEvenLengthGroups(listHeads[i]));
            System.out.print("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
