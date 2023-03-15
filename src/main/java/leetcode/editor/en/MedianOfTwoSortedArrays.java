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
            int midIndex1 = (nums1.length + nums2.length) / 2 - 1;
            int midIndex2 = (nums1.length + nums2.length) / 2;
            double median = FindKth(nums1, 0, nums2, 0, midIndex2 + 1);
            if ((nums1.length + nums2.length) % 2 == 0) {
                median = (median + FindKth(nums1, 0, nums2, 0, midIndex1 + 1)) / 2.0;
            }
            return median;
        }

        private int FindKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
            if (index1 >= nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 >= nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                return FindKth(nums1, newIndex1 + 1, nums2, index2, k - (newIndex1 - index1 + 1));
            } else {
                return FindKth(nums1, index1, nums2, newIndex2 + 1, k - (newIndex2 - index2 + 1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}