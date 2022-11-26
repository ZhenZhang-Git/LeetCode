package leetcode.editor.en;

//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 8148 👎 320

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        private int count(int lo, int hi) {
            if (lo > hi) {
                return 1;
            }
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }

            int res = 0;
            //the root can be any value within lo and hi
            for (int mid = lo; mid <= hi; mid++) {
                int left = count(lo, mid - 1);
                int right = count(mid + 1, hi);
                res += left * right;
            }
            memo[lo][hi] = res;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}