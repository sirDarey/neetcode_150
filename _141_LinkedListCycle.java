package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _141_LinkedListCycle {
   
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        ListNode slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}