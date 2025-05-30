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
        
        if(head == null){
            return null;
        }
        if(head.next == head){
            return head;
        }

        ListNode slow = head,fast = head,prev = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while(prev != slow){
                    slow = slow.next;
                    prev = prev.next;
                }

                return slow;
            }
        }

        return null;
    }
}