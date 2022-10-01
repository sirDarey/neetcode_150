package neetcode_150;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _46_Permutations {
   
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int [] nums; 
    int n;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        recur();
        return result;
    }

    void recur(){
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            recur();
            temp.remove(temp.size()-1);
        }
    }
}
