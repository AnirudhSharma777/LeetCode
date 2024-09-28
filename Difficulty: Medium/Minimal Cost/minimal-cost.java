//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(arr,n-1,k,dp);
    }
    
    public int helper(int[] arr,int ind,int k,int[] dp){
        
        if(ind == 0){
            return 0;
        }
        
        if(dp[ind] != -1){
            return dp[ind];
        }
        
        
        int min = Integer.MAX_VALUE;
        int cur = Integer.MAX_VALUE;
        
        for(int j = 1; j<=k; j++){
            if(ind-j >= 0){
                cur = helper(arr,ind-j,k,dp) + Math.abs(arr[ind]-arr[ind-j]);
                min = Math.min(cur,min);
            }
            dp[ind] = min;
        }
        
        return dp[ind];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends