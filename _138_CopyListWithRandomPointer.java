package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _138_CopyListWithRandomPointer {
   
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }  
    
    public Node copyRandomList(Node head) {
         if (head == null)
             return null;
         
        Map <Node, Node> map = new HashMap<>();
        Node originalCurrent = head;
        
        while (originalCurrent != null) {
            map.put (originalCurrent, new Node(originalCurrent.val));
            originalCurrent = originalCurrent.next;
        }
        
        originalCurrent = head;
        
        while (originalCurrent != null) {
            Node mapNode = map.get(originalCurrent);
            
            mapNode.next = map.get(originalCurrent.next);
            mapNode.random = map.get(originalCurrent.random);
            originalCurrent = originalCurrent.next;
        }
        return map.get(head);
    }
}