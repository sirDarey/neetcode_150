package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _42_TrappingRain {
    
    public int trap(int[] height) {
        int units = 0, left = 0, right = height.length - 1,
                leftMax = 0, rightMax = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height [left];
                else
                    units += leftMax - height[left];
                
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    units += rightMax - height[right];
                
                right--;
            
            }
        }
        return units;
    }  
       
    public static void main(String[] args) {
        _42_TrappingRain solution = new _42_TrappingRain();
        
        int [] nums1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] nums2 = {4,2,0,3,2,5};
        
        System.out.println(solution.trap(nums1));
        System.out.println(solution.trap(nums2));
    }
    
            
}
