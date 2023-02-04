package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>
 *
 * <p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>Each solution contains a distinct board configuration of the n-queens' placement, where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space, respectively.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * <strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [["Q"]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 9</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Backtracking</li></div></div><br><div><li>👍 9311</li><li>👎 205</li></div>
 */
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] row : board) {
                Arrays.fill(row, '.');
            }
            backtrack(board, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(Arrays.stream(board).map(String::valueOf).collect(Collectors.toList()));
                return;
            }
            for (int col = 0; col < board[row].length; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            int n = board.length;
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 