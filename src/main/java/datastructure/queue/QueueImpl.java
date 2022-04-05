package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl<T> implements Queue<T> {

    private List<T> items;

    public QueueImpl () {
        items = new ArrayList<T>();
    }

    public void enqueue(T item) {
        items.add(0, item);
    }

    public T dequeue() {
        return items.remove(items.size() - 1);
    }

    @Override
    public T front() {
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public long size() {
        return items.size();
    }
}
