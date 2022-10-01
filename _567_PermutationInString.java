package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _567_PermutationInString {
    
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) 
            return false;
        
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        int check = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) 
                check += count[i];
        }
        if (check == 0) 
            return true;
        
        for (int i = len1; i < len2; i++) {
            if (++count[s2.charAt(i - len1) - 'a'] > 0) 
                check++;
            if (count[s2.charAt(i) - 'a']-- > 0) 
                check--;
            if (check == 0) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        _567_PermutationInString solution = new _567_PermutationInString();
       
        String s1 = "adc", s2 = "dcda";
                
        System.out.println(solution.checkInclusion(s1, s2));
    }
    
}
