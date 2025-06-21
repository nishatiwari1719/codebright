package blind75Sheet.fastAndSlowPointers;

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

    /**
     * Create list with cycle at position 'pos'.
     * <p>
     * This method is not a part of the solution.
     * It is only used for preparing test cases.
     *
     * @param values
     * @param pos
     * @return ListNode
     */
    public static ListNode createList(int[] values, int pos) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleEntry = null;

        if (pos == 0) cycleEntry = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) cycleEntry = current;
        }

        if (pos != -1) {
            current.next = cycleEntry;  // Create cycle
        }

        return head;
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
         * p1 moves one step at a time (slow pointer).
         * p2 moves two steps at a time (fast pointer).
         *
         * When p2 reaches the end, p1 will be at the middle of the list.
         */
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        /**
         * Reverse the half after middle.
         *
         * This reverses the second half in-place, starting after the middle node (preMiddle).
         *
         * Example:
         * Original second half: 4 → 5 → null
         * After reversal: 5 → 4 → null
         *
         * This part re-links nodes by inserting the current node at the front of the second half repeatedly,
         * giving the reverse effect.
         */
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        /**
         * Reorder the List.
         *
         * This merges the first half and reversed second half alternately:
         * Think of p1 as moving from the front.
         * Think of p2 as picking the next node from the reversed second half.
         * Nodes are inserted one-by-one between original nodes to achieve L0 → Ln → L1 → Ln-1 → ....
         */
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
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
     * Only a constant number of pointers (p1, p2, preMiddle, preCurrent, current) are used.
     */
}
