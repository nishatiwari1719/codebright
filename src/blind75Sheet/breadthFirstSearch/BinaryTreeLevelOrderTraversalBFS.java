package blind75Sheet.breadthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalBFS {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalBFS obj = new BinaryTreeLevelOrderTraversalBFS();

        Integer[] rootInput1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        List<List<Integer>> result1 = obj.levelOrder(root1);
        System.out.println(root1 + " = " + result1);
    }

    /**
     * Performs level-order traversal (BFS) on a binary tree
     * and returns a list of levels, where each level contains node values.
     *
     * @param root the root node of the binary tree
     * @return a list of lists, where each inner list contains values of one level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Process nodes level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes in current level
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                res.add(treeNode.val); // add value, not node

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            result.add(res); // add this level’s values to the final result
        }

        return result; // return the full list of levels
    }
}

/**
 * TC = O(n)
 * SC = O(n)
 */