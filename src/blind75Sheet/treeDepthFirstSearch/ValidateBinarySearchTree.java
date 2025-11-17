package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();

        Integer[] rootInput1 = {2, 1, 3};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        boolean result1 = obj.isValidBST(root1);
        System.out.println(root1 + " = " + result1);

        Integer[] rootInput2 = {5, 1, 4, null, null, 3, 6};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        boolean result2 = obj.isValidBST(root2);
        System.out.println(root2 + " = " + result2);
    }

    /**
     * Determines whether a binary tree is a valid Binary Search Tree (BST).
     * A BST must have strictly increasing values in its inorder traversal.
     * DFS Approach - Inorder Traversal - left,root,right
     *
     * @param root the root node of the binary tree
     * @return true if the tree satisfies BST properties, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();

        helper(root, inOrderList);

        boolean isBST = true;
        int prev = inOrderList.get(0);

        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= prev)
                isBST = false;

            prev = inOrderList.get(i);
        }

        return isBST;
    }

    /**
     * Performs an inorder traversal of the binary tree and stores node values.
     * Inorder traversal of a valid BST yields a strictly increasing list.
     *
     * @param treeNode    the current node being visited
     * @param inOrderList the list used to collect inorder traversal values
     */
    private void helper(TreeNode treeNode, List<Integer> inOrderList) {
        if (treeNode == null) {
            return;
        }

        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
    }
}
