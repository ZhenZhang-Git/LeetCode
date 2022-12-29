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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int[] nums = new int[s.length()];
            for (int i = 0; i < nums.length; i++) {
                switch (s.charAt(i)) {
                    case 'A':
                        nums[i] = 0;
                        break;
                    case 'C':
                        nums[i] = 1;
                        break;
                    case 'G':
                        nums[i] = 2;
                        break;
                    case 'T':
                        nums[i] = 3;
                        break;
                }
            }
            HashSet<Integer> seen = new HashSet<>();
            HashSet<String> res = new HashSet<>();
            int left = 0, right = 0, windowHash = 0;
            while (right < nums.length) {
                windowHash = 4 * windowHash + nums[right++];
                if (right - left == 10) {
                    if (seen.contains(windowHash)) {
                        res.add(s.substring(left, right));
                    } else {
                        seen.add(windowHash);
                    }
                    windowHash = windowHash - nums[left++] * (int) Math.pow(4, 9);
                }
            }
            return new LinkedList<>(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}