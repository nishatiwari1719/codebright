package blind75Sheet.twoPointers;

import blind75Sheet.utils.inPlaceReversalOfALinkedList.ListNode;

import static blind75Sheet.utils.inPlaceReversalOfALinkedList.ListUtils.createList;

public class MergeTwoSortedListsSolution2 {
    public static void main(String[] args) {
        MergeTwoSortedListsSolution2 obj = new MergeTwoSortedListsSolution2();

        ListNode head1_1 = createList(new int[]{1, 2, 4}, -1);
        ListNode head1_2 = createList(new int[]{1, 3, 4}, -1);
        System.out.println("head1_1=" + head1_1 + ", head1_2=" + head1_2 + ", result=" + obj.mergeTwoLists(head1_1, head1_2)); // [1,1,2,3,4,4]

        ListNode head2_1 = createList(new int[]{}, -1);
        ListNode head2_2 = createList(new int[]{}, -1);
        System.out.println("head2_1=" + head2_1 + ", head2_2=" + head2_2 + ", result=" + obj.mergeTwoLists(head2_1, head2_2)); // []

        ListNode head3_1 = createList(new int[]{}, -1);
        ListNode head3_2 = createList(new int[]{0}, -1);
        System.out.println("head3_1=" + head3_1 + ", head3_2=" + head3_2 + ", result=" + obj.mergeTwoLists(head3_1, head3_2)); // [0]
    }

    /**
     * Iterative Solution
     *
     * @param list1
     * @param list2
     * @return merged list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode head = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        if (list1 == null) {
            result.next = list2;
        } else if (list2 == null) {
            result.next = list1;
        }

        return head.next;
    }
}

/**
 * TC= O(n)
 * SC= O(1)
 */