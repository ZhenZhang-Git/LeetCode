package leetcode.editor.en;

//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 11998 👎 564

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("AB", "A"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            }

            int left = 0, right = 0, count = 0, start = 0, len = Integer.MAX_VALUE;

            while (right < s.length()) {
                char charRight = s.charAt(right++);
                window.put(charRight, window.getOrDefault(charRight, 0) + 1);

                if (Objects.equals(need.get(charRight), window.get(charRight))) {
                    count++;
                }

                while (count == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    char charLeft = s.charAt(left++);

                    if (Objects.equals(need.get(charLeft), window.get(charLeft))) {
                        count--;
                    }

                    window.put(charLeft, window.get(charLeft) - 1);
                }
            }

            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}