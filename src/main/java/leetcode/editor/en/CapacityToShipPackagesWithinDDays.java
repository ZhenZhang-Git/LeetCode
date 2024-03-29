package leetcode.editor.en;
//A conveyor belt has packages that must be shipped from one port to another 
//within days days. 
//
// The iᵗʰ package on the conveyor belt has a weight of weights[i]. Each day, 
//we load the ship with packages on the conveyor belt (in the order given by 
//weights). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the 
//packages on the conveyor belt being shipped within days days. 
//
// 
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 
//5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of 
//capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed.
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], days = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3
// days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= days <= weights.length <= 5 * 10⁴ 
// 1 <= weights[i] <= 500 
// 
//
// Related Topics Array Binary Search 👍 5668 👎 118

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int maxWeight = Arrays.stream(weights).max().orElse(0);
            int totalWeight = Arrays.stream(weights).sum();
            int left = maxWeight, right = totalWeight + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (feasible(weights, mid, days)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean feasible(int[] weights, int capacity, int days) {
            int currentLoad = 0, daysNeeded = 1;
            for (int weight : weights) {
                currentLoad += weight;
                if (currentLoad > capacity) {
                    currentLoad = weight;
                    daysNeeded++;
                }
            }

            return daysNeeded <= days;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 