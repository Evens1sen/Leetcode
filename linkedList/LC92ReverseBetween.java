package linkedList;

public class LC92ReverseBetween {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head = new ListNode(5, null);
        head.printList();
        reverseBetween(head, 1, 1);
        head.printList();
    }

    // Fixme
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right - left + 1);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reverseBetweenTwice(ListNode head, int left, int right) {
        ListNode firstTail;
        ListNode first;
        ListNode last;
        ListNode cur = head;
        for (int i = 1; i < left - 1; i++) {
            cur = cur.next;
        }
        firstTail = cur;
        first = cur.next;
        for (int i = left - 1; i < right; i++) {
            cur = cur.next;
        }
        last = cur;

        ListNode lastHead = last.next;
        last.next = null;
        ListNode node = LC206ReverseList.reverseList(first);
        firstTail.next = node;
        first.next = lastHead;

        return head;
    }

    public static ListNode reverseBetweenOnce(ListNode head, int left, int right) {
        ListNode firstTail = head;
        for (int i = 1; i < left - 1; i++) {
            firstTail = firstTail.next;
        }

        ListNode pre = null;
        ListNode cur = firstTail.next;
        ListNode temp = firstTail.next;
        if (cur == null || cur.next == null) {
            return head;
        }

        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        firstTail.next = pre;
        temp.next = cur;

        return head;
    }

    static ListNode successor;

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode second = head.next;
        ListNode newHead = reverseN(head.next, n - 1);
        second.next = head;
        head.next = successor;

        return newHead;
    }

}
