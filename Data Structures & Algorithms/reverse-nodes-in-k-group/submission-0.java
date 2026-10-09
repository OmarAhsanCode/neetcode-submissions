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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode temp = curr;
        ListNode temp1 = temp;

        ListNode prev = null;
        ListNode next = null;

        ListNode newHead = null;
        ListNode groupEnd = null;

        while (temp1 != null) {

            // Check if k nodes exist
            temp = curr;
            int c = 1;

            while (c < k && temp != null) {
                c++;
                temp = temp.next;
            }

            // Less than k nodes remaining
            if (temp == null) {
                break;
            }

            // Reverse k nodes
            c = 1;
            prev = null;

            while (c <= k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                c++;
            }

            // First reversed group
            if (newHead == null) {
                newHead = prev;
            }
            else {
                groupEnd.next = prev;
            }

            // End of current reversed group
            groupEnd = head;

            // Move head to next group
            head = curr;

            // Check next group
            temp1 = curr;
        }

        // Connect last incomplete group
        if (groupEnd != null) {
            groupEnd.next = curr;
        }

        return newHead;
    }
}
