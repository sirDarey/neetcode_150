package neetcode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _90_Subsets2 {
   
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int n;
    int [] nums;
            
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        recur (0);
        return result;
    }
    
    void recur (int i) {
        if (i == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[i]);
        recur (i + 1);
        
        temp.remove(temp.size()-1);
        while (i+1 < n && nums[i] == nums[i+1])
            i++;
        recur(i + 1);
    }
    
    public static void main(String[] args) {
        _90_Subsets2 obj = new _90_Subsets2();
        int [] nums = {4,4,4,1,4};
        obj.subsetsWithDup(nums);
        System.out.println(obj.result);
    }
}
