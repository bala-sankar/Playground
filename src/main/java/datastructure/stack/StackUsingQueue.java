package datastructure.stack;

import datastructure.queue.Queue;
import datastructure.queue.QueueImpl;

public class StackUsingQueue<T> implements Stack<T> {

    private Queue<T> pushQueue;
    private Queue<T> popQueue;

    public StackUsingQueue() {
        this.pushQueue = new QueueImpl<>();
        this.popQueue = new QueueImpl<>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(T item) {
        this.pushQueue.enqueue(item);
    }

    @Override
    public T pop() {
        T item = null;
        while(!this.pushQueue.isEmpty()) {
            item = this.pushQueue.dequeue();
            if (!this.pushQueue.isEmpty()) {
                this.popQueue.enqueue(item);
            }
        }
        this.pushQueue = this.popQueue;
        this.popQueue = new QueueImpl<>();
        return item;
    }

    @Override
    public T peep() {
        return null;
    }

    @Override
    public long size() {
        return 0;
    }
}
