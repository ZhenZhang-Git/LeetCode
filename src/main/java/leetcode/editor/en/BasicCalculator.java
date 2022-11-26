package leetcode.editor.en;

//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
//
// Related Topics Math String Stack Recursion 👍 3940 👎 311

import sun.nio.ch.SelectorImpl;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        solution.calculate(" 2-1 + 2 ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);                          // Always keep most recent sum at top

            for (int i = 0, sign = 1; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int num = s.charAt(i) - '0';    // Be aware of outer loop boundary and i++
                    for (; i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)); i++) {
                        num = num * 10 + (s.charAt(i + 1) - '0');
                    }
                    stack.push(stack.pop() + sign * num);
                } else if (s.charAt(i) == '+') {
                    sign = 1;
                } else if (s.charAt(i) == '-') {
                    sign = -1;
                } else if (s.charAt(i) == '(') {
                    stack.push(sign);
                    stack.push(0);   //result in the parenthesis
                    sign = 1;  //new sign in the parenthesis
                } else if (s.charAt(i) == ')') {    // Update last sum = current sum * sign
                    stack.push(stack.pop() * stack.pop() + stack.pop());
                } /* else whitespace*/
            }

            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}