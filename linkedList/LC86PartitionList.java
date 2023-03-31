package linkedList;

public class LC86PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        ListNode cur1 = smaller;
        ListNode cur2 = larger;

        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
                cur1.next = null;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
                cur2.next = null;
            }
            head = next;
        }

        cur1.next = larger.next;
        return smaller.next;
    }
}
