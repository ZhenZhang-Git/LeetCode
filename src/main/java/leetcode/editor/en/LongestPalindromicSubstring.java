package leetcode.editor.en;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 20356 👎 1169

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("aaaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }
            int maxLength = 1, maxi = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int length = 2; length <= s.length(); length++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + length - 1;
                    if (j >= s.length()) {
                        break;
                    }
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (length <= 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        maxi = i;
                    }
                }
            }

            return s.substring(maxi, maxi + maxLength);
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}