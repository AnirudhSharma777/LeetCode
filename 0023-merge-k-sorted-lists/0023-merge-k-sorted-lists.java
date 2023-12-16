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
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++){
            head = merge(head,lists[i]);
        }
        return head;
    }
    
    private ListNode merge(ListNode A,ListNode B){
        if(A == null){
            return B;
        }
        if(B == null){
            return A;
        }
        ListNode head = null;
        if(A.val <= B.val){
            head = A;
            head.next = merge(A.next,B);
        }
        else{
            head = B;
            head.next = merge(A,B.next);
        }
        return head;
    }
}