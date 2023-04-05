package linkedList;

public class LC25ReverseNodesInKGroup {

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
