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
    
    public ListNode findMid(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode first = head;
        ListNode second = mid.next;
         mid.next = null;
        first = sortList(first);
        second = sortList(second);
        ListNode finalNode = merge(first,second);
        return finalNode;
    }
    
    public ListNode merge(ListNode a,ListNode b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        ListNode head = null;
        if(a.val <= b.val){
            head = a;
            head.next = merge(a.next,b);
        }
        else{
            head = b;
            head.next = merge(a,b.next);
        }
        return head;
    }
}