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
    private ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode chotahead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return chotahead;
    }
    
    private ListNode findMiddleElement(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode temp = head,mid = null;
        mid = findMiddleElement(head);
        ListNode revmid = reverseLinkedList(mid.next);
        while(revmid != null){
            if(revmid.val != temp.val){
                return false;
            }
            revmid = revmid.next;
            temp = temp.next;
        }
        return true;
    }
}