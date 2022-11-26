package leetcode.editor.en;

//You are given two integer arrays nums1 and nums2 both of the same length. The 
//advantage of nums1 with respect to nums2 is the number of indices i for which 
//nums1[i] > nums2[i]. 
//
// Return any permutation of nums1 that maximizes its advantage with respect to 
//nums2. 
//
// 
// Example 1: 
// Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//Output: [2,11,7,15]
// 
// Example 2: 
// Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//Output: [24,32,8,12]
// 
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics Array Greedy Sorting 👍 1333 👎 84

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
                return pair2[1] - pair1[1];
            });

            for (int i = 0; i < nums2.length; i++) {
                priorityQueue.offer(new int[]{i, nums2[i]});
            }

            Arrays.sort(nums1);

            int[] res = new int[nums1.length];
            int left = 0, right = nums1.length - 1;

            while (!priorityQueue.isEmpty()) {
                int[] pair = priorityQueue.poll();
                int i = pair[0], val = pair[1];

                if (val < nums1[right]) {
                    res[i] = nums1[right--];
                } else {
                    res[i] = nums1[left++];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}