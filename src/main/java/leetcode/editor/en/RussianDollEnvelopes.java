package leetcode.editor.en;

//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 4725 👎 114
//

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes, (a, b) -> {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            });
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = envelopes[i][1];
            }
            return lengthOfLIS(height);
        }

        private int lengthOfLIS(int[] nums) {
            int[] top = new int[nums.length];
            int piles = 0;
            for (int i = 0; i < nums.length; i++) {
                int poker = nums[i];

                int left = 0, right = piles;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] > poker) {
                        right = mid;
                    } else if (top[mid] < poker) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left == piles) piles++;
                top[left] = poker;
            }
            return piles;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}