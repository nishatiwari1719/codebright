package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * Approach: DFS
 */
public class KthSmallestElementInBSTSolution3 {

    public static void main(String[] args) {
        KthSmallestElementInBSTSolution3 obj = new KthSmallestElementInBSTSolution3();

        // Test Case 1
        Integer[] rootInput1 = {3, 1, 4, null, 2};
        TreeNode root1 = TreeNodeUtils.buildTree(rootInput1);
        int kthSmallestResult1 = obj.kthSmallest(root1, 1);
        System.out.println("rootInput1=" + Arrays.toString(rootInput1) + ", kthSmallestResult1=" + kthSmallestResult1);

        // Test Case 2
        Integer[] rootInput2 = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root2 = TreeNodeUtils.buildTree(rootInput2);
        int kthSmallestResult2 = obj.kthSmallest(root2, 3);
        System.out.println("rootInput2=" + Arrays.toString(rootInput2) + ", kthSmallestResult2=" + kthSmallestResult2);
    }

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int result = Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p); // similar to calling dfs(root.left, k)
                p = p.left;
            } else {
                p = stack.pop();
                // core logic -----------------------------------------
                count++;
                if (count == k) {
                    result = p.val;
                    return result;
                }
                // ----------------------------------------------------
                p = p.right; // similar to calling dfs(root.right, k)
            }
        }
        return result;
    }
}

/**
 * TC=O(n)
 * SC=O(1)
 */