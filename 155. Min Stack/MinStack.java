// 155. Min Stack
// Leetcode: Medium
// Neetcode: Medium

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:
// 1. MinStack() initializes the stack object.
// 2. void push(int value) pushes the element value onto the stack.
// 3. void pop() removes the element on the top of the stack.
// 4. int top() gets the top element of the stack
// 5. int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public int push(int elem) {
        stack.push(elem);

        // min stack always keeps which is the current min element in stack
        if(minStack.isEmpty() || minStack.peek() > elem) {
            minStack.push(elem);
        } else {
            minStack.push(minStack.peek());
        }

        return elem;
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
