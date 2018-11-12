package data_structure.stack;

public interface Stack<T> {
    public boolean isEmpty();
    public void push(T item);
    public T pop();
    public T peep();
    public long size();
}
