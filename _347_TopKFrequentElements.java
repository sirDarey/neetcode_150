package neetcode_150;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @Sir Darey
 */
public class _347_TopKFrequentElements {
    
    private class Data <Num, Freq> {
        private final int num;
        private final int freq;

        public Data (int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getNum () {
            return num;
        }

        public int getFreq () {
            return freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0)+1);
        
        Comparator <Data<Integer, Integer>> compareFreq = (Data<Integer, Integer> data1, Data<Integer, Integer> data2) -> {
            if (data2.getFreq() > data1.getFreq())
                return 1;
            else
                return -1;
        };

        Set <Data<Integer, Integer>> set = new TreeSet<>(compareFreq);

        map.entrySet().forEach(x-> {
            set.add(new Data(x.getKey(), x.getValue()));
        });

        int result [] = new int [k];
        int i = 0;

        for (Data <Integer, Integer> data : set) {
            if (i == k)
                break;
            result[i] = data.getNum();
            i++;
        }

        return result;
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
