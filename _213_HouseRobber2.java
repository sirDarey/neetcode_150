package neetcode_150;

import java.util.Arrays;

/**
 *
 * @Sir Darey
 */
public class _213_HouseRobber2 {
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        
        int [] nums1 =  Arrays.copyOfRange(nums, 0, n-1);
        int [] nums2 =  Arrays.copyOfRange(nums, 1, n);
        return Math.max(robCircular(nums1), robCircular(nums2));
    }
    
    int robCircular (int [] nums) {
        int n = nums.length;
        
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) 
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        
        return nums[n-1];
    }        
}
