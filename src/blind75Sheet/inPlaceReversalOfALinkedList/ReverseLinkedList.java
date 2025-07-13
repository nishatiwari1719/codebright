package blind75Sheet.inPlaceReversalOfALinkedList;


public class ReverseLinkedList {
    public static void main(String[] args) {
        // Test 1: head = [1,2,3,4,5]
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.print("Test 1: [1,2,3,4,5] → " + reverseList(head1)); // Output : [5, 4, 3, 2, 1]

        // Test 2: head = [1,2]
        ListNode head2 = createList(new int[]{1, 2}, -1);
        System.out.print("\nTest 2: [1,2] → " + reverseList(head2)); // Output : [2, 1]

        // Test 3: head = []
        ListNode head3 = createList(new int[]{}, -1);
        System.out.print("\nTest 3: [] → " + (reverseList(head3) == null ? "[]" : reverseList(head3))); // Output : []
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

    /**
     * Reverses a singly linked list in-place.
     * Uses "Three Pointers" approach. The three pointers are: current, next, prev.
     *
     * @param head The head of the singly linked list.
     * @return The new head of the reversed linked list.
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Store next node
            current.next = prev;          // Reverse pointer
            prev = current;               // Move prev to current
            current = next;               // Move to next node
        }

        return prev;
    }

    /**
     * Time Complexity: O(n)
     * - We iterate through the entire linked list once, visiting each node exactly one time.
     *
     * Space Complexity: O(1)
     * - No extra data structures are used. Reversal is done in-place using a constant number of pointers.
     */
}
