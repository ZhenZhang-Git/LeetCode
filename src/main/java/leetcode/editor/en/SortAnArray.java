package leetcode.editor.en;

//Given an array of integers nums, sort the array in ascending order and return 
//it. 
//
// You must solve the problem without using any built-in functions in O(nlog(n))
// time complexity and with the smallest space complexity possible. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
//Explanation: After sorting the array, the positions of some numbers are not 
//changed (for example, 2 and 3), while the positions of other numbers are changed (
//for example, 1 and 5).
// 
//
// Example 2: 
//
// 
//Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
//Explanation: Note that the values of nums are not necessairly unique.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge 
//Sort Bucket Sort Radix Sort Counting Sort 👍 2723 👎 568

import com.sun.scenario.effect.Merge;

import java.util.Random;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            Quick quick = new Quick();
            quick.sort(nums);
            return nums;
        }
    }

    class Quick {
        public void sort(int[] nums) {
            shuffle(nums);
            sort(nums, 0, nums.length - 1);
        }

        public void sort(int[] nums, int lo, int hi) {
            if (lo >= hi) {
                return;
            }
            int p = partition(nums, lo, hi);
            sort(nums, lo, p - 1);
            sort(nums, p + 1, hi);
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