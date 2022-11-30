package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to
 * be the same combination.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * Related Topics Backtracking 👍 5375 👎 169
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return res;
        }

        void backtrack(int start, int n, int k) {
            if (k == track.size()) {
                res.add(new LinkedList<>(track));
            }

            for (int i = start; i <= n; i++) {
                track.addLast(i);
                backtrack(i + 1, n, k);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 