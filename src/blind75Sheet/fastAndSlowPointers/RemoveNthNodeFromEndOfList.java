package blind75Sheet.fastAndSlowPointers;

import blind75Sheet.utils.fastAndSlowPointers.ListNode;

import static blind75Sheet.utils.fastAndSlowPointers.ListUtils.createList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        // Test 1: head = [1,2,3,4,5], n = 2
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.println("Test 1: [1,2,3,4,5], n = 2 → " + removeNthFromEnd(head1, 2)); //[1, 2, 3, 5]

        // Test 2: head = [1], n = 1
        ListNode head2 = createList(new int[]{1}, -1);
        System.out.println("Test 2: [1], n = 1 → " + removeNthFromEnd(head2, 1)); //null

        // Test 3: head = [1,2], n = 1
        ListNode head3 = createList(new int[]{1, 2}, -1);
        System.out.println("Test 3: [1,2], n = 1 → " + removeNthFromEnd(head3, 1)); //[1]
    }

    /**
     * Removes the Nth node from the end of a singly linked list and returns the head of the modified list.
     * <p>
     * This method uses a two-pointer approach. A dummy node is used to simplify edge cases, such as when the
     * node to remove is the head. The second pointer is advanced by 'n' steps. Then, both pointers move one step
     * at a time until the second pointer reaches the end. At this point, the first pointer is just before the node
     * to be removed.
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), constant extra space is used.
     *
     * @param head the head of the singly linked list
     * @param n    the position from the end of the node to remove (1-based index)
     * @return the head of the updated linked list after removal
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        for (int i = 0; i < n; i++) {
            secondPtr = secondPtr.next;
        }

        while (secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next;
        return dummy.next;
    }
}

/**
 * Time Complexity
 * removeNthFromEnd(head, n):
 * Worst-case: Both pointers traverse the entire list once.
 * Time Complexity = O(n)
 * where n is the number of nodes in the linked list.
 * <p>
 * Space Complexity
 * Only constant extra space is used (dummy node and two pointers).
 * Space Complexity = O(1)
 * <p>
 * | Aspect                 | Details                                                              |
 * |------------------------|----------------------------------------------------------------------|
 * | **Algorithm Used**     | Two-pointer technique with dummy node                                |
 * | **Node Removal**       | Remove Nth node from end in a single traversal                       |
 * | **Time Complexity**    | O(n)                                                                 |
 * | **Space Complexity**   | O(1)                                                                 |
 * | **Edge Cases Covered** | List with 1 node, removing head, removing tail, general middle case  |
 * | **Enhancement Option** | Can be adapted for doubly linked lists or circular lists             |
 */
