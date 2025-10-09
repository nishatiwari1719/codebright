package blind75Sheet.fastAndSlowPointers;

import blind75Sheet.utils.fastAndSlowPointers.ListNode;

import static blind75Sheet.utils.fastAndSlowPointers.ListUtils.createList;

public class ReorderList {
    public static void main(String[] args) {
        // Test 1: head = [1,2,3,4,5], n = 2
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.print("Test 1: [1,2,3,4,5] → ");
        reorderList(head1); //[1, 5, 2, 4, 3]

        // Test 2: head = [1], n = 1
        ListNode head2 = createList(new int[]{1}, -1);
        System.out.print("\nTest 2: [1] → ");
        reorderList(head2); //

        // Test 3: head = [1,2], n = 1
        ListNode head3 = createList(new int[]{1, 2}, -1);
        System.out.print("\nTest 3: [1,2] → ");
        reorderList(head3); //[1, 2]

        // Test 4: head = [1,2], n = 1
        ListNode head4 = createList(new int[]{1, 2, 3, 4}, -1);
        System.out.print("\nTest 4: [1,2,3,4] → ");
        reorderList(head4); //[1, 4, 2, 3]
    }

    public static void reorderList(ListNode head) {

        /**
         * If the list is empty or has only one node, there's nothing to reorder.
         */
        if (head == null || head.next == null) // base case
            return;

        /**
         * Find the middle of the list.
         *
         * This uses the slow and fast pointer technique:
         * slowPointer moves one step at a time (slow pointer).
         * fastPointer moves two steps at a time (fast pointer).
         *
         * When fastPointer reaches the end, slowPointer will be at the middle of the list.
         */
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        /**
         * Reverse the half after middle.
         *
         * This reverses the second half in-place, starting after the middle node (middleNode).
         *
         * Example:
         * Original second half: 4 → 5 → null
         * After reversal: 5 → 4 → null
         *
         * This part re-links nodes by inserting the tempNode node at the front of the second half repeatedly,
         * giving the reverse effect.
         */
        ListNode middleNode = slowPointer;
        ListNode currentNode = slowPointer.next;
        while (currentNode.next != null) {
            ListNode tempNode = currentNode.next;
            currentNode.next = tempNode.next;
            tempNode.next = middleNode.next;
            middleNode.next = tempNode;
        }

        /**
         * Reorder the List.
         *
         * This merges the first half and reversed second half alternately:
         * Think of slowPointer as moving from the front.
         * Think of fastPointer as picking the next node from the reversed second half.
         * Nodes are inserted one-by-one between original nodes to achieve L0 → Ln → L1 → Ln-1 → ....
         */
        slowPointer = head;
        fastPointer = middleNode.next;
        while (slowPointer != middleNode) {
            middleNode.next = fastPointer.next;
            fastPointer.next = slowPointer.next;
            slowPointer.next = fastPointer;
            slowPointer = fastPointer.next;
            fastPointer = middleNode.next;
        }

        /**
         * head is printed properly because toString() has been overridden in the class @{@link ListNode}.
         */
        System.out.print("head:" + head);
    }

    /**
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     * No additional data structures like arrays, stacks, or queues are used.
     * All pointer manipulations are done in-place.
     * Only a constant number of pointers (slowPointer, fastPointer, middleNode, currentNode, tempNode) are used.
     */
}
