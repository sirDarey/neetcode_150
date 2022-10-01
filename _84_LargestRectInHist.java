package neetcode_150;

import java.util.Stack;

/**
 *
 * @Sir Darey
 */
public class _84_LargestRectInHist {
    
    public int largestRectangleArea(int[] heights) {
        int max = -1, n = heights.length;
        int [] lessFromLeft = new int [n], 
               lessFromRight = new int [n];
        
        lessFromLeft[0] = -1;
        lessFromRight[n-1] = n;
        
        for (int i=1; i<n; i++) {
            int j = i-1;
            
            while (j >= 0 && heights[j] >= heights[i])
                j = lessFromLeft[j];
            lessFromLeft[i] = j;
        }
        
        for (int i = n-2; i >= 0; i--) {
            int j = i+1;
            
            while (j < n && heights[j] >= heights[i])
                j = lessFromRight[j];
            lessFromRight[i] = j;
        }
        
        for (int i=0; i<n; i++) {
            max = Math.max(max, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }        
        
        return max;
    }
    
    public static void main(String[] args) {
        _84_LargestRectInHist solution = new _84_LargestRectInHist();
        
        int [] heights = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(heights));
    }
    
}
