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
    //Function to add two numbers represented by linked list.
    static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node chotahead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return chotahead;
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        Node f = reverseLL(first);
        Node s = reverseLL(second);
        
        int carry = 0;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(f != null || s != null){
            int sum = 0;
            if(f != null){
                sum += f.data;
                f = f.next;
            }
            if(s != null){
                sum += s.data;
                s = s.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        
        if(carry != 0){
            Node node = new Node(carry);
            temp.next = node;
        }
        
        
        return reverseLL(dummy.next);
        // return head of sum list
    }
}