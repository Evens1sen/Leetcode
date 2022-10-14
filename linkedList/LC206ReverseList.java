package linkedList;

public class LC206ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        head.printList();
        ListNode newHead = reverseList(head);
        newHead.printList();
    }

    public static ListNode reverseList(ListNode head) {
        return iterativeReverse(head);
    }

    private static ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode end = head.next;
        ListNode newHead = reverseList(head.next);
        end.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode iterativeReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
