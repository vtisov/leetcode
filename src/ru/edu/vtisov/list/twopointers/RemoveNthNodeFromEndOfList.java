package ru.edu.vtisov.list.twopointers;

import ru.edu.vtisov.list.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class  RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        if (second == null) {
            return first.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
