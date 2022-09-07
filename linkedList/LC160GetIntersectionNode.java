package linkedList;

public class LC160GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else if (curB == null) {
                curB = headA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return curA;
    }

}
