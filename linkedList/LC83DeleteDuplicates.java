package linkedList;

public class LC83DeleteDuplicates {

    public ListNode iterativeDelete(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode recursiveDelete(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head = recursiveDelete(head.next);
        } else {
            head.next = recursiveDelete(head.next);
        }

        return head;
    }
}
