package blind75Sheet.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS Solution
 */
public class NumberOfUnconnectedComponentsInUndirectedGraphBFS {
    public static void main(String[] args) {
        NumberOfUnconnectedComponentsInUndirectedGraphBFS obj = new NumberOfUnconnectedComponentsInUndirectedGraphBFS();

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
     * BFS Solution to find all connected components in an undirected graph.
     *
     * @param V
     * @param edges
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
                ArrayList<Integer> component = bfs(adj, visited, i); // For LC question, only call bfs
                connectedComponents.add(component);
            }
        }

        // return nodeCount; // Return this if asked to return count of total components
        return connectedComponents; // For GFG
    }

    /**
     * BFS traversal to find all nodes in a connected component.
     *
     * @param adj
     * @param visited
     * @param startNode
     * @return connected component
     */
    ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int startNode) {
        ArrayList<Integer> component = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            component.add(currentNode);

            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return component;
    }
}
