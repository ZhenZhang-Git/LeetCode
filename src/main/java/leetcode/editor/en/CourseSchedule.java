package leetcode.editor.en;

//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 11385 👎 441

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = bulidGraph(numCourses, prerequisites);

            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];

                indegree[to]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                for (Integer next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            return count == numCourses;
        }

        List<Integer>[] bulidGraph(int numCoureses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCoureses];

            for (int i = 0; i < numCoureses; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];

                graph[from].add(to);
            }

            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}