package blind75Sheet.breadthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalDFS {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalDFS obj = new BinaryTreeLevelOrderTraversalDFS();

        Integer[] rootInput1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        List<List<Integer>> result1 = obj.levelOrder(root1);
        System.out.println(root1 + " = " + result1);
    }

    /**
     * Performs level order traversal using DFS recursion.
     * Instead of using a queue, it uses recursion with a 'level' parameter
     * to keep track of which level each node belongs to.
     *
     * @param root the root of the binary tree
     * @return a list of lists, where each inner list contains the node values at that level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    /**
     * Helper DFS method.
     *
     * @param node   current TreeNode being visited
     * @param level  current depth (0 for root, 1 for its children, etc.)
     * @param result final list storing level-wise nodes
     */
    void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // If we reach a new level for the first time, add a new list
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the current node’s value to its level list
        result.get(level).add(node.val);

        // Recur for left and right subtrees, increasing the level
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}

/**
 * TC = O(n)
 * SC = O(n)
 */
