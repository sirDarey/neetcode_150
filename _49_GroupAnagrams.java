package neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Sir Darey
 */
public class _49_GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap<>();
        List <List<String>> result = new ArrayList<>();
        
        for (String word : strs) {
            char [] letters = word.toCharArray();
            String newWord = new String(sort(letters));
            
            if (map.containsKey(newWord)) 
                map.get(newWord).add(word);
            else {
                List <String> newList = new ArrayList<>();
                newList.add(word);
                map.put(newWord, newList);
            }
        }
        
        map.keySet().forEach(key ->  {
            result.add(map.get(key));
        });
        
        return result;
    }
    
    public char [] sort (char [] letters) {
        int n = letters.length;
        for (int i=1; i<n; i++) {
            int diff = letters[i] - 'a';
            char temp = letters[i];
            int j = i-1;
            while (j >= 0 && diff < (letters[j] - 'a')) {
                letters[j+1] = letters [j];
                j--;
            }
            letters[++j] = temp;
        }
        return letters;
    }
    
    public static void main(String[] args) {
        _49_GroupAnagrams solution = new _49_GroupAnagrams();
        
        String [] words = {"eat","tea","tan","ate","nat","bat"};
        List <List<String>> result = solution.groupAnagrams(words);
        
        result.forEach(ans -> {
            System.out.println(ans);
        });
        
        
                
    }
    
}
