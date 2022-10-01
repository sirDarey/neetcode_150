package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _647_PalindromicSubstrings {
    String s;
    int n, length = 0;
       
    public int countSubstrings(String s) {
        n = s.length();
        if (n == 1)
            return 1;
        
        this.s = s;
        
        for (int i=0; i<n; i++) {
            //Odd length
            checkPalindrome(i, i);
            //Even Length
            checkPalindrome(i, i+1);
        }
         
        return length;
    }
    
    void checkPalindrome(int left, int right) {
        while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
            length++;
            left--; right++;
        }
    }
}
