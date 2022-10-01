package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _424_CharacterReplacement {
    
    public int characterReplacement(String s, int k) {
        int right = 0, left = 0, max = 0, result = 0;
        Map <Character, Integer> map = new HashMap<>();
        
        while (right <  s.length()) {
            char c = s.charAt(right);
            int freq = map.getOrDefault(c, 0);
            max = Math.max(max, freq+1);
            map.put(c, freq+1);
            int count = right - left + 1;
            
            if (count - max > k) {
                char last = s.charAt(left);
                map.put(last, map.get(last)-1);
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        
        return result; 
    }
       
    public static void main(String[] args) {
        _424_CharacterReplacement solution = new _424_CharacterReplacement();
        
        System.out.println(solution.characterReplacement("AABACCBBA", 1));
    }
    
            
}
