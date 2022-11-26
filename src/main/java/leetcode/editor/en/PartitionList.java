package leetcode.editor.en;

//<p>Given the <code>head</code> of a linked list and a value <code>x</code>, partition it such that all nodes <strong>less than</strong> <code>x</code> come before nodes <strong>greater than or equal</strong> to <code>x</code>.</p>
//
//<p>You should <strong>preserve</strong> the original relative order of the nodes in each of the two partitions.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" style="width: 662px; height: 222px;" /> 
//<pre>
//<strong>Input:</strong> head = [1,4,3,2,5,2], x = 3
//<strong>Output:</strong> [1,2,2,4,3,5]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = [2,1], x = 2
//<strong>Output:</strong> [1,2]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li>The number of nodes in the list is in the range <code>[0, 200]</code>.</li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
// <li><code>-200 &lt;= x &lt;= 200</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>Linked List</li><li>Two Pointers</li></div></div><br><div><li>👍 4684</li><li>👎 566</li></div>
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lower = new ListNode();
            ListNode higher = new ListNode();
            ListNode plow = lower;
            ListNode phigh = higher;
            ListNode p = head;

            while (p != null) {
                if (p.val < x) {
                    plow.next = p;
                    plow = plow.next;
                } else {
                    phigh.next = p;
                    phigh = phigh.next;
                }
                p = p.next;
            }

            phigh.next = null;
            plow.next = higher.next;

            return lower.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}