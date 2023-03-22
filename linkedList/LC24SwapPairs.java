package linkedList;

import java.util.List;

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

    // Change the forward edges first
    // Then change the backward edges
    public static ListNode iterativeSwapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
            prev = cur;
            cur = cur.next;
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
