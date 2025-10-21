package blind75Sheet.breadthFirstSearch;

import blind75Sheet.utils.GraphUtils;

import java.util.*;

/**
 * This program builds an undirected graph using an adjacency list,
 * clones the graph using BFS, and verifies the correctness using adjacency list conversion.
 */
public class CloneGraphBFS {
    // A shared map to track already cloned nodes
    public static HashMap<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {
        // Test case 1: [[2,4],[1,3],[2,4],[1,3]]
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        // Alternate way to print output - good for debugging
//        Node head = createGraph(adjList);
//        System.out.println("Original Graph: ");
//        printGraph(head);
//
//        Node cloned = cloneGraph(head);
//        System.out.println("Cloned Graph: ");
//        printGraph(cloned);

        Node head = GraphUtils.createGraph(adjList);
        List<List<Integer>> input = GraphUtils.getAdjList(head);
        Node cloned = cloneGraph(head);
        List<List<Integer>> output = GraphUtils.getAdjList(cloned);
        System.out.println(input + " => " + output); // Output : [[2, 4], [1, 3], [2, 4], [1, 3]]

        // Test case 2: [[]]
        int[][] adjList2 = {{}};
        Node head2 = GraphUtils.createGraph(adjList2);
        List<List<Integer>> input2 = GraphUtils.getAdjList(head2);
        Node cloned2 = cloneGraph(head2);
        List<List<Integer>> output2 = GraphUtils.getAdjList(cloned2);
        System.out.println(input2 + " => " + output2); // Output : [[]]

        // Test case 3: []
        int[][] adjList3 = {};
        Node head3 = GraphUtils.createGraph(adjList3);
        List<List<Integer>> input3 = GraphUtils.getAdjList(head3);
        Node cloned3 = cloneGraph(head3);
        List<List<Integer>> output3 = GraphUtils.getAdjList(cloned3);
        System.out.println(input3 + " => " + output3); // Output : []
    }

    /**
     * Public method to start graph cloning process.
     * Clones graph using BFS.
     *
     * @param node the head node of the original graph
     * @return the head node of the cloned graph
     */
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // use a queue to help BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // use a map to save cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // clone the root
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node originalNode = queue.poll(); // node from original graph

            // get the clone corresponding to the current original node
            Node clonedNode = map.get(originalNode);

            // handle the neighbors
            for (Node neighbor : originalNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // clone the neighbor
                    map.put(neighbor, new Node(neighbor.val));
                    // add it to the next level
                    queue.add(neighbor);
                }

                // copy the neighbor - add the cloned neighbor to the cloned node’s neighbor list
                clonedNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    /**
     * Time Complexity: O(N + E)
     * Where:
     * N is the number of nodes in the graph.
     * E is the number of edges in the graph.
     * Why:
     * Each node is visited once during BFS → O(N)
     * For every node, we iterate over all its neighbors → Across all nodes, this totals to O(E) in an undirected graph.
     * Thus, the total time is O(N + E)
     * Note: This code does not have TC of O(n²), which would only be true in a dense graph with all nodes connected
     * to each other. But in general, BFS traversal is linear with respect to nodes and edges.
     *
     * Space Complexity: O(n)
     * Reasoning:
     * map stores a clone for every node → O(N)
     * queue can at most hold N nodes → O(N) in worst case
     * Each cloned node’s neighbors list will use additional space proportional to the number of edges, but not more than O(E)
     * So technically, worst-case space = O(N + E), but:
     * We usually denote space complexity as O(N) when referring to nodes and data structures storing per-node info.
     * Since E can be at most N² in a dense graph, O(N + E) still holds true.
     */
}
