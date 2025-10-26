package blind75Sheet.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DFS Solution
 * Approach inspired by Akshay Anil, reference = https://www.youtube.com/watch?v=NBSXzs8mrOQ
 */
public class GraphValidTreeDFS {
    // Global variable to track the number of nodes visited during DFS
    int nodeCount;

    public static void main(String[] args) {
        GraphValidTreeDFS obj = new GraphValidTreeDFS();

        // Test case 1: n1 = 4, m1 = 3, edges1 = [[0, 1], [1, 2], [1, 3]]
        int n1 = 4, m1 = 3;
        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges1.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges1.add(new ArrayList<>(Arrays.asList(1, 3)));
        boolean result1 = obj.isTree(n1, m1, edges1); // true
        System.out.println("n1=" + n1 + ", m1=" + m1 + ", edges1=" + edges1 + " => " + result1);

        // Test case 1: n1 = 4, m1 = 3, edges1 = [[0, 1], [1, 2], [2, 0]]
        int n2 = 4, m2 = 3;
        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>();
        edges2.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges2.add(new ArrayList<>(Arrays.asList(2, 0)));
        boolean result2 = obj.isTree(n2, m2, edges2); // false
        System.out.println("n2=" + n2 + ", m2=" + m2 + ", edges2=" + edges2 + " => " + result2);
    }

    /**
     * Checks if the Graph is a Tree.
     * <p>
     * TC: O(n + m)
     * SC: O(n)
     *
     * @param n     nodes (numbered from 0 to N-1)
     * @param m     edges
     * @param edges
     * @return
     */
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // A graph is a tree only if it has exactly n-1 edges.
        if (m != n - 1) {
            return false;
        }

        // Initialize nodeCount and visited array
        nodeCount = 1;
        boolean[] visited = new boolean[n];

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list (for an undirected graph)
        for (int i = 0; i < m; i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        // 'startNode' is the starting point for DFS (assuming node 0)
        int startNode = 0;

        // Perform DFS
        dfs(adj, visited, startNode);

        // A graph is a tree if it has n-1 edges AND is connected (nodeCount == n).
        return nodeCount == n;
    }

    /**
     * Helper function to perform Depth-First Search.
     *
     * @param adj
     * @param visited
     * @param currentNode
     */
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        for (int neighbor : adj.get(currentNode)) {
            if (!visited[neighbor]) {
                // Increment global count only when a new node is discovered
                nodeCount++;
                dfs(adj, visited, neighbor);
            }
        }
    }
}
