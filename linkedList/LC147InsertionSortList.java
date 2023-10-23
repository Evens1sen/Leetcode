package linkedList;

public class LC147InsertionSortList {

/*
    List [head, right] is the sorted list
    If the current node is greater than right, need to move right
    else we need to insert current node into this range
 */
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-10000);
        dummy.next = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            ListNode inserted = right.next;
            if (inserted.val >= right.val) {
                right = right.next;
                continue;
            }

            right.next = inserted.next;
            ListNode cur = dummy;
            ListNode prev = null;
            while (cur != right.next && inserted.val > cur.val) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = inserted;
            inserted.next = cur;
        }
        return dummy.next;
    }
}
