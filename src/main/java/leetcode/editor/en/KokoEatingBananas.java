package leetcode.editor.en;
//Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has 
//piles[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
//chooses some pile of bananas and eats k bananas from that pile. If the pile has less 
//than k bananas, she eats all of them instead and will not eat any more bananas 
//during this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
//before the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h 
//hours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 5667 👎 264

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = Arrays.stream(piles).max().orElse(0);
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (feasible(piles, mid, h)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean feasible(int[] piles, int target, int k) {
            int count = 0;
            for (int num : piles) {
                count += num % target == 0 ? num / target : num / target + 1;
            }

            return count <= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 