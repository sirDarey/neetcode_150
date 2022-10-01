package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _121_maxStockProfit {
    
    public int maxProfit(int[] prices) {
       if (prices.length < 2)
           return 0;
       
        int max = 0, least = Integer.MAX_VALUE;
        for (int i=0; i < prices.length; i++) {
            
            least = Math.min(least, prices[i]);
            max =   Math.max(max, prices[i] - least);
        }          
        return max;
    }
       
    public static void main(String[] args) {
        _121_maxStockProfit solution = new _121_maxStockProfit();
        
        int [] nums = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(nums));
    }
    
            
}
