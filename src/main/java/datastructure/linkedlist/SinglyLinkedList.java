package datastructure.linkedlist;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> headNode;
    private int size;

    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    @Override
    public Node<T> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<T> node) {
        this.headNode = node;
    }

    @Override
    public Node<T> getTailNode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return headNode == null;
    }

    @Override
    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node<T> node = new Node<>();
        node.data = data;
        node.nextNode = null;

        Node<T> curNode = headNode;
        while (curNode.nextNode != null) {
            curNode = curNode.nextNode;
        }
        curNode.nextNode = node;
        size++;
    }

    @Override
    public void insertAtHead(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.nextNode = headNode;
        headNode = node;
        size++;
    }

    @Override
    public void delete(T data) {
        if(isEmpty()) {
            return;
        }
        if (headNode.data.equals(data)) {
            deleteAtHead();
            return;
        }
        Node<T> prevNode = headNode;
        Node<T> curNode = headNode.nextNode;
        while (curNode != null) {
            if (curNode.data.equals(data)) {
                prevNode.nextNode = curNode.nextNode;
                size--;
                return;
            }
            prevNode = curNode;
            curNode = curNode.nextNode;
        }
    }

    @Override
    public void deleteAtHead() {
        if(isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if(isEmpty()) {
            return;
        }
        if (headNode.nextNode == null) {
            deleteAtHead();
            return;
        }
        Node<T> prevNode = headNode;
        Node<T> curNode = headNode.nextNode;
        while (curNode.nextNode != null) {
            prevNode = curNode;
            curNode = curNode.nextNode;
        }
        prevNode.nextNode = null;
    }

    @Override
    public boolean search(T data) {
        if(isEmpty()) {
            return false;
        }
        Node<T> curNode = headNode;
        while (curNode.nextNode != null) {
            if (curNode.data.equals(data)) {
                return true;
            }
            curNode = curNode.nextNode;
        }
        return false;
    }

    public int length() {
        Node<T> curNode = this.headNode;
        int count = 0;
        while(curNode != null) {
            count++;
            curNode = curNode.nextNode;
        }
        return count;
    }
}
