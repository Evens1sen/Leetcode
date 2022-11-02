package linkedList;

public class LC92ReverseBetween {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head1 = new ListNode(3, new ListNode(5, null));
//        reverseBetween(head, 2, 4);
        reverseBetweenOnce(head1, 1, 2);
        head1.printList();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
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

    // Fixme
    public static ListNode reverseBetweenOnce(ListNode head, int left, int right) {
        ListNode firstTail = head;
        for (int i = 1; i < left - 1; i++) {
            firstTail = firstTail.next;
        }

        ListNode pre = null;
        ListNode cur = firstTail.next;
        ListNode temp = firstTail.next;
        if (cur == null || cur.next == null){
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


}
