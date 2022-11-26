package leetcode.editor.en;

//You are given a network of n nodes, labeled from 1 to n. You are also given 
//times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui 
//is the source node, vi is the target node, and wi is the time it takes for a 
//signal to travel from source to target. 
//
// We will send a signal from a given node k. Return the minimum time it takes 
//for all the n nodes to receive the signal. If it is impossible for all the n 
//nodes to receive the signal, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority 
//Queue) Shortest Path 👍 5597 👎 318

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = new LinkedList[n + 1];
            graph = buildGraph(times, n);

            int[] distTo = dijkstra(k, graph);

            int res = 0;
            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Math.max(res, distTo[i]);
            }

            return res;
        }

        private List<int[]>[] buildGraph(int[][] times, int n) {
            List<int[]>[] graph = new LinkedList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                graph[from].add(new int[]{to, weight});
            }

            return graph;
        }

        class State {
            int id;
            int distFromStart;

            State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        int[] dijkstra(int start, List<int[]>[] graph) {
            int[] distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[start] = 0;

            Queue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value.distFromStart));
            priorityQueue.offer(new State(start, 0));

            while (!priorityQueue.isEmpty()) {
                State curState = priorityQueue.poll();
                int curNodeId = curState.id;
                int curDistFromStart = curState.distFromStart;

                if (curDistFromStart > distTo[curNodeId]) {
                    continue;
                }

                for (int[] neighbor : graph[curNodeId]) {
                    int nextNodeId = neighbor[0];
                    int distToNextNode = distTo[curNodeId] + neighbor[1];

                    if (distTo[nextNodeId] > distToNextNode) {
                        distTo[nextNodeId] = distToNextNode;
                        priorityQueue.offer(new State(nextNodeId, distToNextNode));
                    }
                }
            }

            return distTo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}