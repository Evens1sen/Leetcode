package linkedList;

public class LC61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        fast.next = head;
        return secondHalf;
    }
}
