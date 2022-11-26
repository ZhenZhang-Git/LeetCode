package leetcode.editor.en;

//Design your implementation of the circular double-ended queue (deque). 
//
// Implement the MyCircularDeque class: 
//
// 
// MyCircularDeque(int k) Initializes the deque with a maximum size of k. 
// boolean insertFront() Adds an item at the front of Deque. Returns true if 
//the operation is successful, or false otherwise. 
// boolean insertLast() Adds an item at the rear of Deque. Returns true if the 
//operation is successful, or false otherwise. 
// boolean deleteFront() Deletes an item from the front of Deque. Returns true 
//if the operation is successful, or false otherwise. 
// boolean deleteLast() Deletes an item from the rear of Deque. Returns true if 
//the operation is successful, or false otherwise. 
// int getFront() Returns the front item from the Deque. Returns -1 if the 
//deque is empty. 
// int getRear() Returns the last item from Deque. Returns -1 if the deque is 
//empty. 
// boolean isEmpty() Returns true if the deque is empty, or false otherwise. 
// boolean isFull() Returns true if the deque is full, or false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//Output
//[null, true, true, true, false, 2, true, true, true, 4]
//
//Explanation
//MyCircularDeque myCircularDeque = new MyCircularDeque(3);
//myCircularDeque.insertLast(1);  // return True
//myCircularDeque.insertLast(2);  // return True
//myCircularDeque.insertFront(3); // return True
//myCircularDeque.insertFront(4); // return False, the queue is full.
//myCircularDeque.getRear();      // return 2
//myCircularDeque.isFull();       // return True
//myCircularDeque.deleteLast();   // return True
//myCircularDeque.insertFront(4); // return True
//myCircularDeque.getFront();     // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// At most 2000 calls will be made to insertFront, insertLast, deleteFront, 
//deleteLast, getFront, getRear, isEmpty, isFull. 
// 
//
// Related Topics Array Linked List Design Queue 👍 786 👎 62

public class DesignCircularDeque {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        int size;
        int k;
        DoubleListNode head;
        DoubleListNode tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            head = new DoubleListNode(-1);
            tail = new DoubleListNode(-1);
            head.pre = tail;
            tail.next = head;
            this.k = k;
            this.size = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (size == k) {
                return false;
            }
            DoubleListNode node = new DoubleListNode(value);
            node.next = head;
            node.pre = head.pre;
            head.pre.next = node;
            head.pre = node;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (size == k) {
                return false;
            }
            DoubleListNode node = new DoubleListNode(value);
            node.next = tail.next;
            tail.next.pre = node;
            tail.next = node;
            node.pre = tail;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            tail.next.next.pre = tail;
            tail.next = tail.next.next;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return head.pre.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return tail.next.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == k;
        }
    }

    class DoubleListNode {
        DoubleListNode pre;
        DoubleListNode next;
        int val;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}