package algorithm;

/**
 * Created by bsankar on 8/10/14.
 */
public class Stack {
    private int top = 0;
    private int[] stack;

    public Stack(int length){
        this.stack = new int[length];
    }

    public boolean isStackEmpty(){
        return this.top == 0;
    }

    public int push(int element) throws Exception {
        if(this.top == this.stack.length){
            throw new Exception("Stack is full");
        }
        stack[this.top] = element;
        this.top++;
        return this.top;
    }

    public int pop() throws Exception {
        if(this.top == 0){
            throw new Exception("Stack is empty ");
        }
        this.top--;
        /*int result = stack[this.top];
        stack[this.top] = 0;*/
        return stack[this.top];
    }
}

