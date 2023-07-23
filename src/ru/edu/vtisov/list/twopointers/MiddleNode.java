package ru.edu.vtisov.list.twopointers;

// https://leetcode.com/problems/middle-of-the-linked-list/

import ru.edu.vtisov.list.ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}