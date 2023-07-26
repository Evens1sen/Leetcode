package linkedList;

public class LC234PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        hashSolution(lst);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the end of the first half
        // And reverse the second half
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Recover the initial list
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // Fast-slow pointers
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static boolean hashSolution(ListNode head) {
        ListNode cur = head;
        int base = 10, mod = 1000000007;
        int left = 0, right = 0, mul = 1;

        while (cur != null) {
            left = (int) (((long) left * base + cur.val) % mod);
            right = (int) ((right + (long) mul * cur.val) % mod);
            mul = (int) ((long) mul * base % mod);
            cur = cur.next;
        }

        return left == right;
    }
}
