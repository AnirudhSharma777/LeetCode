//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    
    private static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node cur = head;
        Node prev = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        if(head == null){
            Node newnode = new Node(1);
            return newnode;
        }
        
        head = reverseLL(head);
        
        Node cur = head; 
        Node prev = head;
        
        int carry = 0;
        while(cur != null){
            int sum = 0;
            if(cur == prev){
                sum = cur.data + 1;
                carry = sum / 10;
                cur.data = sum % 10;
            }
            else{
                sum = carry + cur.data;
                carry = sum /10;
                cur.data = sum % 10;
            }
            prev = cur;
            cur = cur.next;
        }
        if(carry != 0){
            prev.next = new Node(carry);
        }
        return reverseLL(head);
    }
}
