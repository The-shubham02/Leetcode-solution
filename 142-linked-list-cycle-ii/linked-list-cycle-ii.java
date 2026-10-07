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
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Find cycle starting node
                ListNode temp = head;

                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }

                return temp;
            }
        }

        return null;
    }
}