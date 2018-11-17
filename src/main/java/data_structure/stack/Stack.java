package data_structure.stack;

public interface Stack<T> {
    boolean isEmpty();
    void push(T item);
    T pop();
    T peep();
    long size();
}
