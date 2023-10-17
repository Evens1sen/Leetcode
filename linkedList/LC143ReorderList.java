package linkedList;

import java.util.ArrayList;
import java.util.List;

public class LC143ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        head.printList();
        reorderList(head);
        head.printList();
    }

    // Using extra space to store the list
    public static void reorderListWithArray(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        cur = new ListNode(0, null);
        for (int i = 0; i < list.size() / 2; i++) {
            cur.next = list.get(i);
            cur.next.next = list.get(list.size() - 1 - i);
            cur = cur.next.next;
        }

        if (list.size() % 2 != 0) {
            cur.next = list.get(list.size() / 2);
            cur.next.next = null;
        } else {
            cur.next = null;
        }
    }

    // Consider some basic operations
    public static void reorderList(ListNode head) {
        ListNode mid = splitList(head);
        ListNode lst2 = reverseList(mid);
        mergeLists(head, lst2);
    }

    public static ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;

            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        } else if (cur2 != null) {
            cur.next = cur2;
        }

        return dummy.next;
    }
}
