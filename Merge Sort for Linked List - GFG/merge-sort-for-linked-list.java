//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node findMiddle(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node mergeTwoSortedList(Node a,Node b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        Node head = null;
        if(a.data <= b.data){
            head = a;
            head.next = mergeTwoSortedList(a.next,b);
        }
        else{
            head = b;
            head.next = mergeTwoSortedList(a,b.next);
        }
        return head;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node mid = findMiddle(head);
        Node middle = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(middle);
        Node ans = mergeTwoSortedList(left,right);
        return ans;
    }
}


