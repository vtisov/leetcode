package ru.edu.vtisov.list;

import ru.edu.vtisov.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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