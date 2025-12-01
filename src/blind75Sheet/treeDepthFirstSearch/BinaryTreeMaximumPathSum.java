package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

        Integer[] rootInput1 = {1, 2, 3};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        int result1 = obj.maxPathSum(root1);
        System.out.println(root1 + " = " + result1);

        Integer[] rootInput2 = {-10, 9, 20, null, null, 15, 7};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        int result2 = obj.maxPathSum(root2);
        System.out.println(root2 + " = " + result2);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
