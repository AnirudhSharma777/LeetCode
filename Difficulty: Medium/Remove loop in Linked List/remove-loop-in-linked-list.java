/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        // code here
        if(head == null || head.next == null){
            return;
        }
        
        Node slow = head;
        Node fast = head;
        boolean loop = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                loop = true;
                break;
            }
        }
        
        if(!loop){
            return;
        }
        
        slow = head;
        
        if(slow == fast){
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        
        while(fast.next != slow.next){
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = null;
    }
}