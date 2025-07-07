package blind75Sheet.breadthFirstSearch;

import java.util.*;

/**
 * BFS Solution (Topological Sort / Kahn’s Algorithm)
 */
public class CourseScheduleBFS {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;

    public static void main(String[] args) {
        CourseScheduleBFS obj = new CourseScheduleBFS();
        // Test case 1: [[1,0]]
        int[][] input1 = {{1, 0}};
        boolean result1 = obj.canFinish(2, input1);
        System.out.println(Arrays.deepToString(input1) + " => " + result1); // Output : true

        // Test case 2: [[1,0],[0,1]]
        int[][] input2 = {{1, 0}, {0, 1}};
        boolean result2 = obj.canFinish(2, input2);
        System.out.println(Arrays.deepToString(input2) + " => " + result2); // Output : false

        // Test case 3: [[]]
        int[][] input3 = {};
        boolean result3 = obj.canFinish(1, input3);
        System.out.println(Arrays.deepToString(input3) + " => " + result3); // Output : true

        // Test case 4: [[]]
        int[][] input4 = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        boolean result4 = obj.canFinish(20, input4);
        System.out.println(Arrays.deepToString(input4) + " => " + result4); // Output : false
    }

    /**
     * Determines if all courses can be finished using BFS (Topological Sort / Kahn's Algorithm).
     *
     * @param numCourses    Total number of courses.
     * @param prerequisites Prerequisite pairs.
     * @return true if all courses can be completed, false otherwise.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        int[] inDegree = new int[numCourses]; // Number of prerequisites per course

        // Step 1: Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Step 2: Build graph and fill inDegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj[prereq].add(course); // edge: prereq → course
            inDegree[course]++;
        }

        // Step 3: Initialize queue with all courses having 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true; // Marks that course i is being processed and avoids future re-enqueue
            }
        }

        int processed = 0;

        // Step 4: BFS processing
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processed++;

            for (int neighbor : adj[current]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0 && !visited[neighbor]) { // Ensures neighbor is only enqueued once when it's ready
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return processed == numCourses;
    }

    /**
     * | Metric              | DFS (Cycle Detection)  | BFS (Kahn’s Algorithm)                     |
     * | ------------------- | ---------------------- | ------------------------------------------ |
     * | Time Complexity     | `O(n + p)`             | `O(n + p)`                                 |
     * | Space Complexity    | `O(n + p)`             | `O(n + p)`                                 |
     * | Recursion Stack     | `O(n)` (worst case)    | ❌ No recursion                             |
     * | Suitable for Order? | ❌ No (unless modified) | ✅ Yes (returns topological order in LC210) |
     * | Detects Cycle?      | ✅ Yes                  | ✅ Yes                                      |
     *
     * | Note:               | n = numCourses (nodes) | p = prerequisites.length (edges)            |
     */
}
