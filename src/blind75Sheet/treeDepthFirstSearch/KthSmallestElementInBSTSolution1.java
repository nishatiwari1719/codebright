package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.Arrays;

/**
 * Approach: Morris Traversal
 */
public class KthSmallestElementInBSTSolution1 {
    public static void main(String[] args) {
        KthSmallestElementInBSTSolution1 obj = new KthSmallestElementInBSTSolution1();

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
        TreeNode curr = root;
        int count = 0;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    count++;
                    if (count == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}

/**
 * TC=O(n)
 * SC=O(1)
 */