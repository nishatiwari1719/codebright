package blind75Sheet.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS Solution (Cycle Detection using Recursion)
 */
public class CourseScheduleDFS {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;

    public static void main(String[] args) {
        CourseScheduleDFS obj = new CourseScheduleDFS();
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

        // Test case 4: [[0, 10], [3, 18], [5, 5], [6, 11], [11, 14], [13, 1], [15, 1], [17, 4]]
        int[][] input4 = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        boolean result4 = obj.canFinish(20, input4);
        System.out.println(Arrays.deepToString(input4) + " => " + result4); // Output : false
    }

    /**
     * Determines if all courses can be finished.
     *
     * @param numCourses    Total number of courses (0 to numCourses - 1).
     * @param prerequisites Prerequisite pairs [a, b] meaning to take course a, you must take course b.
     * @return true if all courses can be finished, false otherwise.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize the adjacency list
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Step 2: Build the graph
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]); // edge from a -> b (b is prerequisite of a)
        }

        // Step 3: Initialize visited and marked arrays
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];

        // Step 4: Perform DFS on all unvisited nodes
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i)) {
                    return false; // Cycle detected
                }
            }
        }

        return true; // No cycle, all courses can be finished
    }

    /**
     * Recursive DFS to detect a cycle starting from course i.
     *
     * @param i The course node to start DFS from.
     * @return true if a cycle is detected, false otherwise.
     */
    private boolean isCyclic(int i) {
        visited[i] = true;

        for (Integer neighbor : adj[i]) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor)) {
                    return true;
                }
            } else if (!marked[neighbor]) {
                // Already visited but not yet marked → cycle
                return true;
            }
        }

        marked[i] = true; // Mark as completely processed
        return false;
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
