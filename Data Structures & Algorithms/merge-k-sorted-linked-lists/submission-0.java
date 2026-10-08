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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode A = new ListNode();
        ListNode curr = A;

        boolean b = true;

        while (b) {

            int min = Integer.MAX_VALUE;
            int c = -1;

            // Find minimum
            for (int j = 0; j < lists.length; j++) {

                if (lists[j] != null && lists[j].val < min) {
                    min = lists[j].val;
                    c = j;
                }
            }

            // No nodes left
            if (c == -1) {
                break;
            }

            // Add minimum node to answer
            curr.next = new ListNode(min);
            curr = curr.next;

            // Move that list forward
            lists[c] = lists[c].next;
        }

        return A.next;
    }
}
