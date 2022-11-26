package leetcode.editor.en;

//There is a car with capacity empty seats. The vehicle only drives east (i.e., 
//it cannot turn around and drive west). 
//
// You are given the integer capacity and an array trips where trips[i] = [
//numPassengersi, fromi, toi] indicates that the iᵗʰ trip has numPassengersi 
//passengers and the locations to pick them up and drop them off are fromi and toi 
//respectively. The locations are given as the number of kilometers due east from the 
//car's initial location. 
//
// Return true if it is possible to pick up and drop off all passengers for all 
//the given trips, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
// 
//
// Example 2: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics Array Sorting Heap (Priority Queue) Simulation Prefix Sum 👍 3
//523 👎 75

public class CarPooling {
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] nums = new int[1001];
            Different diff = new Different(nums);

            for (int[] trip : trips) {
                int val = trip[0];
                int i = trip[1];
                int j = trip[2] - 1;

                diff.increase(i, j, val);
            }

            int[] res = diff.result();

            for (int re : res) {
                if (capacity < re) {
                    return false;
                }
            }

            return true;
        }

        class Different {
            private int[] diff;

            public Different(int[] nums) {
                diff = new int[nums.length];

                diff[0] = nums[0];
                for (int i = 1; i < diff.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            public void increase(int i, int j, int val) {
                diff[i] += val;
                if (j + 1 < diff.length) {
                    diff[j + 1] -= val;
                }
            }

            public int[] result() {
                int[] res = new int[diff.length];

                res[0] = diff[0];
                for (int i = 1; i < diff.length; i++) {
                    res[i] = res[i - 1] + diff[i];
                }

                return res;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}