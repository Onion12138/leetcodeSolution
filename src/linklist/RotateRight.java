package linklist;

/**
 * @author onion
 * @date 2019/11/14 -1:41 下午
 * Leetcode
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode first = head;
        int length = 0;
        while(first != null){
            first = first.next;
            length++;
        }
        k %= length;
        if(k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
