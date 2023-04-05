package slideWindow;

import java.util.*;

public class LC239SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        return dequeSolution(nums, k);
    }

    public static int[] dequeSolution(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    static class MonotonicQueue {
        // A decrease queue
        LinkedList<Integer> maxq = new LinkedList<>();

        public void push(int n) {
            // Delete tail elements until the element greater than n
            while (!maxq.isEmpty() && maxq.getLast() < n) {
                maxq.pollLast();
            }
            // Add n to the tail
            maxq.addLast(n);
        }

        public int max() {
            return maxq.getFirst();
        }

        public void pop(int n) {
            if (n == maxq.getFirst()) {
                maxq.pollFirst();
            }
        }
    }

    // Use a heap to maintain the maximum element in slide window
    // Delete only when the top element is not in the window
    // Time complexity: O(nlogk) Space complexity: O(k)
    public static int[] heapSolution(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val != o2.val) {
                return o2.val - o1.val;
            } else {
                return o1.index - o2.index;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }

        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek().val;
        for (int i = k; i < n; i++) {
            // Add the new element to the window
            pq.add(new Pair(nums[i], i));

            // Pop the top element if out of bound
            while (pq.peek().index < i - k + 1) {
                pq.poll();
            }

            // Get the max, but do not delete
            ans[i - k + 1] = pq.peek().val;
        }

        return ans;
    }

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
