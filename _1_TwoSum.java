package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _1_TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<>();
        int[] result = new int [2];

        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        _1_TwoSum solution = new _1_TwoSum();
        
        int [] nums = {2, 7, 3, 5, 4};
        System.out.println(solution.twoSum(nums, 8)[0]);
        System.out.println(solution.twoSum(nums, 8)[1]);
    }
}