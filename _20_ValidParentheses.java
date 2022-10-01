package neetcode_150;

import java.util.Stack;

/**
 *
 * @Sir Darey
 */
public class _20_ValidParentheses {
    
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (!stack.isEmpty()) {
                char open = stack.peek();
                if ((open == '(' && c == ')')
                 || (open == '[' && c == ']')
                 || (open == '{' && c == '}'))
                    
                    stack.pop();
                else
                    return false;
            } else
                return false;
        }
        return stack.isEmpty();
    }
       
    public static void main(String[] args) {
        _20_ValidParentheses solution = new _20_ValidParentheses();
        
        System.out.println(solution.isValid("["));
    }
    
            
}
