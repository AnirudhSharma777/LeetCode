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
    
    private int length(ListNode head){
        int cnt = 0;
        while(head != null){
            head = head.next;
            cnt++;
        }
        return cnt;
    }
    
    private ListNode deleteNode(ListNode head,int k){
        if(head == null && k > 0){
            return null;
        }
        if(k == 0){
            return head.next;
        }else{
            head.next = deleteNode(head.next,k-1);
            return head;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);
        return deleteNode(head,size - n);
    }
}