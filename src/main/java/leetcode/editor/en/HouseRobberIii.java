package leetcode.editor.en;
//The thief has found himself a new place for his thievery again. There is only 
//one entrance to this area, called root. 
//
// Besides the root, each house has one and only one parent house. After a tour,
// the smart thief realized that all houses in this place form a binary tree. It 
//will automatically contact the police if two directly-linked houses were broken 
//into on the same night. 
//
// Given the root of the binary tree, return the maximum amount of money the 
//thief can rob without alerting the police. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,2,3,null,3,null,1]
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,4,5,1,3,null,1]
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 728
//0 👎 110

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    class Solution {
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            int rob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
            int notRob = rob(root.left) + rob(root.right);

            int res = Math.max(rob, notRob);
            memo.put(root, res);
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 