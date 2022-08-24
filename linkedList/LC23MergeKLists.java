package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return heapSolution(lists);
    }

    public ListNode iterativeSolution(ListNode[] lists) {
        return null;
    }

    public ListNode recursiveSolution(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode heapSolution(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode lst : lists) {
            if (lst != null) {
                pq.add(lst);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }

            cur.next = node;
            cur = cur.next;
        }

        return head.next;
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    // Helper function
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 == null ? list2 : list1);
        return head.next;
    }
}
