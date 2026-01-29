package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.Arrays;

/**
 * Approach: DFS
 */
public class KthSmallestElementInBSTSolution2 {
    int count = 0;
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        KthSmallestElementInBSTSolution2 obj1 = new KthSmallestElementInBSTSolution2();
        KthSmallestElementInBSTSolution2 obj2 = new KthSmallestElementInBSTSolution2();

        // Test Case 1
        Integer[] rootInput1 = {3, 1, 4, null, 2};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        int kthSmallestResult1 = obj1.kthSmallest(root1, 1);
        System.out.println("rootInput1=" + Arrays.toString(rootInput1) + ", kthSmallestResult1=" + kthSmallestResult1);

        // Test Case 2
        Integer[] rootInput2 = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        int kthSmallestResult2 = obj2.kthSmallest(root2, 3);
        System.out.println("rootInput2=" + Arrays.toString(rootInput2) + ", kthSmallestResult2=" + kthSmallestResult2);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        // core logic -----------------------
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        // ----------------------------------
        dfs(root.right, k);
    }
}

/**
 * TC=O(n)
 * SC=O(1)
 */
