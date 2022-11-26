package leetcode.editor.en;

//<p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" /> 
//<pre>
//<strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
//<strong>Output:</strong> [1,4,3,2,5]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = [5], left = 1, right = 1
//<strong>Output:</strong> [5]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li>The number of nodes in the list is <code>n</code>.</li> 
// <li><code>1 &lt;= n &lt;= 500</code></li> 
// <li><code>-500 &lt;= Node.val &lt;= 500</code></li> 
// <li><code>1 &lt;= left &lt;= right &lt;= n</code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> Could you do it in one pass?
//
//<div><div>Related Topics</div><div><li>Linked List</li></div></div><br><div><li>👍 7673</li><li>👎 335</li></div>
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseBeginningNodes(head, right);
            }
            head.next = reverseBetween(head.next, --left, --right);
            return head;
        }

        ListNode successor = null;

        private ListNode reverseBeginningNodes(ListNode head, int right) {
            if (right == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseBeginningNodes(head.next, right - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}