/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // TC : O(n)
    // SC : O(n)
    public Node copyRandomList(Node head) {
         if(head == null){
            return head;
        }
        HashMap<Node,Node> hm = new HashMap<>();
        Node temp = head;
        Node cur = new Node(temp.val);
        hm.put(temp,cur);
        
        while(temp.next != null){
            cur.next = new Node(temp.next.val);
            cur = cur.next;
            temp = temp.next;
            hm.put(temp,cur);
        }
        
        temp = head;
        while(temp != null){
            hm.get(temp).random = hm.get(temp.random);
            temp = temp.next;
        }
        return hm.get(head);
    }
}