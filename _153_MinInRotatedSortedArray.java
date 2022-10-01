package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _153_MinInRotatedSortedArray {
    
    public int findMin(int[] nums) {
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right])
                left = mid+1;
            else {
                right = mid;
            }
        }
        
        //pivot gives us the number of times the array was rotated
        
       return nums[right];
        
    }
       
    public static void main(String[] args) {
        _153_MinInRotatedSortedArray solution = new _153_MinInRotatedSortedArray();
        
        int [] piles = {3};
        System.out.println(solution.findMin(piles));
    }
    
}
