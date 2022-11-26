package leetcode.editor.en;

//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 7003 👎 227

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            }

            int left = 0, right = 0, valid = 0;

            while (right < s2.length()) {
                char charRight = s2.charAt(right++);

                if (need.containsKey(charRight)) {
                    window.put(charRight, window.getOrDefault(charRight, 0) + 1);

                    if (need.get(charRight).equals(window.get(charRight))) {
                        valid++;
                    }
                }

                while (right - left >= s1.length()) {
                    if (valid == need.size()) {
                        return true;
                    }

                    char charLeft = s2.charAt(left++);

                    if (need.containsKey(charLeft)) {
                        if (need.get(charLeft).equals(window.get(charLeft))) {
                            valid--;
                        }
                        window.put(charLeft, window.get(charLeft) - 1);
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}