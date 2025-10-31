package blind75Sheet.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DFS Solution
 */
public class NumberOfUnconnectedComponentsInUndirectedGraphDFS {
    public static void main(String[] args) {
        NumberOfUnconnectedComponentsInUndirectedGraphDFS obj = new NumberOfUnconnectedComponentsInUndirectedGraphDFS();

        // Test case 1: [[0, 1], [2, 1], [3, 4]]
        int[][] input1 = {{0, 1}, {2, 1}, {3, 4}};
        int v1 = 5;
        ArrayList<ArrayList<Integer>> components1 = obj.getComponents(v1, input1);
        System.out.println("v1 = " + v1 + ", graph1 = " + Arrays.deepToString(input1) + " => " + components1);
        // Output for GFG style : [[0, 1, 2], [3, 4]]
        // Alternate output, if asked to return number of connected components : 2

        // Test case 2: [[0, 1], [6, 0], [2, 4], [2, 3], [3, 4]]
        int[][] input2 = {{0, 1}, {6, 0}, {2, 4}, {2, 3}, {3, 4}};
        int v2 = 7;
        ArrayList<ArrayList<Integer>> components2 = obj.getComponents(v2, input2);
        System.out.println("v2 = " + v2 + ", graph2 = " + Arrays.deepToString(input2) + " => " + components2);
        // Output for GFG style : [[0, 1, 6], [2, 4, 3], [5]]
        // Alternate output, if asked to return number of connected components : 3
    }

    /**
     * DFS Solution to find all connected components in an undirected graph.
     * <p>
     * TC: O(V + E) Each vertex and edge is processed once
     * SC: O(V + E) Adjacency list + recursion stack + visited array
     *
     * @param V     vertices
     * @param edges edges between the vertices
     * @return list of connected components
     */
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // Create an adjacency list of size V
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list (undirected graph, so add both directions)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // int nodeCount = 0; // Uncomment if asked to return count of total components

        // Keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Store all connected components
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>(); // Return this for GFG question

        // Traverse all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // nodeCount++; //Return this if asked to return count of total components
                ArrayList<Integer> component = new ArrayList<>();
                dfs(adj, visited, i, component);
                connectedComponents.add(component);
            }
        }

        // return nodeCount; // Return this if asked to return count of total components
        return connectedComponents; // For GFG
    }

    /**
     * DFS traversal to find all nodes in a connected component.
     *
     * @param adj     adjacency list to track neighbors
     * @param visited array to track if a node is visited
     * @param node    vertex
     * @return connected component
     */
    ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor, component);
            }
        }

        return component;
    }

    /**
     * | Feature             | BFS                         | DFS                    |
     * | ------------------- | --------------------------- | ---------------------- |
     * | Traversal mechanism | Queue (iterative)           | Recursion (or stack)   |
     * | Memory use          | Slightly higher (queue)     | Slightly lower (stack) |
     * | Best for            | Shortest path / Level order | Deep traversal         |
     * | Output order        | Level-wise                  | Depth-wise             |
     */
}
