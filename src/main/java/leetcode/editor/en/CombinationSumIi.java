package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (
 * target), find all unique combinations in candidates where the candidate numbers sum
 * to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * <p>
 * Related Topics Array Backtracking 👍 7379 👎 180
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);
            backtrack(candidates, 0, target);
            return res;
        }

        void backtrack(int[] nums, int start, int target) {
            if (trackSum == target) {
                res.add(new LinkedList<>(track));
                return;            }
            if (trackSum > target) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                trackSum += nums[i];
                backtrack(nums, i + 1, target);
                track.removeLast();
                trackSum -= nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 