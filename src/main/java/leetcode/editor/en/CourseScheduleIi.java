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
// Return the ordering of courses you should take to finish all courses. If 
//there are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you 
//should have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you 
//should have finished both courses 1 and 2. Both courses 1 and 2 should be taken 
//after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 7906 👎 266

import java.util.*;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
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

            int[] res = new int[numCourses];
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                res[count] = cur;
                count++;
                for (Integer next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            if (count != numCourses) {
                return new int[]{};
            }

            return res;
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