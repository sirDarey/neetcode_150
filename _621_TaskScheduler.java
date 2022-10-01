package neetcode_150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @Sir Darey
 */
public class _621_TaskScheduler {
    
    public int leastInterval(char [] tasks, int n) {
        Map <Character, Integer> map  = new HashMap<>();
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b - a); 
        Queue <Integer> q = new LinkedList<>();
        int time = 0;
        
        for (char c : tasks) 
            map.put(c, map.getOrDefault(c, 0)+1);
        
        map.entrySet().forEach(entry -> {
            pq.offer(entry.getValue());
        });
        
        while (!pq.isEmpty() || !q.isEmpty()) {
            time += 1;
            if (!pq.isEmpty()) {
                int maxHeap = pq.poll() - 1;
                if (maxHeap > 0) {
                    q.offer(n + time);
                    q.offer(maxHeap);
                }            
            }
            
            if (!q.isEmpty() && q.peek() == time) {
                q.poll();
                pq.offer(q.poll());
            }
        }
        return time;
    }
    
    public static void main(String[] args) {
        _621_TaskScheduler obj = new _621_TaskScheduler();
        
        char [] tasks = {'A', 'A', 'A', 'B', 'B'};
        System.out.println(obj.leastInterval(tasks, 2));
    }
}