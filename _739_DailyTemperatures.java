package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _739_DailyTemperatures {
    
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1)
            return new int [] {0};
        
        int n = temperatures.length;
        int [] result = new int [n];
        result[n-1] = 0;
        
        int max = temperatures[n-1];
        
        for (int i = n-2; i >=0; i--) {
            if (temperatures[i] >= max) {
                result[i] = 0;
                max = temperatures[i];
            } else {
                int j = i+1;
            
                while (j < n && temperatures[j] <= temperatures[i]) 
                    j++;
            
            result[i] = j-i;
            }
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
