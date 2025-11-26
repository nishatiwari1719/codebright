package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTreeBFS {
    public static void main(String[] args) {
        InvertBinaryTreeBFS obj = new InvertBinaryTreeBFS();

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
     * Inverts a binary tree by using the iterative approach.
     *
     * @param root the root of the binary tree to invert
     * @return the root of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();

            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return root;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     */
}
