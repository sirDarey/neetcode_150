package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _704_BinarySearch {
    
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid+1;
            if (nums[mid] > target) right = mid-1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        _704_BinarySearch solution = new _704_BinarySearch();
        
        int [] nums = {-1,0,3,5,9,12};
        System.out.println(solution.search(nums, 3));
    }
    
}
