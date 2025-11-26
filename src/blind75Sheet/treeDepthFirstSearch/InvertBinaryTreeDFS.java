package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class InvertBinaryTreeDFS {
    public static void main(String[] args) {
        InvertBinaryTreeDFS obj = new InvertBinaryTreeDFS();

        Integer[] rootInput1 = {2, 1, 3};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        String before1 = root1.toString();
        TreeNode treeNode1 = obj.invertTree(root1);
        System.out.println(before1 + " = " + treeNode1);

        Integer[] rootInput2 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        String before2 = root2.toString();
        TreeNode treeNode2 = obj.invertTree(root2);
        System.out.println(before2 + " = " + treeNode2);
    }

    /**
     * Inverts a binary tree by recursively swapping the left and right children of every node.
     *
     * @param root the root of the binary tree to invert
     * @return the root of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     */
}
