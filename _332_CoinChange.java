package neetcode_150;

import java.util.Arrays;

/**
 *
 * @Sir Darey
 */
public class _332_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n =  amount +1;
        int [] dp = new int [n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        
        for (int i=0; i<n; i++) {
            for (int c : coins)
                if (i - c >= 0)
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);
        }
        return (dp[amount] == n)? -1 : dp[amount];
    }
}
