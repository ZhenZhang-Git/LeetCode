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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
            list.addAll(Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new)));
            double res = 0;
            Collections.sort(list);
            int sumLength = nums1.length + nums2.length;
            if (sumLength % 2 != 0) {
                int mid = sumLength / 2;
                res = Double.valueOf(list.get(mid));
            }
            if (sumLength % 2 == 0) {
                int mid1 = sumLength / 2 - 1;
                int mid2 = sumLength / 2;
                res = (Double.valueOf(list.get(mid1)) + Double.valueOf(list.get(mid2))) / 2;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}