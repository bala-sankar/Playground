package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class StackImpl<T> implements Stack<T> {
    private List<T> items;

    public StackImpl() {
        items = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        return items.remove(items.size() - 1);
    }

        public T peep() {
        return items.get(items.size() - 1);
    }

    public long size() {
        return items.size();
    }
}
