package neetcode_150;

import java.util.HashMap;

/**
 *
 * @Sir Darey
 */
public class _76_MinWinSubString {
    
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) 
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        int matched = 0, start = 0, minLen = s.length() + 1, subStr = 0;
        
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length()?"":s.substring(subStr,subStr+minLen);
    }
    
    public static void main(String[] args) {
        _76_MinWinSubString solution = new _76_MinWinSubString();
        
        String s = "bba", t = "ba";
        System.out.println(solution.minWindow(s, t));
    }
    
}
