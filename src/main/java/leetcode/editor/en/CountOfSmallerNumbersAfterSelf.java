package leetcode.editor.en;

//Given an integer array nums, return an integer array counts where counts[i] 
//is the number of smaller elements to the right of nums[i]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,-1]
//Output: [0,0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 7470 👎 201

import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Pair {
            int val;
            int index;

            Pair(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        private Pair[] temp;
        private int[] countLessToTheRight;


        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            countLessToTheRight = new int[n];
            temp = new Pair[n];
            Pair[] arr = new Pair[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(nums[i], i);
            }

            sort(arr, 0, n - 1);

            List<Integer> res = new LinkedList<>();
            for (int c : countLessToTheRight) {
                res.add(c);
            }
            return res;
        }

        private void sort(Pair[] arr, int low, int high) {
            if (low == high) {
                return;
            }
            int mid = low + (high - low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

        private void merge(Pair[] arr, int low, int mid, int high) {
            for (int i = low; i <= high; i++) {
                temp[i] = arr[i];
            }

            int i = low, j = mid + 1;
            for (int p = low; p <= high; p++) {
                if (i == mid + 1) {
                    arr[p] = temp[j++];
                } else if (j == high + 1) {
                    arr[p] = temp[i++];
                    countLessToTheRight[arr[p].index] += j - mid - 1;
                } else if (temp[i].val > temp[j].val) {
                    arr[p] = temp[j++];
                } else {
                    arr[p] = temp[i++];
                    countLessToTheRight[arr[p].index] += j - mid - 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}