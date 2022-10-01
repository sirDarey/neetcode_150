package neetcode_150;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _242_ValidAnagram {
    
    public boolean isAnagram (String s, String t) {
        if (s.length() != t.length())
            return false;
        
        Map <Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
            
            if (map.get(s.charAt(i))==0)
                map.remove (s.charAt(i));
            
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i))==0)
                map.remove(t.charAt(i));
        }
        
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
        _242_ValidAnagram solution = new _242_ValidAnagram();
        
        System.out.println(solution.isAnagram("ana!gram", "nagara!m"));                  
        
        
    }
    
}
