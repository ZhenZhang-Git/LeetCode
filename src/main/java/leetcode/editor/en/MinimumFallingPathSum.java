package leetcode.editor.en;

//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics Array Dynamic Programming Matrix 👍 3191 👎 100

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int res = Integer.MAX_VALUE;
            memo = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], 10001);
            }
            for (int j = 0; j < n; j++) {
                res = Math.min(res, dp(matrix, n - 1, j));
            }
            return res;
        }

        int dp(int[][] matrix, int i, int j) {
            if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
                return 10001;
            }
            if (i == 0) {
                return matrix[0][j];
            }
            if (memo[i][j] != 10001) {
                return memo[i][j];
            }
            memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
            return memo[i][j];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}