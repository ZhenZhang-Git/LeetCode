package leetcode.editor.en;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming 👍 6503 👎 119
 */
public class CoinChangeIi {
    public static void main(String[] args) {
        Solution solution = new CoinChangeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i] >= 0) {
                        dp[j] = dp[j] + dp[j - coins[i]];
                    }
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
    