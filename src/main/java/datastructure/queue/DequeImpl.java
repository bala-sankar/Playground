package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class DequeImpl<T> implements Deque<T> {
    private List<T> items;

    public DequeImpl() {
        items = new ArrayList<T>();
    }

    public void addFront(T item) {
        items.add(0, item);
    }

    public void addRear(T item) {
        items.add(item);
    }

    public T removeFront() {
        return items.remove(0);
    }

    public T removeRear() {
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
