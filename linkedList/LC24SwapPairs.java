package linkedList;

public class LC24SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head.printList();
        head = swapPairs(head);
        head.printList();
    }

    public static ListNode swapPairs(ListNode head) {
        return iterativeSwapPairs(head);
    }

    public static ListNode iterativeSwapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            pre.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            pre = l1;
        }
        return dummy.next;
    }

    public static ListNode recursiveSwapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextHead = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextHead);

        return newHead;
    }
}
