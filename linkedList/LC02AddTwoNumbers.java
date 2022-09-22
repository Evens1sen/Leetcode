package linkedList;

public class LC02AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode("[2, 4, 3]");
        ListNode l2 = new ListNode("[5, 6, 4]");
        ListNode res = addTwoNumbers(l1, l2);
        res.printList();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0, null);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum, null);
            cur = cur.next;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        if (carry == 1) {
            cur.next = new ListNode(1, null);
        }
        return res.next;
    }
}
