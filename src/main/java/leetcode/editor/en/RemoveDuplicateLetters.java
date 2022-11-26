package leetcode.editor.en;

//Given a string s, remove duplicate letters so that every letter appears once 
//and only once. You must make sure your result is the smallest in lexicographical 
//order among all possible results. 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// 
// Note: This question is the same as 1081: https://leetcode.com/problems/
//smallest-subsequence-of-distinct-characters/ 
//
// Related Topics String Stack Greedy Monotonic Stack 👍 5904 👎 380

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stack = new Stack<>();
            int[] count = new int[256];
            boolean[] inStack = new boolean[256];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }

            for (char c : s.toCharArray()) {
                count[c]--;
                if (inStack[c]) {
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > c) {
                    if (count[stack.peek()] == 0) {
                        break;
                    }
                    inStack[stack.pop()] = false;
                }
                stack.push(c);
                inStack[c] = true;
            }

            StringBuilder stringBuilder = new StringBuilder();

            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }

            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}