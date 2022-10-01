package neetcode_150;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 */
public class _22_GenParentheses {
    
    public List<String> generateParenthesis(int n) {
        List <String> list = new ArrayList<>();
        recur(list, "", 0, 0, n);
        return list;
    }
    
    public void recur (List <String> list, String completeSet, int open, int close, int max) {
        if (completeSet.length() == max*2) {
            list.add(completeSet);
            return;
        }
        
        if (open < max) 
            recur(list, completeSet+"(", open+1, close, max);
        if (close < open) 
            recur(list, completeSet+")", open, close+1, max);
    }
    
    public static void main(String[] args) {
        _22_GenParentheses solution = new _22_GenParentheses();
        
        System.out.println(solution.generateParenthesis(3));
    }
    
}
