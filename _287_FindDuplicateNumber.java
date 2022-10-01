package neetcode_150;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Sir Darey
 */
public class _287_FindDuplicateNumber {
    
    public int findDuplicate(int[] nums) {
        Set <Integer> set = new HashSet<>();
        int ans = -1;
        for (int i : nums) {
            if (!set.add(i)) {
                ans = i;
                break;
            }                        
        }
        return ans;
    }
}
