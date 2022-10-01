package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _167_TwoSumII {
    
    public int[] twoSum(int[] numbers, int target) {
        
        int i = 0, j = numbers.length-1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[] {i+1 ,j+1};
            else {
                if (numbers[i] + numbers[j] > target )
                    j--;
                else
                    i++;
            }
        }
        return null;
    }
       
    public static void main(String[] args) {
        _167_TwoSumII solution = new _167_TwoSumII();
        
        int [] nums = {2,7,11,15};
        int [] result = solution.twoSum(nums, 9);
        
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    
}
