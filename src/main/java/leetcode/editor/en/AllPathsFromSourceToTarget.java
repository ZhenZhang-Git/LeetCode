package leetcode.editor.en;

//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find 
//all possible paths from node 0 to node n - 1 and return them in any order. 
//
// The graph is given as follows: graph[i] is a list of all nodes you can visit 
//from node i (i.e., there is a directed edge from node i to node graph[i][j]). 
//
// 
// Example 1: 
// 
// 
//Input: graph = [[1,2],[3],[3],[]]
//Output: [[0,1,3],[0,2,3]]
//Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// 
//
// Example 2: 
// 
// 
//Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
// Constraints: 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i (i.e., there will be no self-loops). 
// All the elements of graph[i] are unique. 
// The input graph is guaranteed to be a DAG. 
// 
//
// Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍 
//4996 👎 120

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();

            traverse(graph, 0, path);

            return res;
        }

        void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            path.add(s);

            if (s == graph.length - 1) {
                res.add(new LinkedList<>(path));
            }

            for (int i : graph[s]) {
                traverse(graph, i, path);
            }

            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}