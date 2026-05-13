/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        if(head == null || head.next == null){
            return head;
        }
        
        Set<Integer> set = new HashSet<>();
        
        Node cur = head;
        Node prev = null;
        while(cur != null){
            if(set.contains(cur.data)){
                prev.next = cur.next;
            }
            else{
                set.add(cur.data);
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}