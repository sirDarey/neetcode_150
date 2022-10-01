package neetcode_150;

import java.util.PriorityQueue;

/**
 *
 * @Sir Darey
 */
public class _703_KthLargestElement {
    PriorityQueue <Integer> q = new PriorityQueue<>(); 
    int k;
    
    public _703_KthLargestElement(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k)
                q.poll();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if (q.size() > k)
                q.poll();
        return q.peek();
    }
}