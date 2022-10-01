package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _125_ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length()-1;
        
        while (start < end) {
            if (Character.isLetterOrDigit(s.charAt(start)) &&
                    Character.isLetterOrDigit(s.charAt(end))) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++; end--;
                } else 
                    return false;  
            } else {
                if (!Character.isLetterOrDigit(s.charAt(start)))
                    start++;
                if (!Character.isLetterOrDigit(s.charAt(end)))
                    end--;
            }
        }
        return true;
    }
       
    public static void main(String[] args) {
        _125_ValidPalindrome solution = new _125_ValidPalindrome();
        
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
    
}
