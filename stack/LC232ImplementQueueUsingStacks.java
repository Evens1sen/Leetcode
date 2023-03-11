package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC232ImplementQueueUsingStacks {
}

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }

        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
