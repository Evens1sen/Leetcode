package stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC735AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {-2, -2, 1, -2};
        System.out.println(asteroidCollision(asteroids));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (Integer cur : asteroids) {
            if (stack.isEmpty() || !canCollide(stack.peek(), cur)) {
                stack.push(cur);
                continue;
            }

            boolean flag = false;
            while (!stack.isEmpty() && canCollide(stack.peek(), cur)) {
                int peek = stack.peek();
                if (Math.abs(peek) > Math.abs(cur)) {
                    flag = false;
                    break;
                } else if (Math.abs(peek) < Math.abs(cur)) {
                    stack.pop();
                    flag = true;
                } else {
                    flag = false;
                    stack.pop();
                    break;
                }
            }

            if (flag) {
                stack.push(cur);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static boolean canCollide(int a, int b) {
        return a > 0 && b < 0;
    }
}
