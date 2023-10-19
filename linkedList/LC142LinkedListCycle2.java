package linkedList;

public class LC142LinkedListCycle2 {

    /* The induction to find the cycle entrance
        a + (b + c) is the list
        fast = a + k(b + c)
        slow = a + b
        2(a + b) = a + k(b + c)
        a = (k - 1)(b + c) + c
    */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
