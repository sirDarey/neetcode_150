package neetcode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _15_ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
              
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>(); 
        
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                
                int j = i+1, k = nums.length-1, sum = 0 - nums[i];
                
                while (j < k) {
                    if (nums[j] + nums[k] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++; k--;
                    } else if (nums[j] + nums[k] < sum) j++;
                    else k--;
               }
            }
        }
        return result;
    }   
       
    public static void main(String[] args) {
        _15_ThreeSum solution = new _15_ThreeSum();
        
        int [] nums = {0,0,0,0};
        System.out.println(solution.threeSum(nums));
    }
    
            
}
