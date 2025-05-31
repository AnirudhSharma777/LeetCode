/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    
    if(head == null || head.next == null){
        return true;
    }

    // find the middle
    let slow = head, fast = head;
    while(fast.next != null && fast.next.next != null) {
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

    while(second != null){
        if(first.val != second.val){
            return false;
        }
        first = first.next;
        second = second.next;
    }

    return true;
};