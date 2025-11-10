package blind75Sheet.breadthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();

        Integer[] rootInput1 = {3, 4, 5, 1, 2};
        Integer[] subRootInput1 = {4, 1, 2};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        TreeNode subRoot1 = TreeNodeUtils.buildTree(subRootInput1);
        boolean result1 = obj.isSubtree(root1, subRoot1);
        System.out.println(root1 + ", " + subRoot1 + " = " + result1);

        Integer[] rootInput2 = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] subRootInput2 = {4, 1, 2};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        TreeNode subRoot2 = TreeNodeUtils.buildTree(subRootInput2);
        boolean result2 = obj.isSubtree(root2, subRoot2);
        System.out.println(root2 + ", " + subRoot2 + " = " + result2);
    }

    /**
     * DFS Approach - Preorder Traversal
     * <p>
     * Perform DFS traversal on the main tree.
     * At each node, check if the subtree starting at that node is identical to subRoot
     * (using {@link #isSame(TreeNode, TreeNode)}).
     * If an identical subtree is found, return true.
     * Otherwise, recursively check in the left and right subtrees.
     * <p>
     * Time Complexity: O(m × n), For each node in root (n), a potential subtree comparison with subRoot (m) may occur.
     * Space Complexity: O(h), Where h is the height of the tree (due to recursion stack).
     *
     * @param root    The root node of the main binary tree.
     * @param subRoot The root node of the potential subtree.
     * @return true if subRoot is a subtree of root; false otherwise.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        // Check if the subtree rooted at this node matches subRoot,
        // or recursively search in the left and right subtrees.
        return isSame(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    /**
     * Compares two binary trees to determine if they are structurally identical and have the same node values.
     *
     * @param root    The root node of the first binary tree.
     * @param subRoot The root node of the second binary tree.
     * @return true if both trees are identical; false otherwise.
     * <p>
     * If both nodes are null, they are identical (base case).
     * If one node is null and the other is not, they differ.
     * If both nodes have the same value, recursively check their left and right children.
     */
    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val != subRoot.val) return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
