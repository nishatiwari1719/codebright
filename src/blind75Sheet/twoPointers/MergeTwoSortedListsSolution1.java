package blind75Sheet.twoPointers;

import blind75Sheet.utils.inPlaceReversalOfALinkedList.ListNode;

import static blind75Sheet.utils.inPlaceReversalOfALinkedList.ListUtils.createList;

public class MergeTwoSortedListsSolution1 {
    public static void main(String[] args) {
        MergeTwoSortedListsSolution1 obj = new MergeTwoSortedListsSolution1();

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
     * Recursive Solution
     *
     * @param list1
     * @param list2
     * @return merged list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

/**
 * TC= O(n)
 * SC= O(1)
 */