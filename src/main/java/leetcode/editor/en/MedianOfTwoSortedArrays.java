package leetcode.editor.en;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics Array Binary Search Divide and Conquer 👍 18415 👎 2154

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int mid = (nums1.length + nums2.length) / 2;
            int median1 = 0;
            int median2 = 0;
            int p1 = 0, p2 = 0;
            for (int i = 0; i <= mid; i++) {
                median1 = median2;
                if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] < nums2[p2])) {
                    median2 = nums1[p1++];
                } else {
                    median2 = nums2[p2++];
                }
            }
            if (((nums1.length + nums2.length) % 2) == 0) {
                return (median1 + median2) / 2.0;
            } else {
                return median2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}