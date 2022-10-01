package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _2_AddTwoNumbers {
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head;
        int carry = 0;
        
        while (l1 != null  && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            while (carry != 0 && l2 != null){
                int sum = l2.val + carry;
                tail.next = new ListNode(sum%10);
                tail = tail.next; 
                carry = sum/10;
                l2 = l2.next;
            }
            
            if (carry == 0)
                tail.next = l2;
        } else {
            if (l2 == null) {
                while (carry != 0 && l1 != null){
                    int sum = l1.val + carry;
                    tail.next = new ListNode(sum%10);
                    tail = tail.next; 
                    carry = sum/10;
                    l1 = l1.next;
                }
            
                if (carry == 0)
                    tail.next = l1;
            }
        }
        
        if (carry > 0)
            tail.next = new ListNode(carry);
        return head.next;
    }    
}
