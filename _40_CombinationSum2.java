package neetcode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _40_CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    List <Integer> temp = new ArrayList<>();
    int [] candidates;
    int n, status = 0;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        n = candidates.length;
        recur(0, target);
        return result;
    }
    
    void recur (int i, int target) {
        if (target == 0)    
            result.add(new ArrayList<>(temp));
        if (target <= 0) {
            status = 1;
            return;
        }
            
        
        int prev = -1;
        for (int j=i; j<n; j++) {
            if (candidates[j] == prev)
                continue;
            
            temp.add(candidates[j]);
            recur (j + 1, target - candidates[j]);
            
            temp.remove(temp.size()-1);
            
            if (status == 1)
                break;
            prev = candidates[j];
        }
        status = 0;
    }
}
