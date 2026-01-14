package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class MaxDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        MaxDepthOfBinaryTreeDFS obj = new MaxDepthOfBinaryTreeDFS();

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
     * DFS Approach
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
