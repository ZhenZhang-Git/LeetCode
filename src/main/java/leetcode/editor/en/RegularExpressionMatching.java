package leetcode.editor.en;

//Given an input string s and a p p, implement regular expression 
//matching with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a 
//previous valid character to match. 
// 
//
// Related Topics String Dynamic Programming Recursion 👍 8856 👎 1384

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[s.length()][p.length()] = true;

            for (int i = s.length(); i >= 0; i--) {
                for (int j = p.length() - 1; j >= 0; j--) {
                    boolean firstMatch = (i < s.length() &&
                            (p.charAt(j) == s.charAt(i) ||
                                    p.charAt(j) == '.'));
                    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                    } else {
                        dp[i][j] = firstMatch && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

