package blind75Sheet.breadthFirstSearch;

import blind75Sheet.utils.GraphUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This program builds an undirected graph using an adjacency list,
 * clones the graph using DFS, and verifies the correctness using adjacency list conversion.
 */
public class CloneGraphDFS {
    // A shared map to track already cloned nodes
    public static HashMap<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {
        CloneGraphDFS obj = new CloneGraphDFS();

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
        Node cloned = obj.cloneGraph(head);
        List<List<Integer>> output = GraphUtils.getAdjList(cloned);
        System.out.println(input + " => " + output); // Output : [[2, 4], [1, 3], [2, 4], [1, 3]]

        // Test case 2: [[]]
        int[][] adjList2 = {{}};
        Node head2 = GraphUtils.createGraph(adjList2);
        List<List<Integer>> input2 = GraphUtils.getAdjList(head2);
        Node cloned2 = obj.cloneGraph(head2);
        List<List<Integer>> output2 = GraphUtils.getAdjList(cloned2);
        System.out.println(input2 + " => " + output2); // Output : [[]]

        // Test case 3: []
        int[][] adjList3 = {};
        Node head3 = GraphUtils.createGraph(adjList3);
        List<List<Integer>> input3 = GraphUtils.getAdjList(head3);
        Node cloned3 = obj.cloneGraph(head3);
        List<List<Integer>> output3 = GraphUtils.getAdjList(cloned3);
        System.out.println(input3 + " => " + output3); // Output : []
    }

    /**
     * Public method to start graph cloning process.
     *
     * @param node the head node of the original graph
     * @return the head node of the cloned graph
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        return cloneUtils(node, map);
    }

    /**
     * Recursive DFS to clone the graph.
     *
     * @param node the node to clone
     * @return cloned node
     */
    public Node cloneUtils(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                newNode.neighbors.add(cloneUtils(neighbor, map));
            } else {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    /**
     * Time Complexity: O(N + E)
     * Where:
     * N = number of nodes in the graph
     * E = number of edges in the graph
     * Why:
     * Each node is visited exactly once because of the map.containsKey(neighbor) check — no node is revisited.
     * Each edge is traversed exactly once:
     * - In an undirected graph, each edge appears in two nodes’ adjacency lists.
     * - But due to the map, cloning is only done once per neighbor node.
     * - Thus, the neighbor iteration covers all edges cumulatively once (from the DFS call perspective).
     * - Creating new nodes and populating neighbor lists also costs linear time in N and E.
     * So the overall time complexity is O(N + E) — linear in the size of the graph.
     *
     * Space Complexity: O(N) (excluding output graph)
     * O(N) for the recursive call stack in the worst case (DFS).
     * O(N) for the map to store already cloned nodes.
     * O(N) for the new cloned graph structure.
     * Neighbor list inside each cloned node: Each node stores references to its neighbors → total storage across
     * all nodes is O(E) (but this is output space and often excluded from auxiliary space).
     * Hence, Auxiliary Space = O(N)
     * Total Space Including Output Graph = O(N + E)
     */
}
