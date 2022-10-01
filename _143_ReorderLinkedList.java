package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _143_ReorderLinkedList {
   
    int length = 0;
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; 
        }
    }
    
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        ListNode resultHead = head, list1 = head;
        ListNode reverseHead = reverse(head);
        
        list1 = list1.next;
        ListNode tail = resultHead;
        int i = 1;
        
        while (i < length) {
            if (i % 2 == 0) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = reverseHead;
                reverseHead = reverseHead.next;  
            }
            tail = tail.next;
            i++;
        }
        tail.next = null;
        head = resultHead;
    }
       
    ListNode reverse(ListNode head) {
        ListNode current = head, previous = null, next;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            
            length++;
        }
        
        return previous;
    }   
}
