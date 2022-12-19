package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _238_ArrayProductExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
       
    public static void main(String[] args) {
        _238_ArrayProductExceptSelf solution = new _238_ArrayProductExceptSelf();
        int [] nums = {1,2,3,4};
        int [] result = new int [nums.length];
        
        result = solution.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    
}
