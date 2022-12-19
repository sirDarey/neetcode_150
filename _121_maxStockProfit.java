package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _121_maxStockProfit {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minCP = prices[0];
        prices[0] = 0;

        for (int i=1; i<n; i++) {
            minCP = Math.min(minCP, prices[i]);
            prices[i] = Math.max(prices[i-1], prices[i] - minCP);
        }
        return prices[n-1];
    }
       
    public static void main(String[] args) {
        _121_maxStockProfit solution = new _121_maxStockProfit();
        
        int [] nums = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(nums));
    }
    
            
}
