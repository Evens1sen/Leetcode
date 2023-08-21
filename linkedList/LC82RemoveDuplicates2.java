package linkedList;

public class LC82RemoveDuplicates2 {

    public static void main(String[] args) {
        ListNode lst = new ListNode("[1, 1, 1, 2, 3]");
        lst.printList();
        lst = deleteDuplicates(lst);
        lst.printList();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            while (node != null && node.val == cur.val) {
                node = node.next;
            }

            if (node == cur.next) {
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = node;
                cur = node;
            }
        }

        return dummy.next;
    }
}
