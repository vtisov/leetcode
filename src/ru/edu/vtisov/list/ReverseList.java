package ru.edu.vtisov.list;

// https://leetcode.com/problems/reverse-linked-list/

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}