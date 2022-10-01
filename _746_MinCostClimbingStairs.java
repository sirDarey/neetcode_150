package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _746_MinCostClimbingStairs {
    
    public int minCostClimbingStairs(int[] cost) {
        for (int i=cost.length-3; i>=0; i--) {
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}
