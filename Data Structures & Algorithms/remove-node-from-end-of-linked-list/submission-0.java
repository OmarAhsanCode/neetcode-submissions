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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        // Find size
        int s = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            s++;
        }

        // If removing head
        if (n == s) {
            return head.next;
        }

        // Position of node before the one to delete
        int c = s - n;

        ListNode prev = head;

        for (int i = 1; i < c; i++) {
            prev = prev.next;
        }

        // Delete the node
        prev.next = prev.next.next;

        return head;
    }
}
