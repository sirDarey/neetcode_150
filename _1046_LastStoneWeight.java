package neetcode_150;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @Sir Darey
 */
public class _1046_LastStoneWeight {
        
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> q = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for (int i : stones) 
            q.offer(i);
        
        while (q.size() > 1) {
            int difference = q.poll() - q.poll();
            if (difference > 0)
                q.offer(difference);
        }
        
        return q.isEmpty()? 0 : q.poll();
    }
}