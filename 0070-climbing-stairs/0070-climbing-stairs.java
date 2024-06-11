class Solution {
    
    // tc : O(2^n)
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return helper(n,dp);
//     }
    
//     private int helper(int n,int[] dp){
//         if(n == 0 || n == 1){
//             return 1;
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         dp[n] = helper(n-1,dp) + helper(n-2,dp);
//         return dp[n];
//     }
    
    
    // iterative tc: O(n)
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
        
    }
}   