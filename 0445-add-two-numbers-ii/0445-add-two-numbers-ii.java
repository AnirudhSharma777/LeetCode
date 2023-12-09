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
    private ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode chotahead = reverseLL(head.next);
        head.next.next = head;
        head.next =null;
        return chotahead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseLL(l1);
        ListNode head2 = reverseLL(l2);
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        
        int carry = 0;
        while(head1 != null || head2 != null){
            int sum = 0;
            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        if(carry != 0){
            ListNode rem = new ListNode(carry);
            temp.next = rem;
        }
        return reverseLL(dummy.next);
    }
}