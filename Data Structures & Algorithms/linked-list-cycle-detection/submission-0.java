/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode r = head;
        ListNode w = head;
        while(r != null)
        {
            r=r.next;
            if(r==null)
            return false;
            r=r.next;
            w=w.next;
            if(w==r)
            {
                return true;
            }
        }
        return false;
    }
}