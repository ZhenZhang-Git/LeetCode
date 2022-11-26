package leetcode.editor.en;

//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 11589 👎 376

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class MonotonicQueue {
            LinkedList<Integer> maxq = new LinkedList<>();

            public void push(int n) {
                while (!maxq.isEmpty() && maxq.getLast() < n) {
                    maxq.pollLast();
                }
                maxq.addLast(n);
            }

            public int max() {
                return maxq.getFirst();
            }

            public void pop(int n) {
                if (n == maxq.getFirst()) {
                    maxq.pollFirst();
                }
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    window.push(nums[i]);
                } else {
                    window.push(nums[i]);
                    res.add(window.max());
                    window.pop(nums[i - k + 1]);
                }
            }
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}