package linkedList;

public class LC83DeleteDuplicates {

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
