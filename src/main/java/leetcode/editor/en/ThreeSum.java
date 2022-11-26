package leetcode.editor.en;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 20085 👎 1900

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            return nSum(nums, 3, 0, 0);
        }

        public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();

            if (n < 2 || nums.length < n) {
                return res;
            }

            if (n == 2) {
                int left = start, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    int leftNum = nums[left], rightNum = nums[right];

                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));

                        while (left < right && nums[left] == leftNum) {
                            left++;
                        }
                        while (left < right && nums[right] == rightNum) {
                            right--;
                        }
                    } else if (sum < target) {
                        while (left < right && nums[left] == leftNum) {
                            left++;
                        }
                    } else if (sum > target) {
                        while (left < right && nums[right] == rightNum) {
                            right--;
                        }
                    }
                }
            } else {
                for (int i = start; i < nums.length; i++) {
                    List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);

                    for (List<Integer> arr : sub) {
                        arr.add(nums[i]);
                        res.add(arr);
                    }

                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}