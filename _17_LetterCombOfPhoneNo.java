package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _17_LetterCombOfPhoneNo {
    
    List <String> result = new ArrayList<>();
    Map <Character, String> map = new HashMap<>();
    String digits;
    int n;
    
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        n = digits.length();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        if (!digits.isEmpty())
            recur (0, "");
        return result;
    }
    
    void recur (int i, String temp) {
        if (temp.length() == n) {
            result.add(temp);
            return;
        }
        
        for (char c : map.get(digits.charAt(i)).toCharArray())
            recur(i+1, temp+c);
    }
}
