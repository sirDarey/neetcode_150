package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _33_SearchRotatedArray {
    
    public int search(int[] nums, int target) {
    
        int n = nums.length,  
                left = 0, right = n-1;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right ])
                left = mid+1;
            else {
                right = mid;
            }
        }
            
        int pivot = right;
        left = 0; right = n-1;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            int realMid = (pivot + mid)%n;
            
            if (nums[realMid] == target)
                return realMid;
            if (nums[realMid] >  target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
       
    public static void main(String[] args) {
        _33_SearchRotatedArray solution = new _33_SearchRotatedArray();
        
        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 9));        
    }
    
}
