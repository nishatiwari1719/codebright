package blind75Sheet.inPlaceReversalOfALinkedList;


import blind75Sheet.utils.inPlaceReversalOfALinkedList.ListNode;

import static blind75Sheet.utils.inPlaceReversalOfALinkedList.ListUtils.createList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();

        // Test 1: head = [1,2,3,4,5]
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.print("Test 1: [1,2,3,4,5] → " + obj.reverseList(head1)); // Output : [5, 4, 3, 2, 1]

        // Test 2: head = [1,2]
        ListNode head2 = createList(new int[]{1, 2}, -1);
        System.out.print("\nTest 2: [1,2] → " + obj.reverseList(head2)); // Output : [2, 1]

        // Test 3: head = []
        ListNode head3 = createList(new int[]{}, -1);
        System.out.print("\nTest 3: [] → " + (obj.reverseList(head3) == null ? "[]" : obj.reverseList(head3))); // Output : []
    }

    /**
     * Reverses a singly linked list in-place.
     * Uses "Three Pointers" approach. The three pointers are: current, next, prev.
     *
     * @param head The head of the singly linked list.
     * @return The new head of the reversed linked list.
     */
    public ListNode reverseList(ListNode head) {
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
