package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 * <p>
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * Related Topics String Dynamic Programming Backtracking 👍 16091 👎 627
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            StringBuilder track = new StringBuilder();
            backtrack(n, n, track, res);
            return res;
        }

        void backtrack(int left, int right, StringBuilder track, List<String> res) {
            if (right < left) {
                return;
            }
            if (left < 0 || right < 0) {
                return;
            }
            if (left == 0 && right == 0) {
                res.add(track.toString());
                return;
            }
            track.append("(");
            backtrack(left - 1, right, track, res);
            track.deleteCharAt(track.length() - 1);
            track.append(")");
            backtrack(left, right - 1, track, res);
            track.deleteCharAt(track.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 