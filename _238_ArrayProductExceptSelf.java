package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _238_ArrayProductExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int [] result = new int [nums.length];
  
        for (int i=0; i<nums.length; i++) {
           result [i] = temp;
           temp = temp * nums[i];
        }  
        
        temp = 1;
        
        for (int i=nums.length-1; i>=0; i--) {
            result[i] = result[i] * temp;
            temp = temp * nums[i];
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
