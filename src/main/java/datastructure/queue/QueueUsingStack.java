package datastructure.queue;

import datastructure.stack.Stack;
import datastructure.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T>{

    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public QueueUsingStack() {
        this.enqueueStack = new StackImpl<>();
    }

    @Override
    public void enqueue(T item) {
        this.enqueueStack.push(item);
    }

    @Override
    public T dequeue() {
        if (!this.dequeueStack.isEmpty()) {
            return this.dequeueStack.pop();
        }
        while(!this.enqueueStack.isEmpty()) {
            this.dequeueStack.push(this.enqueueStack.pop());
        }
        return this.dequeueStack.pop();

    }

    @Override
    public T front() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }
}
