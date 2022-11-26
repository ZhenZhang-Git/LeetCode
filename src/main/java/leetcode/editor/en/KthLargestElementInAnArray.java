package leetcode.editor.en;

//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 11892 👎 604

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            shuffle(nums);
            int lo = 0, hi = nums.length - 1;
            k = nums.length - k;

            while (lo <= hi) {
                int p = partition(nums, lo, hi);

                if (p < k) {
                    lo = p + 1;
                } else if (p > k) {
                    hi = p - 1;
                } else {
                    return nums[p];
                }
            }

            return -1;
        }

        private int partition(int[] nums, int lo, int hi) {
            int pivot = nums[lo];
            //[Lo,i)<=pivot,(j,hi]>pivot;
            int i = lo + 1, j = hi;

            while (i <= j) {
                while (i < hi && nums[i] <= pivot) {
                    i++;
                }
                while (j > lo && nums[j] > pivot) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            //because nums[j] is lower than pivot so swap it with lo
            swap(nums, lo, j);
            return j;
        }

        private void shuffle(int[] nums) {
            Random rand = new Random();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int r = i + rand.nextInt(n - i);
                swap(nums, i, r);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}