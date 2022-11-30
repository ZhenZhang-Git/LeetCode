package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (
 * the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * <p>
 * <p>
 * Related Topics Array Backtracking Bit Manipulation 👍 12834 👎 182
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backTrack(nums, 0);
            return res;
        }

        void backTrack(int[] nums, int start) {
            res.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                track.addLast(nums[i]);
                backTrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 