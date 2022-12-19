package neetcode_150;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @Sir Darey
 */
public class _128_LongestConSequence {
    
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new TreeSet<>();
        for (int num : nums)
            set.add(num);
        
        int prev = 0;
        for (int num : set) {
            prev = num;
            break;
        }

        int result = 0, temp = 0;
        --prev; 

        for (int current : set){
            if (current - prev == 1) 
                temp++;
            else {
                result = Math.max(result, temp);
                temp = 1; 
            }
            prev = current;
        }

        return Math.max(result, temp);

    }
    
    
    public static void main(String[] args) {
        _128_LongestConSequence solution = new _128_LongestConSequence();
        
        int [] nums = {5,0,8,7,6,1,3,2,9};
        
        System.out.println(solution.longestConsecutive(nums));
    }
    
}
