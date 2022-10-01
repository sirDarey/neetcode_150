package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _25_ReverseNodesInKGroup {
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; 
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head),
                 lastGroup = dummy;
        
        while (true) {
            ListNode kth = getKth (lastGroup, k);
            if (kth == null)
                break;
            
            ListNode nextGroup = kth.next,
                     prev = nextGroup,
                     current = lastGroup.next;
         
            while (current != nextGroup) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            
            ListNode temp = lastGroup.next;
            lastGroup.next = kth;
            lastGroup = temp;            
        }
        return dummy.next;
    }
    
    ListNode getKth (ListNode lastGroup, int k) {
        ListNode current = lastGroup;
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
   
}
