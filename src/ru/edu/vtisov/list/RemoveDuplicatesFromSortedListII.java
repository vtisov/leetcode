package ru.edu.vtisov.list;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode pred = result;
        while(head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return result.next;
    }
}