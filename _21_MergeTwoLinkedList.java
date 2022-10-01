package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _21_MergeTwoLinkedList {
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; 
        }
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        
        ListNode head;
        if (list1.val < list2.val) {
            head = list1; 
            list1 = list1.next;
        } else  {
            head = list2;
            list2 = list2.next;            
        }
        
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else  {
                tail.next = list2;
                list2 = list2.next;
            }
            
            tail = tail.next;
        }
        
        if (list1 == null)
            tail.next = list2;
        else
            tail.next = list1;
        
        return head;            
    }
   
}
