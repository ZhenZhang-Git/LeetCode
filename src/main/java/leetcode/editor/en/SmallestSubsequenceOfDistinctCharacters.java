package leetcode.editor.en;
//Given a string s, return the lexicographically smallest subsequence of s that 
//contains all the distinct characters of s exactly once. 
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
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
//
// 
//Note: This question is the same as 316: 
//https://leetcode.com/problems/remove-duplicate-letters/
//
// Related Topics String Stack Greedy Monotonic Stack 👍 2024 👎 162

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args){
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();}
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {
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