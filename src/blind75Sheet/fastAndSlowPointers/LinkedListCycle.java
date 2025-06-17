package blind75Sheet.fastAndSlowPointers;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        // Test 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = createList(new int[]{3, 2, 0, -4}, 1);
        System.out.println("Test 1: [3,2,0,-4], pos=1 → Has Cycle? " + hasCycle(head1)); // true

        // Test 2: head = [1,2], pos = 0
        ListNode head2 = createList(new int[]{1, 2}, 0);
        System.out.println("Test 2: [1,2], pos=0 → Has Cycle? " + hasCycle(head2)); // true

        // Test 3: head = [1], pos = -1
        ListNode head3 = createList(new int[]{1}, -1);
        System.out.println("Test 3: [1], pos=-1 → Has Cycle? " + hasCycle(head3)); // false
    }

    /**
     * This program detects a cycle in a singly linked list using the Floyd’s Cycle Detection Algorithm
     * (also known as the Tortoise and Hare Algorithm).
     *
     * Use two pointers, walker and runner.
     * Walker moves step by step. runner moves two steps at time.
     * If the Linked List has a cycle walker and runner will meet at some point.
     *
     * TC = O(n), SC = O(1)
     *
     * PS: Doesn’t detect where the cycle starts — only whether a cycle exists.
     *
     * @param head
     * @return true, if cycle exists, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode walker = head;
        ListNode runner = head;

        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }

    /**
     * Create list with cycle at position 'pos'.
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
}

/**
 * Time Complexity
 * hasCycle(head):
 * Worst-case: The runner and walker traverse at most n nodes before meeting or terminating.
 * Time Complexity = O(n)
 * where n is the number of nodes in the linked list.
 *
 * Space Complexity
 * Only two pointers (walker and runner) are used.
 * Space Complexity = O(1) (constant space, in-place)
 *
 * | Aspect                 | Details                                          |
 * | ---------------------- | ------------------------------------------------ |
 * | **Algorithm Used**     | Floyd's Cycle Detection                          |
 * | **Cycle Detection**    | Using two pointers (walker & runner)             |
 * | **Time Complexity**    | O(n)                                             |
 * | **Space Complexity**   | O(1)                                             |
 * | **Test Coverage**      | Covers cycle and no-cycle cases                  |
 * | **Enhancement Option** | Extend `hasCycle` to detect the cycle start node |
 */
