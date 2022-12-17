package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _11_ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length-1;
        
        while (i < j) {
            int length = j - i, breadth = Math.min(height[i], height[j]),
                    area = length * breadth;

            max = Math.max(area, max);
            
            if (height[i] < height[j])
                i++;
            else if (height[i] > height[j])
                j--;
            else {
                i++; j--;
            }
        }
        
        return max;
    }
       
    public static void main(String[] args) {
        _11_ContainerWithMostWater solution = new _11_ContainerWithMostWater();
        
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(nums));
    }
    
            
}
