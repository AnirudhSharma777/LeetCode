//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends




class Solution
{
    static int mod = 1000000007;
    //Function to count number of ways to reach the nth stair.
    // Using Recursion
    // Tc: O(2^n) its give TLE
    // int countWays(int n){
    //     return helper(n);
    // }
    
    // int helper(int n){
    //     if(n == 0 || n == 1){
    //         return 1;
    //     }
        
    //     return helper(n-1) + helper(n-2);
    // }
    
    // Using Recursion + Memoization
    // Tc: O(n) & sc : O(n)
    // int countWays(int n){
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(n,dp);
    // }
    
    // int helper(int n,int[] dp){
    //     if(n == 0 || n == 1){
    //         return 1;
    //     }
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
        
    //     dp[n] = (helper(n-1,dp) + helper(n-2,dp)) % mod;
        
    //     return dp[n];
    // }
    
    // using tabulation
    // Tc: O(n) & sc : O(n)
    // int countWays(int n){
    //     int[] dp = new int[n+1];
    //     dp[0] = 1;
    //     dp[1] = 1;
        
    //     for(int i = 2; i<=n; i++){
    //         dp[i] = (dp[i-1] + dp[i-2]) % mod;
    //     }
    //     return dp[n];
    // }
    
    
    // space optimization
    // tc: O(n) & now sc : O(1)
    int countWays(int n){
        
        int prev1 = 1;
        int prev2 = 1;
        
        for(int i = 2; i<=n; i++){
            int climb = (prev1 + prev2) % mod;
            prev1 = prev2;
            prev2 = climb;
        }
        return prev2;
    }
    
    
    
}
