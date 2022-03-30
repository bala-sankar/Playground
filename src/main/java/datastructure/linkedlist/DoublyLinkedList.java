package datastructure.linkedlist;

public class DoublyLinkedList<T> implements LinkedList<T>{
    class Node<T> extends LinkedList.Node<T> {
        public Node<T> nextNode;
        public Node<T> prevNode;
    }
    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    public DoublyLinkedList() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    @Override
    public Node<T> getHeadNode() {
        return this.headNode;
    }

    public void setHeadNode(Node<T> node) {
        this.headNode = node;
    }

    @Override
    public Node<T> getTailNode() {
        return this.tailNode;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void insertAtEnd(T data) {
        if (isEmpty()) { //if list is empty then insert at head
            insertAtHead(data);
            return;
        }
        Node<T> node = new Node<>();
        node.data = data;
        node.nextNode = null;
        node.prevNode = this.tailNode;
        this.tailNode.nextNode = node;
        this.tailNode = node;
        size++;
    }

    @Override
    public void insertAtHead(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.nextNode = this.headNode;
        node.prevNode = null;
        if (this.headNode!=null) {
            this.headNode.prevNode = node;
        } else {
            this.tailNode = node;
        }
        this.headNode = node;
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
        if (tailNode.data.equals(data)) {
            deleteAtEnd();
            return;
        }
        Node<T> prevNode = headNode;
        Node<T> curNode = headNode.nextNode;
        while (curNode != null) {
            if (curNode.data.equals(data)) {
                prevNode.nextNode = curNode.nextNode;
                if (curNode.nextNode!=null) {
                    curNode.nextNode.prevNode = prevNode;
                }
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
        this.headNode = this.headNode.nextNode;
        if (this.headNode == null) {
            tailNode = null;
        } else {
            headNode.prevNode = null;
        }
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if(isEmpty()) {
            return;
        }
        tailNode = tailNode.prevNode;
        if (this.tailNode == null) {
            headNode = null;
        } else {
            tailNode.nextNode = null;
        }
        size--;
    }

    @Override
    public boolean search(T data) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (headNode == null);
    }
}
