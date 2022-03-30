package datastructure.linkedlist;

public class LinkedListUtil {
    public static <T> void reverse(SinglyLinkedList<T> list) {
        if(list.isEmpty()) {
            return;
        }
        LinkedList.Node<T> prevNode = null;
        LinkedList.Node<T> currNode = list.getHeadNode();
        while (currNode != null) {
            LinkedList.Node<T> nextNode = currNode.nextNode;
            currNode.nextNode = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        list.setHeadNode(prevNode);
    }

}
