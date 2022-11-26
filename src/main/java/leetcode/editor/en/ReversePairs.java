package leetcode.editor.en;

//Given an integer array nums, return the number of reverse pairs in the array. 
//
//
// A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 
//2 * nums[j]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,2,3,1]
//Output: 2
//Explanation: The reverse pairs are:
//(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
//(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,3,5,1]
//Output: 3
//Explanation: The reverse pairs are:
//(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
//(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
//(3, 4) --> nums[3] = 3, nums[4] = 1, 5 > 2 * 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 3864 👎 205

public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            sort(nums);
            return count;
        }

        private int[] temp;

        private void sort(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
        }

        private void sort(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }

        private int count = 0;

        private void merge(int[] nums, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            int end = mid + 1;
            for (int i = lo; i <= mid; i++) {
                while (end <= hi && (long) nums[i] > (long) nums[end] * 2) {
                    end++;
                }
                count += end - (mid + 1);
            }

            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    nums[p] = temp[j++];
                } else if (j == hi + 1) {
                    nums[p] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[p] = temp[j++];
                } else {
                    nums[p] = temp[i++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}