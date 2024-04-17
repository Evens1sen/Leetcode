package vo;

import java.util.*;

public class OrderSequence {

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 4, 2};
        System.out.println(localPeak(nums));
    }

    static Node head = new Node(0);
    static Node tail = new Node(0);

    /**
     * See: https://leetcode.com/discuss/interview-question/4154082/Doordash-or-Phone-or-Eligible-order-sequence/
     * Given an array nums, remove the minimum local maximum step by step
     * Find the result of the removal sequence
     *
     * @param nums: [3, 5, 1, 4, 2]
     * @return: [4, 2, 5, 3, 1]
     */
    public static List<Integer> localPeak(int[] nums) {
        int n = nums.length;
        head.next = tail;
        tail.prev = head;

        for (int num : nums) {
            Node node = new Node(num);
            insert(node);
        }

        Node cur = head.next;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        while (cur != tail) {
            if (isPeak(cur)) {
                pq.add(cur);
            }
            cur = cur.next;
        }

        List<Integer> res = new ArrayList<>(n);
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            res.add(min.value);

            Node prev = min.prev;
            Node next = min.next;
            prev.next = next;
            next.prev = prev;
            min.prev = null;
            min.next = null;

            if (prev != head && isPeak(prev)) {
                pq.add(prev);
            } else if (next != tail && isPeak(next)) {
                pq.add(next);
            }
        }

        return res;
    }

    public static boolean isPeak(Node node) {
        return node.value > node.prev.value && node.value > node.next.value;
    }

    public static void insert(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
    }

    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
