package neetcode_150;

import java.util.Stack;

/**
 *
 * @Sir Darey
 */
public class _739_DailyTemperatures {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result [] = new int [n];

        Stack <int []> stack = new Stack<>();
        stack.push(new int[]{temperatures[n-1], n-1});

        for (int i=n-2; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= stack.peek()[0])
                stack.pop();
            if (!stack.isEmpty())
                result[i] = stack.peek()[1] - i;
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
    
    public static void main(String[] args) {
        _739_DailyTemperatures solution = new _739_DailyTemperatures();
        
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int [] result = solution.dailyTemperatures(temperatures);
        for (int i : result) 
            System.out.print(i+" "); 
    }
    
}
