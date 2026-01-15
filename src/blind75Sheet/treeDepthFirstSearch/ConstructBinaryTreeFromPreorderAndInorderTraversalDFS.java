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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, inorderIndexMap, 0, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, Map<Integer, Integer> inorderIndexMap, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);

        int mid = inorderIndexMap.get(preorder[rootIndex]);
        if (mid > left) {
            root.left = build(preorder, inorderIndexMap, rootIndex + 1, left, mid - 1);
        }
        if (mid < right) {
            root.right = build(preorder, inorderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
        }

        return root;
    }
}
