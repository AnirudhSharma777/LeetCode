/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node removeDuplicates(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node cur = head;
        
        while(cur.next != null){
            if(cur.data == cur.next.data){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        
        return head;
    }
}