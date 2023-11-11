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
    
    // Approach
    //     step 1: reverse LL
    //     step 2: 
    //     step 3: reverse LL and return head
    
    // time complexity is O(n);
    // space complexity is O(1);
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode cur = head,prev = null,next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    public ListNode removeNodes(ListNode head) {
        
        ListNode dummy = reverse(head);
        ListNode cur = dummy,prev = null;
        int data = cur.val;
        while(cur != null){
            if(cur.val < data){
                prev.next = cur.next;
            }
            else{
                data = Math.max(data,cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        
        head = reverse(dummy);
        return head;
    }
}