package blind75Sheet.treeDepthFirstSearch;

import blind75Sheet.utils.breadFirstSearch.TreeNode;
import blind75Sheet.utils.breadFirstSearch.TreeNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree obj =
                new SerializeAndDeserializeBinaryTree();

        // Test Case 1
        Integer[] input1 = {1, 2, 3, null, null, 4, 5};
        TreeNode root1 = TreeNodeUtils.buildTree(input1);

        String serialized1 = obj.serialize(root1);
        TreeNode deserialized1 = obj.deserialize(serialized1);
//        String reSerialized1 = obj.serialize(deserialized1);

        System.out.println("Input       = " + Arrays.toString(input1));
        System.out.println("Serialized  = " + serialized1);
        System.out.println("ReSerialized= " + TreeNodeUtils.toLevelOrderArray(deserialized1));
        System.out.println();

        // Test Case 2: Single node
        Integer[] input2 = {10};
        TreeNode root2 = TreeNodeUtils.buildTree(input2);
        String serialized2 = obj.serialize(root2);
        TreeNode deserialized2 = obj.deserialize(serialized2);
//        String reSerialized2 = obj.serialize(deserialized2);

        System.out.println("Serialized single node");
        System.out.println("Input       = " + Arrays.toString(input2));
        System.out.println("Serialized  = " + serialized2);
        System.out.println("ReSerialized= " + TreeNodeUtils.toLevelOrderArray(deserialized2));
        System.out.println();

        // Test Case 3: Empty tree
        Integer[] input3 = {};
        TreeNode root3 = TreeNodeUtils.buildTree(input3);
        ;
        String serialized3 = obj.serialize(root3);
        TreeNode deserialized3 = obj.deserialize(serialized3);

        System.out.println("Serialized empty tree");
        System.out.println("Input       = " + Arrays.toString(input3));
        System.out.println("Serialized  = " + serialized3);
        System.out.println("ReSerialized= " + TreeNodeUtils.toLevelOrderArray(deserialized3));
        System.out.println();
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",", -1)));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.isEmpty())
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}

/**
 * TC=O(n)
 * SC=O(1)
 */