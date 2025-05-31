/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {

    if(head == null || head.next == null || k == 0){
        return head;
    }

    let length = 1;
    let cur = head;
    while(cur.next != null){
        cur = cur.next;
        length++;
    }


    cur.next = head;

    k= k % length;

    let steptoFindTail = length - k;
    let newHead = null;

    for(let i = 0; i<steptoFindTail; i++){
        cur = cur.next;
    }

    newHead = cur.next;
    cur.next = null;

    return newHead;
    
};