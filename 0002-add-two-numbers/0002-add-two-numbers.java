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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        recursiveAdd(l1, l2, l3, 0);
        return l3;
    }
    
     private void recursiveAdd(ListNode l1, ListNode l2, ListNode l3, int carryOver){
        //calculate value of the current digit
        l3.val = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryOver) % 10;

        //calculate carry over to the next digit
        int carryOverNew = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryOver) / 10;

        //take the next digit from the two operands
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;

        //another digit is only needed if at least one these are true:
        //1. the first operand has another digit
        //2. the second operand has another digit
        //3. the carry over is more than zero
        if (l1 != null || l2 != null || carryOverNew > 0) {
            //only create another digit when it is needed
            l3.next = new ListNode(0);
            recursiveAdd(l1, l2, l3.next, carryOverNew);
        }
     }
}