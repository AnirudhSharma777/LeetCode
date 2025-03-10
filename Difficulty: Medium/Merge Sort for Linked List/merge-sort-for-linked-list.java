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


// } Driver Code Ends

/*
The structure of linked list is the following

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
    
    static Node findMid(Node head){
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
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node mid = findMid(head);
        Node first = head;
        Node second = mid.next;
        mid.next = null;
        first = mergeSort(first);
        second = mergeSort(second);
        
        return merge(first,second);
    }
    
    static Node merge(Node a,Node b){
        if(a == null){
            return b;
        }
        
        if(b == null){
            return a;
        }
        
        Node head = null;
        if(a.data <= b.data){
            head = a;
            head.next = merge(a.next,b);
        }
        else{
            head = b;
            head.next = merge(a,b.next);
        }
        return head;
    }
    
    
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends