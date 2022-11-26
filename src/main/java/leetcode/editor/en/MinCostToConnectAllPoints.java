package leetcode.editor.en;

//You are given an array points representing integer coordinates of some points 
//on a 2D-plane, where points[i] = [xi, yi]. 
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan 
//distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute 
//value of val. 
//
// Return the minimum cost to make all points connected. All points are 
//connected if there is exactly one simple path between any two points. 
//
// 
// Example 1: 
// 
// 
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation: 
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
// 
//
// Example 2: 
//
// 
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// All pairs (xi, yi) are distinct. 
// 
//
// Related Topics Array Union Find Minimum Spanning Tree 👍 2970 👎 79

import java.util.*;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            List<int[]>[] graph = buildGraph(n, points);

            return new Prim(graph).weightSum();
        }

        List<int[]>[] buildGraph(int n, int[][] points) {
            List<int[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    int weight = Math.abs(xi - xj) + Math.abs(yi - yj);

                    graph[i].add(new int[]{i, j, weight});
                    graph[j].add(new int[]{j, i, weight});
                }
            }

            return graph;
        }

        class Prim {
            private PriorityQueue<int[]> priorityQueue;
            private boolean[] inMST;
            private int weightSum = 0;
            private List<int[]>[] graph;

            public Prim(List<int[]>[] graph) {
                this.graph = graph;
                this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
                int n = graph.length;
                this.inMST = new boolean[n];

                inMST[0] = true;
                cut(0);

                while (!priorityQueue.isEmpty()) {
                    int[] edge = priorityQueue.poll();
                    int to = edge[1];
                    int weight = edge[2];
                    if (inMST[to]) {
                        continue;
                    }
                    weightSum += weight;
                    inMST[to] = true;
                    cut(to);
                }
            }

            private void cut(int s) {
                for (int[] edge : graph[s]) {
                    int to = edge[1];
                    if (inMST[to]) {
                        continue;
                    }
                    priorityQueue.offer(edge);
                }
            }

            public int weightSum() {
                return weightSum;
            }

            public boolean allConnected() {
                for (int i = 0; i < inMST.length; i++) {
                    if (!inMST[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}