//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    
    // using recursion
    // tc:O(k^n) & sc: O(k*n)
    // public int minimizeCost(int arr[],int N,int K){
    //     //code here
    //     return helper(arr,N-1,K);
    // }
    
    // private int helper(int[] arr,int idx,int k){
        
    //     if(idx == 0){
    //         return 0;
    //     }
        
    //     int min = Integer.MAX_VALUE;
    //     int cur = Integer.MAX_VALUE;
        
        
    //     for(int j = 1; j<=k; j++){
    //         if(idx-j >= 0){
                
    //             cur = helper(arr,idx-j,k)+Math.abs(arr[idx] - arr[idx-j]);
    //             min = Math.min(min,cur);
    //         } 
    //     }
        
    //     return min;
    // }
    
    
    // using recursion + memoization
    // tc:O(n*k) sc:O(n)
    // public int minimizeCost(int arr[],int N,int K){
    //     //code here
    //     int[] dp = new int[N];
    //     Arrays.fill(dp,-1);
    //     return helper(arr,N-1,K,dp);
    // }
    
    // public int helper(int[] arr,int idx,int k,int[] dp){
        
    //     if(idx == 0){
    //         return 0;
    //     }
        
    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
        
    //     int cur = Integer.MAX_VALUE;
    //     int min = Integer.MAX_VALUE;
        
    //     for(int j = 1; j<=k; j++){
    //         if(idx-j >= 0){
    //             cur = helper(arr,idx-j,k,dp) + Math.abs(arr[idx] - arr[idx-j]);
    //             min = Math.min(min,cur);
    //         }
            
    //         dp[idx] = min;
    //     }
    //     return dp[idx];
    // }
    
    
    // using tabulation
    // TC:O(n*k) & sc:O(n)
    public int minimizeCost(int arr[],int N,int K){
        //code here
        int[] dp = new int[N];
        dp[0] = 0;
        
        
        
        for(int i = 1; i<N; i++){
            
            int min = Integer.MAX_VALUE;
            int cur = Integer.MAX_VALUE;
            
            for(int j = 1; j<=K; j++){
                if(i-j >= 0){
                    cur = Math.abs(arr[i] - arr[i-j]) + dp[i-j];
                    min = Math.min(cur,min);
                }
                dp[i] = min;
            }
           
        }
        
        return dp[N-1];
        
    }
    
}

