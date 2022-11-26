package leetcode.editor.en;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 13568 👎 338

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];

            int leftBound = searchLeftBound(nums, target);
            int rightBound = searchRightBound(nums, target);

            result[0] = leftBound;
            result[1] = rightBound;

            return result;
        }

        private int searchLeftBound(int[] nums, int target) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            if (left == nums.length) {
                return -1;
            }

            return nums[left] == target ? left : -1;
        }

        private int searchRightBound(int[] nums, int target) {
            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            if (right - 1 < 0) {
                return -1;
            }

            return nums[right - 1] == target ? right - 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}