//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

class GFG {
    public static void printList(Node node) {
        Node tmp = node;
        int c1 = 0, c2 = 0;
        if (tmp != null) {
            while (tmp.next != null) {
                c1++;
                tmp = tmp.next;
            }
            while (tmp.prev != null) {
                c2++;
                tmp = tmp.prev;
            }
            if (c1 != c2) {
                System.out.println("-1");
                return;
            }
        }
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            Node ans = obj.constructDLL(arr);
            printList(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node tail = head;
        int i = 1;
        while(i < n){
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            i++;
        }
        return head;
    }
}