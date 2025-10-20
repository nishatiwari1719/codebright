package blind75Sheet.utils.inPlaceReversalOfALinkedList;

public class ListUtils {


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
}
