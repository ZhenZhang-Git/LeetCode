package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//<p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>
//
//<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>
//
//<p>You can return the answer in any order.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,7,11,15], target = 9
//<strong>Output:</strong> [0,1]
//<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [3,2,4], target = 6
//<strong>Output:</strong> [1,2]
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [3,3], target = 6
//<strong>Output:</strong> [0,1]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
// <li><strong>Only one valid answer exists.</strong></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than&nbsp;
//<code>O(n<sup>2</sup>)&nbsp;</code>time complexity?
//
//<div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li></div></div><br><div><li>👍 43394</li><li>👎 1420</li></div>
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{i, hashMap.get(target - nums[i])};
                }
                hashMap.put(nums[i], i);
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 