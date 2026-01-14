package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        MaxDepthOfBinaryTreeBFS obj = new MaxDepthOfBinaryTreeBFS();

        // Test Case 1
        Integer[] rootInput1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        int result1 = obj.maxDepth(root1);
        System.out.println(root1 + " = " + result1); // Output = 3

        // Test Case 2
        Integer[] rootInput2 = {1, null, 2};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        int result2 = obj.maxDepth(root2);
        System.out.println(root2 + " = " + result2); // Output = 2
    }

    /**
     * BFS Approach
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }
}
