package leetcode.editor.en;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left
 * to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming Matrix 👍 9043 👎 117
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(grid, m - 1, n - 1);
        }

        public int dp(int[][] grid, int i, int j) {
            if (i == 0 && j == 0) {
                return grid[0][0];
            }
            if (i < 0 || j < 0) {
                return Integer.MAX_VALUE;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];

            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
    