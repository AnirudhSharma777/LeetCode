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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0){
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }

        cur.next = head;

        k = k % len;

        int stepToFindTail = len - k;

        ListNode newhead = null;

        for(int i = 0; i<stepToFindTail; i++){
            cur = cur.next;
        }

        newhead = cur.next;

        cur.next = null;

        return newhead;
    }
}