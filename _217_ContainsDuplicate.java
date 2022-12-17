package neetcode_150;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _217_ContainsDuplicate {
    
    public boolean containsDuplicate (int [] nums) {
        Set <Integer> set = new HashSet<> ();
        for (int num : nums)
            if  (!set.add(num))
                return true;
        return false;
    }
    
    public static void main(String[] args) {
        _217_ContainsDuplicate solution = new _217_ContainsDuplicate();
        
        int [] nums1 = {1,2,3,1};
        int [] nums2 = {1,2,3,4};
        int [] nums3 = {1,1,1,3,3,4,3,2,4,2};
        
        System.out.println(solution.containsDuplicate(nums1));
        System.out.println(solution.containsDuplicate(nums2));
        System.out.println(solution.containsDuplicate(nums3));
        
    }
    
}
