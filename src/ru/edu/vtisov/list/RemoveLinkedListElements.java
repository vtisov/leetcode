package ru.edu.vtisov.list;

// https://leetcode.com/problems/remove-linked-list-elements/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode current = result;
        while (current.next != null) {
            if (current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return result.next;
    }
}