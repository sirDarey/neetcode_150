package neetcode_150;

/**
 *
 * @Sir Darey
 */
public class _4_MedianTwoSortedArrays {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = N2 * 2;
        while (true) {
            int mid2 = (left + right)/2;
            int mid1 = N1 + N2 - mid2;
            
            double L1 = (mid1 == 0)? Integer.MIN_VALUE : nums1[(mid1-1)/2],
                   L2 = (mid2 == 0)? Integer.MIN_VALUE : nums2[(mid2-1)/2],
                   R1 = (mid1 == N1*2)? Integer.MAX_VALUE : nums1[(mid1)/2],
                   R2 = (mid2 == N2*2)? Integer.MAX_VALUE : nums2[(mid2)/2];
            
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2))/2;
        }           
    }
    
}
