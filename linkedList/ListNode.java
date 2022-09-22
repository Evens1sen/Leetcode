package linkedList;

import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(String listStr) {
        int[] nums = Arrays.stream(listStr.substring(1, listStr.length() - 1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num, null);
            cur = cur.next;
        }

        this.val = dummy.next.val;
        this.next = dummy.next.next;
    }


    public void printList() {
        ListNode cur = this;
        while (cur.next != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }
}
