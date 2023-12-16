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
    public ListNode[] splitListToParts(ListNode head, int k) {
        //step 1 : calculate the length of the linked list
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }        
        // step 2: Determine the size of the part
        int partsize = len/k;
        int largePartsize = len % k;
        
        // step 3 :initialization of the array
        ListNode[] listArray = new ListNode[k];
     
        cur = head;
        // step 4 : iterate the listNode
        for(int i = 0; i<k; i++){
            int subListsize =  (i < largePartsize) ? (partsize + 1) : partsize;
            if(subListsize == 0){
                listArray[i] = null;
            }
            else{
                ListNode subList = cur;
                for(int j = 0; j < subListsize - 1; j++){
                    cur = cur.next;
                }
                ListNode newNode = cur.next;
                cur.next = null;
                listArray[i] =  subList;
                cur = newNode;
            }
        }
        
        return listArray;
        
    }
}