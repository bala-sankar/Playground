package datastructure.linkedlist;

public interface LinkedList<T> {

    class Node<T> {
        public T data;
        public Node<T> nextNode;
    }

    // Get Head Node
    Node<T> getHeadNode();

    Node<T> getTailNode();
    
    // Get size
    int getSize();

    //Inserts an element at the end of the linked list
    void insertAtEnd(T data);

    //Inserts an element at the start/head of the linked list
    void insertAtHead(T data);

    //Deletes an element from the linked list
    void delete(T data);

    // Deletes the first element of the list
    void deleteAtHead();

    // Deletes the last element of the list
    void deleteAtEnd();

    // Searches an element from the linked list
    boolean search(T data);

    // Returns True if the linked list is empty, otherwise returns False
    boolean isEmpty();
}
