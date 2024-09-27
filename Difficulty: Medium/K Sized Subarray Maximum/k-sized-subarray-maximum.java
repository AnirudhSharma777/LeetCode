//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA


class Pair{
    int idx;
    int val;
    public Pair(int idx,int val){
        this.idx = idx;
        this.val = val;
    }
}

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int k, int[] arr) 
    {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->b.val-a.val);
        
        for(int i = 0; i<k; i++){
            pq.offer(new Pair(i,arr[i]));
        }
        
        ans.add(pq.peek().val);
        
        for(int i = k; i<n; i++){
            while(!pq.isEmpty() && pq.peek().idx<= i-k){
                pq.poll();
            }
            pq.offer(new Pair(i,arr[i]));
            ans.add(pq.peek().val);
        }
        return ans;
    }
}