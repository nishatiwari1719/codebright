package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalDFS {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversalDFS obj = new ConstructBinaryTreeFromPreorderAndInorderTraversalDFS();

        // Test Case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode treeNode1 = obj.buildTree(preorder1, inorder1);
        System.out.println("preorder1:" + Arrays.toString(preorder1) + ", inorder1:" + Arrays.toString(inorder1) + ", output:" + treeNode1); // Output = [3,9,20,null,null,15,7]

        // Test Case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode treeNode2 = obj.buildTree(preorder2, inorder2);
        System.out.println("preorder2:" + Arrays.toString(preorder2) + ", inorder2:" + Arrays.toString(inorder2) + ", output:" + treeNode2); // Output = [3,9,20,null,null,15,7]
    }

    /**
     * Builds a binary tree from preorder and inorder traversal arrays.
     * <p>
     * preorder: Root → Left → Right
     * inorder:  Left → Root → Right
     * <p>
     * Uses a hashmap for fast index lookup in inorder traversal.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        // Store index of each value from inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start building the tree from the full inorder range
        return build(preorder, inorderIndexMap, 0, 0, inorder.length - 1);
    }

    /**
     * Recursively builds the binary tree.
     *
     * @param preorder        preorder traversal array
     * @param inorderIndexMap maps node value to its index in inorder array
     * @param rootIndex       index of current root in preorder array
     * @param left            left boundary of inorder range
     * @param right           right boundary of inorder range
     * @return root node of the constructed subtree
     */
    TreeNode build(int[] preorder, Map<Integer, Integer> inorderIndexMap, int rootIndex, int left, int right) {
        // Create root node using preorder traversal
        TreeNode root = new TreeNode(preorder[rootIndex]);

        // Find root position in inorder traversal
        int mid = inorderIndexMap.get(preorder[rootIndex]);

        // Build left subtree
        if (mid > left) {
            root.left = build(preorder, inorderIndexMap, rootIndex + 1, left, mid - 1);
        }

        // Build right subtree
        if (mid < right) {
            root.right = build(preorder, inorderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
        }

        return root;
    }
}
