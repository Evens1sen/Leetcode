package linkedList;

public class LC876MiddleNode {

    /* 1 -> 2 -> 3 -> 4 -> 5 -> 6 */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
