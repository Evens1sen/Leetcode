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

    public static void reorderList(ListNode head) {
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
        }else {
            cur.next = null;
        }
    }
}
