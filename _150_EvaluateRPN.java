package neetcode_150;

import java.util.Stack;

/**
 *
 * @Sir Darey
 */
public class _150_EvaluateRPN {
    
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        
        for (String i : tokens) {
            int a,  b;
            switch (i) {
                case "*" : stack.push(stack.pop() * stack.pop()); break;
                case "+" : stack.push(stack.pop() + stack.pop()); break;
                case "-" : 
                    b = stack.pop(); a = stack.pop();
                    stack.push(a - b);
                    break;
                case "/" : 
                    b = stack.pop(); a = stack.pop();
                    stack.push(a / b);
                    break;
                default: stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        _150_EvaluateRPN solution = new _150_EvaluateRPN();
        
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens));
    }
    
}
