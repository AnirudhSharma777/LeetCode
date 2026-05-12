/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null ){
            return head;
        }
        
        Node cur = head;
        Node prev = null;
        Node next = null;
        int cnt = 0;
        
        while( cnt < k && cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
            cnt++;
        }
        
        if(next != null){
            head.next = reverseKGroup(next,k);
        }
        
        return prev;
    }
}