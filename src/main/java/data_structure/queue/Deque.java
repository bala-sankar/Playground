package data_structure.queue;

public interface Deque<T> {
    void addFront(T item);
    void addRear(T item);
    T removeFront();
    T removeRear();
    boolean isEmpty();
    int size();
}
