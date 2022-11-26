package leetcode.editor.en;

//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics String Tree Depth-First Search Breadth-First Search Design 
//Binary Tree 👍 7658 👎 282

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        //Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        String SEP = ",";
        String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            serialize(root, stringBuilder);

            return stringBuilder.toString();
        }

        private void serialize(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                stringBuilder.append(NULL).append(SEP);
                return;
            }
            stringBuilder.append(root.val).append(SEP);
            serialize(root.left, stringBuilder);
            serialize(root.right, stringBuilder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            LinkedList<String> nodesString = new LinkedList<>(Arrays.asList(data.split(SEP)));

            return deserialize(nodesString);
        }

        private TreeNode deserialize(LinkedList<String> nodesString) {
            if (nodesString.isEmpty()) {
                return null;
            }

            String first = nodesString.remove();
            if (first.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(first));

            root.left = deserialize(nodesString);
            root.right = deserialize(nodesString);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}