//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node reverseLL(Node head){
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
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        first = reverseLL(first);
        second = reverseLL(second);
        
        int carry = 0;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(first != null || second != null){
            int sum = 0;
            if(first != null){
                sum += first.data;
                first = first.next;
            }
            if(second != null){
                sum += second.data;
                second = second.next;
            }
            
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        
        if(carry != 0){
            temp.next = new Node(carry);
        }
        return reverseLL(dummy.next);
        // return head of sum list
        
    }
}