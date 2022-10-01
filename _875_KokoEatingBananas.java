package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _875_KokoEatingBananas {
    
    public int minEatingSpeed(int[] piles, int h) {
//        int maxPile = 0;
//       
//        for (int i : piles)
//            maxPile = Math.max(i, maxPile);
        
        int minSpeed = Integer.MAX_VALUE,
            left = 1, right = Integer.MAX_VALUE;
        
        while (left <= right) {
            int k = left + (right - left)/2;
            int time = 0;
            
            for (int i : piles) {
                time +=  i/k;
                if (i%k != 0)
                    time++;
            }
                             
            if (time <= h) {
                minSpeed = Math.min(minSpeed, k);
                right = k - 1;
            } else
                left = k + 1;
        }
        return minSpeed;
    }
       
    public static void main(String[] args) {
        _875_KokoEatingBananas solution = new _875_KokoEatingBananas();
        
        int [] piles = {805306368,805306368,805306368};
        System.out.println(solution.minEatingSpeed(piles, 1000000000));
        System.out.println(Integer.MAX_VALUE);
    }
    
}
