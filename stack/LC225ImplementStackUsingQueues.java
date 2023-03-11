package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC225ImplementStackUsingQueues {
}

class MyStack {

    Deque<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int cnt = queue.size();
        queue.add(x);
        for (int i = 0; i < cnt; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
