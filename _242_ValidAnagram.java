package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _242_ValidAnagram {
    
    public boolean isAnagram (String s, String t) {
        int arr [] = new int[26];

        for (char c1 : s.toCharArray())
            arr[c1 - 'a']++;
        for (char c2 : t.toCharArray())
            arr[c2 - 'a']--;
        
        for (int i : arr)
            if (i != 0)
                return false;

        return true;
    }
    
    public static void main(String[] args) {
        _242_ValidAnagram solution = new _242_ValidAnagram();
        
        System.out.println(solution.isAnagram("anagram", "nagaram"));                  
        
        
    }
    
}
