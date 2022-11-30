package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * <p>
 * <p>
 * Related Topics Array Backtracking 👍 13846 👎 228
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                track.addLast(nums[i]);
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 