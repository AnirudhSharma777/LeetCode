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
    
    private ListNode reverse(ListNode head,int k){
        
        int cnt = 0;
        ListNode prev = null ,cur = head,next = null;
        while(cnt < k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int cnt = 0;
        ListNode cur = head;
        
        while(cnt < k){
            if(cur == null){
                return head;
            }
            cur = cur.next;
            cnt++;
        }
        
        ListNode temp = this.reverse(head,k);
        head.next = this.reverseKGroup(cur,k);
        return temp;
        
    }
}