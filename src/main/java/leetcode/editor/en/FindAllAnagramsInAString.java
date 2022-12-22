package leetcode.editor.en;

//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 8535 👎 269

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < p.length(); i++) {
                need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
            }

            int left = 0, right = 0, valid = 0;

            while (right < s.length()) {
                char charRight = s.charAt(right++);
                window.put(charRight, window.getOrDefault(charRight, 0) + 1);
                if (need.containsKey(charRight)) {
                    if (need.get(charRight).equals(window.get(charRight))) {
                        valid++;
                    }
                }

                while (right - left >= p.length()) {
                    if (valid == need.size()) {
                        result.add(left);
                    }

                    char charLeft = s.charAt(left++);

                    if (need.containsKey(charLeft)) {
                        if (need.get(charLeft).equals(window.get(charLeft))) {
                            valid--;
                        }
                    }
                    window.put(charLeft, window.get(charLeft) - 1);
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}