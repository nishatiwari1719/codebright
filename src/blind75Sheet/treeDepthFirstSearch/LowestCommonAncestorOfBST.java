package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class LowestCommonAncestorOfBST {

    public static void main(String[] args) {
        LowestCommonAncestorOfBST obj = new LowestCommonAncestorOfBST();

        // Test Case 1
        Integer[] rootInput1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        TreeNode p1 = TreeNodeUtils.findNode(root1, 2);
        TreeNode q1 = TreeNodeUtils.findNode(root1, 8);
        TreeNode treeNodeResult1 = obj.lowestCommonAncestor(root1, p1, q1);
        System.out.println(root1 + " = " + treeNodeResult1.val);

        // Test Case 2
        Integer[] rootInput2 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        TreeNode p2 = TreeNodeUtils.findNode(root2, 2);
        TreeNode q2 = TreeNodeUtils.findNode(root2, 4);
        TreeNode treeNodeResult2 = obj.lowestCommonAncestor(root2, p2, q2);
        System.out.println(root2 + " = " + treeNodeResult2.val);

        // Test Case 3
        Integer[] rootInput3 = {2, 1};
        TreeNode root3 = TreeNodeUtils.buildTree(rootInput3);
        TreeNode p3 = TreeNodeUtils.findNode(root3, 2);
        TreeNode q3 = TreeNodeUtils.findNode(root3, 1);
        TreeNode treeNodeResult3 = obj.lowestCommonAncestor(root3, p3, q3);
        System.out.println(root3 + " = " + treeNodeResult3.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
