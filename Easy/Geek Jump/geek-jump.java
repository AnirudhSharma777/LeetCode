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
    public int minimumEnergy(int arr[],int N){
        //code here
        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        return helper(arr,N-1,dp);
    }
    
    private int helper(int[] height,int i,int[] dp){
        if(i == 0){
            return 0; 
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        int left = helper(height,i-1,dp) + Math.abs(height[i]-height[i-1]);
        int right = Integer.MAX_VALUE;
        if(i > 1){
            right = helper(height,i-2,dp) + Math.abs(height[i]-height[i-2]);
        }
        
        dp[i] = Math.min(left,right);
        
        return dp[i];
    }
}