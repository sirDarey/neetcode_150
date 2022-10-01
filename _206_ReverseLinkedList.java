package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _206_ReverseLinkedList {
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; 
        }
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode current = head,
                previous = null, next = null;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
   
}
