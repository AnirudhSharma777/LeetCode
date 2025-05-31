/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {

    // check if head is null or head.next is null
    if(head == null || head.next == null){
        return;
    }

    // find the middle 
    let slow = head, fast = head;

    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    let first = head;
    let second = slow.next;
    slow.next = null;

    // reverse the second half
    let prev = null, cur = second;
    while(cur != null){
        let Next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = Next;
    }

    second = prev;

    // merge the first and second half
    while(second != null){
        let temp1 = first.next;
        let temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;
    }
};