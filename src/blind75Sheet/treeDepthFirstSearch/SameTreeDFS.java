package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

public class SameTreeDFS {
    public static void main(String[] args) {
        SameTreeDFS obj = new SameTreeDFS();

        Integer[] rootInput1 = {1, 2, 3};
        Integer[] subRootInput1 = {1, 2, 3};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        TreeNode subRoot1 = TreeNodeUtils.buildTree(subRootInput1);
        boolean result1 = obj.isSameTree(root1, subRoot1);
        System.out.println(root1 + ", " + subRoot1 + " = " + result1);

        Integer[] rootInput2 = {1, 2};
        Integer[] subRootInput2 = {1, null, 2};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        TreeNode subRoot2 = TreeNodeUtils.buildTree(subRootInput2);
        boolean result2 = obj.isSameTree(root2, subRoot2);
        System.out.println(root2 + ", " + subRoot2 + " = " + result2);

        Integer[] rootInput3 = {1, 2, 1};
        Integer[] subRootInput3 = {1, 1, 2};
        TreeNode root3 = TreeNodeUtils.buildTree(rootInput3);
        TreeNode subRoot3 = TreeNodeUtils.buildTree(subRootInput3);
        boolean result3 = obj.isSameTree(root3, subRoot3);
        System.out.println(root3 + ", " + subRoot3 + " = " + result3);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/**
 * TC: O(n)
 * SC: O(n)
 */
