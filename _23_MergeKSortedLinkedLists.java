package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _23_MergeKSortedLinkedLists {
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; 
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        return recur (lists, 0, lists.length-1);
    }
    
    ListNode recur (ListNode [] lists, int start, int end) {
        if (start == end) 
            return lists[start];
        
        int mid = (start + end)/2;

        ListNode L1 = recur(lists, start, mid);
        ListNode L2 = recur(lists, mid+1, end);

        return mergeTwoSorted (L1, L2);
    }
    
    ListNode mergeTwoSorted (ListNode L1, ListNode L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;
        
        ListNode headDummy = new ListNode(0),
                 tail = headDummy;
        
        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                tail.next = L1;
                L1 = L1.next;
            } else {
                tail.next = L2;
                L2 = L2.next;
            }
            tail = tail.next;
        }
        
        if (L1 == null) 
            tail.next = L2;
        else
            tail.next = L1;
        
        return headDummy.next;
    }
   
}
