//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
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

class Solution {
    
    Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node chotaHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return chotaHead;
    }
    public Node addOne(Node head) {
        // code here.
        if(head == null){
            return new Node(1);
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
                sum = carry+cur.data;
                carry = sum / 10;
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
