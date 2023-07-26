package linkedList;

public class LC25ReverseNodesInKGroup {

    public static ListNode iterativeSolution(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (true) {
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            ListNode curr = prev.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }

        ListNode newHead = reverseFirstK(head, k);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    public ListNode reverseFirstK(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
