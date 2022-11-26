package leetcode.editor.en;

//We want to split a group of n people (labeled from 1 to n) into two groups of 
//any size. Each person may dislike some other people, and they should not go 
//into the same group. 
//
// Given the integer n and the array dislikes where dislikes[i] = [ai, bi] 
//indicates that the person labeled ai does not like the person labeled bi, return 
//true if it is possible to split everyone into two groups in this way. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: group1 [1,4] and group2 [2,3].
// 
//
// Example 2: 
//
// 
//Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// All the pairs of dislikes are unique. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 27
//23 👎 60

import java.util.LinkedList;
import java.util.List;

public class PossibleBipartition {
    public static void main(String[] args) {
        //Solution solution = new PossibleBipartition().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean bipartite = true;
        private boolean[] color;
        private boolean[] visited;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            color = new boolean[n + 1];
            visited = new boolean[n + 1];

            List<Integer>[] graph = buildGraph(n, dislikes);

            for (int v = 1; v <= n; v++) {
                if (!visited[v]) {
                    traverse(graph, v);
                }
            }

            return bipartite;
        }

        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            List<Integer>[] graph = new LinkedList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : dislikes) {
                int v = edge[1];
                int w = edge[0];
                graph[v].add(w);
                graph[w].add(v);
            }

            return graph;
        }

        private void traverse(List<Integer>[] graph, int v) {
            if (!bipartite) {
                return;
            }
            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    color[w] = !color[v];
                    traverse(graph, w);
                } else {
                    if (color[w] == color[v]) {
                        bipartite = false;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}