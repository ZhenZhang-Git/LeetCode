package leetcode.editor.en;
//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics Array Matrix Simulation 👍 4474 👎 201

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int left = 0, right = n - 1;
            int top = 0, down = n - 1;
            int count = 1;
            while (left < right) {
                for (int i = left; i < right; i++) {
                    matrix[top][i] = count++;
                }
                for (int i = top; i < down; i++) {
                    matrix[i][right] = count++;
                }
                for (int i = right; i > left; i--) {
                    matrix[down][i] = count++;
                }
                for (int i = down; i > top; i--) {
                    matrix[i][left] = count++;
                }
                top++;
                right--;
                down--;
                left++;
            }
            if (left == right)
                matrix[left][top] = n * n;
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 