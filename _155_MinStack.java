package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _155_MinStack {
    
    private Node head;
    
    private static class Node {
        int val, min; Node next;
        
        public Node (int val) {
            this.val = val;
        }
    }
    
    public _155_MinStack() {
       head = null; 
    }
    
    public void push(int val) {
        Node newNode = new Node(val);
        
        if (head == null)
            newNode.min = val;
        else 
            newNode.min = Math.min(head.min, val);
        
        newNode.next = head;
        head = newNode;        
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }    
   
}
