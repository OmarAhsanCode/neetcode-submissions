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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode temp = head;

        while (temp.next != null) {

            ListNode prev = temp;
            ListNode last = temp;

            // Find the last node and the node before it
            while (last.next != null) {
                prev = last;
                last = last.next;
            }

            // Stop when only one node remains
            if (last == temp.next) {
                break;
            }

            ListNode curr = temp.next;

            // Remove last node from its old position
            prev.next = null;

            // Insert last node after temp
            temp.next = last;
            last.next = curr;

            // Move to the next node
            temp = curr;
        }
    }
}
