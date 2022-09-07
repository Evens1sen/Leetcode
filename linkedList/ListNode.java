package linkedList;

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

    public void printList() {
        ListNode cur = this;
        while (cur.next != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }
}
