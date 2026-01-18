package blind75Sheet.kWayMerge;

import blind75Sheet.utils.inPlaceReversalOfALinkedList.ListNode;

import java.util.PriorityQueue;

import static blind75Sheet.utils.inPlaceReversalOfALinkedList.ListUtils.createList;

public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();

        ListNode l1 = createList(new int[]{1, 4, 5}, -1);
        ListNode l2 = createList(new int[]{1, 3, 4}, -1);
        ListNode l3 = createList(new int[]{2, 6}, -1);
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode result = obj.mergeKLists(lists);
        System.out.println(result);

        ListNode[] lists2 = new ListNode[]{};
        ListNode result2 = obj.mergeKLists(lists2);
        System.out.println(result2); // Here, output is null because toString() of ListNode is yet to be adjusted

        ListNode[] lists3 = new ListNode[]{null};
        ListNode result3 = obj.mergeKLists(lists3);
        System.out.println(result3); // Here, output is null because toString() of ListNode is yet to be adjusted
    }

    /**
     * Merges k sorted linked lists into a single sorted linked list.
     * <p>
     * Time Complexity: O(N log k), where N is the total number of nodes
     * across all lists and k is the number of lists.
     * <p>
     * Space Complexity: O(k), due to the priority queue storing at most
     * one node from each list at a time.
     *
     * @param lists an array of sorted linked lists
     * @return the merged sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        // Initialize heap with head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // Extract minimum node and add its next node to the heap
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;

            if (temp.next != null) {
                queue.add(temp.next);
            }
        }

        return dummy.next;
    }
}

/**
 * | Aspect               | Complexity     | Explanation                                                                                                           |
 * | -------------------- | -------------- | --------------------------------------------------------------------------------------------------------------------- |
 * | **Time Complexity**  | **O(N log k)** | Each of the **N** nodes is inserted and removed from the priority queue once, and each heap operation costs **log k** |
 * | **Space Complexity** | **O(k)**       | Priority queue holds at most **k** nodes (one from each list) at any time                                             |
 */