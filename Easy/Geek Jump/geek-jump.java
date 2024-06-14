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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    // Using recursion + memoization
    // Tc : O(n) & sc: O(n)
    // public int minimumEnergy(int arr[],int N){
    //     //code here
    //     int[] dp = new int[N+1];
    //     Arrays.fill(dp,-1);
    //     return helper(N-1,arr,dp);
    // }
    
    // private int helper(int n,int[] height,int[] dp){
        
    //     if(n == 0){
    //         return 0;
    //     }
        
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
        
    //     int singleSteps = helper(n-1,height,dp) + Math.abs(height[n] - height[n-1]);
    //     int doubleSteps = Integer.MAX_VALUE;
    //     if(n > 1){
    //         doubleSteps = helper(n-2,height,dp) + Math.abs(height[n] - height[n-2]);
    //     }
        
    //     dp[n] = Math.min(singleSteps,doubleSteps);
    //     return dp[n];
    // }
    
    // tabulation Solution
    // Tc : O(n) & sc:O(n)
    // public int minimumEnergy(int[] height,int n){
        
    //     int[] dp = new int[n+1];
    //     dp[0] = 0;
        
    //     for(int i = 1; i<=n-1; i++){
    //         int left = dp[i-1] + Math.abs(height[i] - height[i-1]);
    //         int right = Integer.MAX_VALUE;
    //         if(i > 1){
    //             right = dp[i-2] + Math.abs(height[i] - height[i-2]);
    //         }
            
    //         dp[i] = Math.min(left,right);
    //     }
        
    //     return dp[n-1];
    // }
    
    
    // space optimization
    // tc : O(n) & sc:O(1)
    public int minimumEnergy(int[] height,int n){
        
        int prev = 0;
        int prev2 = 0;
        
        for(int i = 1; i<=n-1; i++){
            int left = prev + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2 + Math.abs(height[i] - height[i-2]);
            }
            
            int cur = Math.min(left,right);
            prev2 = prev;
            prev = cur;
        }
        
        return prev;
    }
    
}
