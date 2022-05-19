package ru.edu.vtisov.list;

// https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode stub = new ListNode(-1);
        ListNode result = stub;
        ListNode head1 = list1;
        ListNode head2 = list2;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                result.next = head1;
                head1 = head1.next;
            } else {
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;
        }
        result.next = head1 == null ? head2 : head1;
        return stub.next;
    }
}