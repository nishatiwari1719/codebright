package blind75Sheet.utils;

import blind75Sheet.breadthFirstSearch.Node;

import java.util.*;

public class GraphUtils {

    /**
     * Creates a graph from the given adjacency list.
     *
     * @param adjList 2D array where each index represents a node, and each element is a list of neighbors
     * @return the node with value 1 (or null if graph is empty)
     */
    public static Node createGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;

        Map<Integer, Node> nodeMap = new HashMap<>();

        // Create all nodes
        for (int i = 0; i < adjList.length; i++) {
            nodeMap.put(i + 1, new Node(i + 1));
        }

        // Connect neighbors
        for (int i = 0; i < adjList.length; i++) {
            Node current = nodeMap.get(i + 1);
            for (int neighborVal : adjList[i]) {
                current.neighbors.add(nodeMap.get(neighborVal));
            }
        }

        return nodeMap.get(1); // Return the node labeled '1' as the head
    }

    /**
     * Prints the graph in a readable format for debugging.
     *
     * @param node the head node of the graph
     */
    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " neighbors: ");
            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.offer(neighbor);
                }
            }
            System.out.println();
        }
    }

    /**
     * Converts the graph into a list-of-lists format (adjacency list) for comparison or display.
     *
     * @param node the head node of the graph
     * @return adjacency list representation of the graph
     */
    public static List<List<Integer>> getAdjList(Node node) {
        if (node == null) return new ArrayList<>();

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            adjMap.putIfAbsent(curr.val, new ArrayList<>());

            for (Node neighbor : curr.neighbors) {
                adjMap.get(curr.val).add(neighbor.val);
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.offer(neighbor);
                }
            }
        }

        // Convert to ordered adjacency list (index 0 = node 1, etc.)
        int maxNode = Collections.max(adjMap.keySet());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= maxNode; i++) {
            List<Integer> neighbors = adjMap.getOrDefault(i, new ArrayList<>());
            Collections.sort(neighbors); // Optional: sort to match LeetCode output exactly
            result.add(neighbors);
        }

        return result;
    }

}
