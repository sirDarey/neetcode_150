package neetcode_150;

import java.util.PriorityQueue;

/**
 *
 * @Sir Darey
 */
public class _215_KthLargestElementInArray {
    PriorityQueue <Integer> q = new PriorityQueue<>(); 
    int k;
    
    public _215_KthLargestElementInArray(int k, int[] nums) {
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