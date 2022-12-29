package leetcode.editor.en;

//You are given a 0-indexed array of positive integers w where w[i] describes 
//the weight of the iᵗʰ index. 
//
// You need to implement the function pickIndex(), which randomly picks an 
//index in the range [0, w.length - 1] (inclusive) and returns it. The probability of 
//picking an index i is w[i] / sum(w). 
//
// 
// For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3)
// = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.7
//5 (i.e., 75%). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution","pickIndex"]
//[[[1]],[]]
//Output
//[null,0]
//
//Explanation
//Solution solution = new Solution([1]);
//solution.pickIndex(); // return 0. The only option is to return 0 since there 
//is only one element in w.
// 
//
// Example 2: 
//
// 
//Input
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//Output
//[null,1,1,1,1,0]
//
//Explanation
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // return 1. It is returning the second element (index =
// 1) that has a probability of 3/4.
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 1
//solution.pickIndex(); // return 0. It is returning the first element (index = 
//0) that has a probability of 1/4.
//
//Since this is a randomization problem, multiple answers are allowed.
//All of the following outputs can be considered correct:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//and so on.
// 
//
// 
// Constraints: 
//
// 
// 1 <= w.length <= 10⁴ 
// 1 <= w[i] <= 10⁵ 
// pickIndex will be called at most 10⁴ times. 
// 
//
// Related Topics Math Binary Search Prefix Sum Randomized 👍 1053 👎 464

import java.util.Random;

public class RandomPickWithWeight {
    public static void main(String[] args) {
        //Solution solution = new RandomPickWithWeight().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] preSum;
        private Random random;

        public Solution(int[] w) {
            preSum = new int[w.length + 1];
            preSum[0] = 0;

            for (int i = 1; i <= w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
            random = new Random();
        }

        public int pickIndex() {
            int target = random.nextInt(preSum[preSum.length - 1]) + 1;

            return left_boundBiSearch(preSum, target) - 1;
        }

        private int left_boundBiSearch(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}