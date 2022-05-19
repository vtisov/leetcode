package ru.edu.vtisov.list;

// https://leetcode.com/problems/palindrome-linked-list/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode reverse = reverseList(middle);
        ListNode current = head;
        while(reverse != null) {
            if (current.val != reverse.val)
                return false;
            current = current.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
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