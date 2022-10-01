package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _347_TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> rawMap = new HashMap<>();
        Map <Integer, List<Integer>> freqMap = new HashMap<>();
        int [] result = new int [k];
        
        for (int i : nums) {
            rawMap.put(i, rawMap.getOrDefault(i, 0)+1);
        }
        
        rawMap.entrySet().forEach(x -> {
            if (freqMap.containsKey(x.getValue())) {
                freqMap.get(x.getValue()).add(x.getKey());
            }else{
                List <Integer> newList = new ArrayList<>();
                newList.add(x.getKey());
                freqMap.put(x.getValue(), newList);
            }
        });
        
        int [] sortFreq = new int [freqMap.size()];
        int i = 0;        
        for (Map.Entry<Integer, List<Integer>> entry : freqMap.entrySet()) {
            sortFreq[i] = entry.getKey();
            i++;
        }
        
        int count = 0;
        for (int j=sortFreq.length-1; j>=0; j--) {
            for (int ans : freqMap.get(sortFreq[j])) {
                result [count] = ans;
                count ++;
               
                if (count == k)
                    return result;
            }
        }
         
        return null;
    }
       
    public static void main(String[] args) {
        _347_TopKFrequentElements solution = new _347_TopKFrequentElements();
        
        int [] nums = {1,2,4,2,1,4,5,1,2,-1,-1,-1,-1};
        int [] result = solution.topKFrequent(nums, 2);
        
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    
}
