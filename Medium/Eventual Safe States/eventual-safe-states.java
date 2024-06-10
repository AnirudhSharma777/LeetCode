//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int[] vis = new int[V];
        Arrays.fill(vis,0);
        int[] check = new int[V];
        
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(i,vis,check,adj);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < V){
            
            if(check[i] == 1){
                ans.add(i);
            }
            i++;
        }
        
        return ans;
    }
    
    
    private boolean dfs(int n,int[] visited,int[] check,List<List<Integer>> adj){
        visited[n] = 2;
        check[n]= 0;
        
        for(Integer nbr : adj.get(n)){
            if(visited[nbr] == 0 && dfs(nbr,visited,check,adj)){
                return true;
            }
            else if(visited[nbr] == 2){
                return true;
            }
        }
        
        visited[n] = 1;
        check[n] = 1;
        return false;
    }
}
