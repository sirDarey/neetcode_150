package neetcode_150;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _78_Subsets {
   
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int n;
    int [] nums;
            
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        this.nums = nums;
        recur (0);
        return result;
    }
    
    void recur (int i) {
        if (i == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //Include this element
        temp.add(nums[i]);
        //System.out.println(temp);
        recur (i + 1);
        
        //Don't include this element
        temp.remove(temp.size()-1);
        recur(i + 1);
    }
    
    public static void main(String[] args) {
        _78_Subsets obj = new _78_Subsets();
        int [] nums = {1,2,3};
        obj.subsets(nums);
        System.out.println(obj.result);
    }
}
