package educative.stacks;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStack() {
        this.enqueueStack = new Stack<Integer>();
        this.dequeueStack = new Stack<Integer>();
    }

    public void push(int item) {
        this.enqueueStack.push(item);
    }

    public int pop() {
        if (!this.dequeueStack.isEmpty()) {
            return this.dequeueStack.pop();
        }
        while(!this.enqueueStack.isEmpty()) {
            this.dequeueStack.push(this.enqueueStack.pop());
        }
        return this.dequeueStack.pop();
    }

    public int peek() {
        if (!this.dequeueStack.isEmpty()) {
            return this.dequeueStack.peek();
        }
        while(!this.enqueueStack.isEmpty()) {
            this.dequeueStack.push(this.enqueueStack.pop());
        }
        return this.dequeueStack.peek();
    }

    public boolean empty() {
        return this.enqueueStack.isEmpty() && this.dequeueStack.isEmpty();
    }
}
