package leetcode.editor.en;

//Given an integer array nums and two integers lower and upper, return the 
//number of range sums that lie in [lower, upper] inclusive. 
//
// Range sum S(i, j) is defined as the sum of the elements in nums between 
//indices i and j inclusive, where i <= j. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,5,-1], lower = -2, upper = 2
//Output: 3
//Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their 
//respective sums are: -2, -1, 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [0], lower = 0, upper = 0
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// -10⁵ <= lower <= upper <= 10⁵ 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
//
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 1781 👎 190

public class CountOfRangeSum{
    public static void main(String[] args) {
        Solution solution = new CountOfRangeSum().new Solution();
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        // 构建前缀和数组，注意 int 可能溢出，用 long 存储
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = (long)nums[i] + preSum[i];
        }
        // 对前缀和数组进行归并排序
        sort(preSum);
        return count;
    }

    private long[] temp;

    public void sort(long[] nums) {
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private int count = 0;

    private void merge(long[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // this code section will time out
        // for (int i = lo; i <= mid; i++) {
        //     for (int j = mid + 1; j <= hi; k++) {
        //         long delta = nums[j] - nums[i];
        //         if (delta <= upper && delta >= lower) {
        //             count++;
        //         }
        //     }
        // }

        // maintain that the sum of elements in [start, end) minus nums[i] is located within [lower, upper]
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && nums[start] - nums[i] < lower) {
                start++;
            }
            while (end <= hi && nums[end] - nums[i] <= upper) {
                end++;
            }
            count += end - start;
        }

        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}