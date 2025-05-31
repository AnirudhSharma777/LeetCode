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
    private int length(ListNode head){  // O(n) n is number of nodes
        ListNode cur = head;
        int cnt = 0;
        while(cur != null){
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    private ListNode DeleteNode(ListNode head,int pos){ // tc : O(n) & I am using recursion so sc: O(n) 
        if(head == null && pos > 0){
            return null;
        }
        if(pos == 0){
            return head.next;
        }
        else{
            head.next = DeleteNode(head.next,pos-1);
            return head;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) { // O(n)
        int size = length(head);
        return DeleteNode(head,size-n);
    }
}