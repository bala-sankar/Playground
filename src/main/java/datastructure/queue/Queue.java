package datastructure.queue;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T front();
    boolean isEmpty();
    long size();
}
