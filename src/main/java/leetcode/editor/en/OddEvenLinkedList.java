package leetcode.editor.en;

//Given the head of a singly linked list, group all the nodes with odd indices 
//together followed by the nodes with even indices, and return the reordered list. 
//
//
// The first node is considered odd, and the second node is even, and so on. 
//
// Note that the relative order inside both the even and odd groups should 
//remain as it was in the input. 
//
// You must solve the problem in O(1) extra space complexity and O(n) time 
//complexity. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
// 
//
// Example 2: 
// 
// 
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list is in the range [0, 10⁴]. 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics Linked List 👍 5950 👎 392

import java.util.List;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();

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
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode dummyOddHead = new ListNode(-1);
            ListNode dummyEvenHead = new ListNode(-1);
            ListNode preOdd = dummyOddHead;
            ListNode preEven = dummyEvenHead;

            ListNode p = head;
            int index = 1;

            while (p != null) {
                ListNode tmp = p.next;
                if (index % 2 == 1) {
                    preOdd.next = p;
                    preOdd = preOdd.next;
                } else {
                    preEven.next = p;
                    preEven = preEven.next;
                }
                index++;
                p = tmp;
            }

            preOdd.next = dummyEvenHead.next;
            preEven.next = null;

            return dummyOddHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}