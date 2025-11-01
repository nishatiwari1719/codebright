package potd.lc;

import blind75Sheet.utils.inPlaceReversalOfALinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

import static blind75Sheet.utils.inPlaceReversalOfALinkedList.ListUtils.createList;

/**
 * Leetcode : 3217. Delete Nodes From Linked List Present in Array
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        DeleteNodesFromLinkedListPresentInArray obj = new DeleteNodesFromLinkedListPresentInArray();

        // Test case 1 : nums = [1,2,3], head = [1,2,3,4,5]
        int[] nums1 = {1, 2, 3};
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5}, -1);
        ListNode result1 = obj.modifiedList(nums1, head1);
        System.out.println("Test case 1 : nums1 = [1,2,3], head1 = [1,2,3,4,5] → " + result1); //[4, 5]

        // Test case 2 : nums = [1,2], head = [1,4,5,2]
        int[] nums2 = {1, 2};
        ListNode head2 = createList(new int[]{1, 4, 5, 2}, -1);
        ListNode result2 = obj.modifiedList(nums2, head2);
        System.out.println("Test case 2 : nums2 = [1,2], head2 = [1,4,5,2] → " + result2); //[4, 5]
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        while (head != null) {
            if (!set.contains(head.val)) {
                t.next = head;
                t = t.next;
            }
            head = head.next;
        }

        t.next = null;
        return dummy.next;
    }
}
