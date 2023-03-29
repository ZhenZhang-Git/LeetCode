package leetcode.editor.en;

import java.util.HashMap;

//<p>Roman numerals are represented by seven different symbols:&nbsp;<code>I</code>, <code>V</code>, <code>X</code>, <code>L</code>, <code>C</code>, <code>D</code> and <code>M</code>.</p>
//
//<pre>
//<strong>Symbol</strong>       <strong>Value</strong>
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000</pre>
//
//<p>For example,&nbsp;<code>2</code> is written as <code>II</code>&nbsp;in Roman numeral, just two ones added together. <code>12</code> is written as&nbsp;<code>XII</code>, which is simply <code>X + II</code>. The number <code>27</code> is written as <code>XXVII</code>, which is <code>XX + V + II</code>.</p>
//
//<p>Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <code>IIII</code>. Instead, the number four is written as <code>IV</code>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as <code>IX</code>. There are six instances where subtraction is used:</p>
//
//<ul> 
// <li><code>I</code> can be placed before <code>V</code> (5) and <code>X</code> (10) to make 4 and 9.&nbsp;</li> 
// <li><code>X</code> can be placed before <code>L</code> (50) and <code>C</code> (100) to make 40 and 90.&nbsp;</li> 
// <li><code>C</code> can be placed before <code>D</code> (500) and <code>M</code> (1000) to make 400 and 900.</li> 
//</ul>
//
//<p>Given a roman numeral, convert it to an integer.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "III"
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> III = 3.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "LVIII"
//<strong>Output:</strong> 58
//<strong>Explanation:</strong> L = 50, V= 5, III = 3.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "MCMXCIV"
//<strong>Output:</strong> 1994
//<strong>Explanation:</strong> M = 1000, CM = 900, XC = 90 and IV = 4.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 15</code></li> 
// <li><code>s</code> contains only&nbsp;the characters <code>('I', 'V', 'X', 'L', 'C', 'D', 'M')</code>.</li> 
// <li>It is <strong>guaranteed</strong>&nbsp;that <code>s</code> is a valid roman numeral in the range <code>[1, 3999]</code>.</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>Hash Table</li><li>Math</li><li>String</li></div></div><br><div><li>👍 9723</li><li>👎 565</li></div>
public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            int sum = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    sum += 4;
                    i++;
                    continue;
                }
                if (s.charAt(i) == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    sum += 9;
                    i++;
                    continue;
                }
                if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    sum += 40;
                    i++;
                    continue;
                }
                if (s.charAt(i) == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    sum += 90;
                    i++;
                    continue;
                }
                if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    sum += 400;
                    i++;
                    continue;
                }
                if (s.charAt(i) == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    sum += 900;
                    i++;
                    continue;
                }
                sum += map.get(s.charAt(i));
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 