package leetcode.editor.en;

//Given two strings s1 and s2, return the lowest ASCII sum of deleted 
//characters to make two strings equal. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum 
//possible to achieve this.
// 
//
// Example 2: 
//
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers 
//of 433 or 417, which are higher.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 2290 👎 68

import java.util.Arrays;

public class MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStrings().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int memo[][];

        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s1, 0, s2, 0);
        }

        int dp(String s1, int i, String s2, int j) {
            int res = 0;
            if (i == s1.length()) {
                for (; j < s2.length(); j++) {
                    res += s2.charAt(j);
                }
                return res;
            }
            if (j == s2.length()) {
                for (; i < s1.length(); i++) {
                    res += s1.charAt(i);
                }
                return res;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i + 1, s2, j + 1);
            } else {
                memo[i][j] = Math.min(
                        s1.charAt(i) + dp(s1, i + 1, s2, j),
                        s2.charAt(j) + dp(s1, i, s2, j + 1)
                );
            }
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}