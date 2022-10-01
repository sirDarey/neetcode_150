package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _70_ClimbingStairs {
    
    public int climbStairs(int n) {
        int a = 1, b = 1, c;
        
        for (int i=0; i<n-1;i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
