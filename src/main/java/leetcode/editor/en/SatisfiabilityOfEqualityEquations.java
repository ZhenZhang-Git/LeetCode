package leetcode.editor.en;

//You are given an array of strings equations that represent relationships 
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
//
// Related Topics Array String Union Find Graph 👍 3064 👎 48

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);

            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    char x = equation.charAt(0);
                    char y = equation.charAt(3);
                    uf.union(x - 'a', y - 'a');
                }
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    char x = equation.charAt(0);
                    char y = equation.charAt(3);
                    if (uf.connected(x - 'a', y - 'a')) {
                        return false;
                    }
                }
            }

            return true;
        }

        class UF {
            private int count;
            private int[] parent;

            public UF(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                parent[rootP] = parent[rootQ];
                count--;
            }

            public boolean connected(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootP == rootQ;
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public int count() {
                return count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}