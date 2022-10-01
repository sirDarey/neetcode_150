package neetcode_150;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @Sir Darey
 */
public class _239_SlidingWinMax {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int [n - k + 1];
        Deque <Integer> deque = new LinkedList<>();
        int i = 0, j = 0;
        
        while (j < n) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[j])
            deque.pollLast();
            deque.offer(j);
            
            if (i > deque.getFirst())
                deque.pollFirst();
            
            if (j+1 >= k) {
                result[i] = nums [deque.getFirst()];
                i++;
            }
            j++;
        }       
        return result;
    }    
    
    public static void main(String[] args) {
        _239_SlidingWinMax solution = new _239_SlidingWinMax();
       
        int [] result = solution.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    
}
