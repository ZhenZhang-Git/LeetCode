package leetcode.editor.en;

//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 
//'C', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the 
//DNA. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-
//long sequences (substrings) that occur more than once in a DNA molecule. You may 
//return the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// 
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
//
// Related Topics Hash Table String Bit Manipulation Sliding Window Rolling 
//Hash Hash Function 👍 2341 👎 436

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashSet<String> sequence = new HashSet<>();
            HashSet<String> res = new HashSet<>();

            for (int i = 0; i + 10 <= s.length(); i++) {
                String substring = s.substring(i, i + 10);
                if (sequence.contains(substring)) {
                    res.add(substring);
                } else {
                    sequence.add(substring);
                }
            }

            return new ArrayList<>(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}