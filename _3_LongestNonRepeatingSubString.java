package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _3_LongestNonRepeatingSubString {
    
    public int lengthOfLongestSubstring(String s) {
    
        int max = 0;
        Map <Character, Integer> map = new HashMap<>();
        
        int start = 0;
        
        for (int end = 0; end < s.length(); end++){            
            char c = s.charAt(end);
            if (map.containsKey(c))
                start = Math.max(start, map.get(c)+1);
            
            map.put(c, end);
            max = Math.max(max, (end - start +1));            
        }
        return max;
    }
       
    public static void main(String[] args) {
        _3_LongestNonRepeatingSubString solution = new _3_LongestNonRepeatingSubString();
        System.out.println(solution.lengthOfLongestSubstring("abcaekuebc"));
    }
    
            
}
