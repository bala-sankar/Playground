package problems;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

Hint: Consider each node in the stack having a minimum value.
 */
public class MinStack {
    private int top = -1;
    private int[] stackValues;
    private int[] minValues;
    private int min = Integer.MAX_VALUE;

    // Use Stack data structure
    // private Stack<>
    public MinStack() {
        stackValues = new int[1000];
        minValues = new int[1000];
    }

    public void push(int val) {
        min = Math.min(min, val);
        this.top++;
        stackValues[this.top] = val;
        minValues[this.top] = min;
    }

    public void pop() {
        this.top--;
        if (top > -1) {
            min = this.minValues[this.top];
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stackValues[this.top];
    }

    public int getMin() {
        return minValues[this.top];
    }
}

//    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        int r;
//        minStack.push(2147483646);
//        minStack.push(2147483646);
//        minStack.push(2147483647);
//        r = minStack.top();
//        minStack.pop();
//        r = minStack.getMin();
//        minStack.pop();
//        r = minStack.getMin();
//        minStack.pop();
//        minStack.push(2147483647);
//        r = minStack.top();
//        r = minStack.getMin();
//        minStack.push(-2147483648);
//        r = minStack.top();
//        r = minStack.getMin();
//        minStack.pop();
//        r = minStack.getMin();
//    }
