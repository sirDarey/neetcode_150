package neetcode_150;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _128_LongestConSequence {
    
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new HashSet();
        
        for(int i : nums){
            set.add(i);
        }
        
        int maxSoFar = 0;
        
        for(int i : nums){
            
            //check if nums[i] id present in set or not
            //since after checking in set we remove the element from 
            //set, there is no double calculation for same sequence 
            if(set.contains(i)){
                set.remove(i);
                
                int previous = i-1;
                int after = i+1;
                int tempMax = 1;
                
                //check both ways from nums[i] and calculate 
                //tempL. since we are removing elements from 
                //set we only calculate once for every sequence.
                
                while(set.contains(previous)){
                    set.remove(previous);
                    previous--;
                    tempMax++;
                }
                
                while(set.contains(after)){
                    set.remove(after);
                    after++;
                    tempMax++;
                }
                
                
                maxSoFar = Math.max(maxSoFar, tempMax);
                
            }
        }
        
        return maxSoFar;
    }
    
    
    public static void main(String[] args) {
        _128_LongestConSequence solution = new _128_LongestConSequence();
        
        int [] nums = {0,7,6,1,3,2};
        
        System.out.println(solution.longestConsecutive(nums));
    }
    
}
