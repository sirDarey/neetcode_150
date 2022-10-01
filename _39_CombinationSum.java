package neetcode_150;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _39_CombinationSum {
   
    List<List<Integer>> result = new ArrayList<>();
    List <Integer> temp = new ArrayList<>();
    int n, target;
    int [] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        this.target = target;
        this.candidates = candidates;
        
        recur(0, 0);
        return result;
    }
    
    void recur (int i, int total) {
        if (total == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if (total > target || i == n)
            return;
        
        temp.add(candidates[i]);
        recur (i, total + candidates[i]);
        
        temp.remove(temp.size()-1);
        recur (i + 1, total);
    }
}
