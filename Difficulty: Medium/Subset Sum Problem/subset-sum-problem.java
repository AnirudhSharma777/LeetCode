//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum+1];
        for(int[] it : dp){
            Arrays.fill(it,-1);
        }
        return helper(N-1,arr,sum,dp);
    }
    
    static boolean helper(int index,int[] arr,int target,int[][] dp){
        
        if(target ==  0){
            return true;
        }
        if(index == 0){
            return arr[0] == target;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false:true;
        }
        
        boolean not_take = helper(index-1,arr,target,dp);
        boolean take = false;
        if(arr[index] <= target){
            take = helper(index-1,arr,target-arr[index],dp);
            dp[index][target] = not_take || take ? 1 : 0;
        }
        
        
        return take || not_take;
    }
}