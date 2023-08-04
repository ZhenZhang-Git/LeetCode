package leetcode.editor.en;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 11915 👎 735

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            StringBuilder track = new StringBuilder();

            if (digits.isEmpty()) {
                return result;
            }

            backTracking(result,track,digits);

            return result;
        }

        private void backTracking(List<String> result,StringBuilder track,String digits) {
            String[] digitLettersArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            if (track.length() == digits.length()) {
                result.add(track.toString());
                return;
            }

            String digitString = digitLettersArray[Character.getNumericValue(digits.charAt(track.length()))];
            for (int i = 0; i < digitString.length(); i++) {
                track.append(digitString.charAt(i));
                backTracking(result,track,digits);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}